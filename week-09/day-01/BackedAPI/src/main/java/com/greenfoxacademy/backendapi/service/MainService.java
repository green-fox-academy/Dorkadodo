package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.model.*;
import com.greenfoxacademy.backendapi.repo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class MainService {

    @Autowired
    private LogRepository logRepository;

    public ChangedValue doubledValue(Integer input) {
        ChangedValue changedValue = new ChangedValue();
        changedValue.setReceived(input);
        changedValue.setResult(input * 2);
        return changedValue;
    }

    public ErrorMessage error(String message) {
        return new ErrorMessage(message);
    }

    public Greeter getGreetingMessage(String name, String title) {
        Greeter greeter = new Greeter();
        greeter.setWelcome_message(name, title);
        return greeter;
    }

    public Append appendString(String appendable) {
        return new Append(appendable);
    }

    public ChangedResult resultUntil(Integer changeUntil, String action) {
        switch (action) {
            case "sum": {
                return sumUntil(changeUntil);
            }
            case "factor": {
                return factorUntil(changeUntil);
            }
            default:
                return null;
        }
    }

    private ChangedResult sumUntil(Integer changeUntil) {
        Integer result = 0;
        for (int i = 1; i <= changeUntil; i++) {
            result += i;
        }
        return new ChangedResult(result);
    }

    private ChangedResult factorUntil(Integer changeUntil) {
        Integer result = 1;
        for (int i = 1; i <= changeUntil; i++) {
            result = result * i;
        }
        return new ChangedResult(result);
    }

    public ChangedArrayResult arrayDoubler(ArrayToChange arrayToChange) {
        Integer[] result = new Integer[arrayToChange.getNumbers().length];
        for (int i = 0; i < arrayToChange.getNumbers().length; i++) {
            result[i] = arrayToChange.getNumbers()[i] * 2;
        }
        return new ChangedArrayResult(result);
    }

    public ChangedResult arrayChanger(ArrayToChange arrayToChange) {
        if (arrayToChange.getWhat().equals("sum")) {
            return sumArray(arrayToChange.getNumbers());
        }
        if (arrayToChange.getWhat().equals("multiply")) {
            return multiplyArray(arrayToChange.getNumbers());
        }
        return null;
    }

    private ChangedResult sumArray(Integer[] arrayToChange) {
        Integer result = 0;
        for (int i = 0; i < arrayToChange.length; i++) {
            result += arrayToChange[i];
        }
        return new ChangedResult(result);
    }

    private ChangedResult multiplyArray(Integer[] arrayToChange) {
        Integer result = 1;
        for (int i = 0; i < arrayToChange.length; i++) {
            result = result * arrayToChange[i];
        }
        return new ChangedResult(result);
    }

    public void addToLog(String endpoint, String data) {
        logRepository.save(new Log(endpoint, data));
    }

    public logResultDisplayer getLogResults(String count, String page) {
        Long countNumber = stringToPositiveLong(count);
        Long pageNumber = stringToPositiveLong(page);
        if (countNumber == null) {
            return new logResultDisplayer((List<Log>) logRepository.findAll());
        }
        if (pageNumber == null || (pageNumber > (logRepository.count() / countNumber) + 1)) {
            return new logResultDisplayer((List<Log>) logRepository.findAllWithCount(countNumber));
        }
        return new logResultDisplayer((List<Log>) logRepository.findAllWithCountAndPage(countNumber, (pageNumber - 1) * countNumber));
    }

    private Long stringToPositiveLong(String stringToChange) {
        Long number;
        try {
            number = Long.valueOf(stringToChange);
            if (number < 0) {
                number = null;
            }
        } catch (NumberFormatException | NullPointerException ex) {
            number = null;
        }
        return number;
    }

    public SithText translateToSith(Text text) {
        List<String> sentencesToTranslate = Arrays.asList(text.getText().trim().split("\\. "));
        String lastSentence = sentencesToTranslate.get(sentencesToTranslate.size() - 1);
        sentencesToTranslate.set(sentencesToTranslate.size() - 1, lastSentence.replaceAll("\\.", ""));
        List<String> translatedSentences = new ArrayList<>();

        Random random = new Random();
        List<String> randomSentenceList = getRandomSentenceList();

        for (String sentence : sentencesToTranslate) {
            String translatedSentence = getSwappedSentence(sentence);
            translatedSentence += randomSentenceList.get(random.nextInt(randomSentenceList.size()));
            translatedSentences.add(translatedSentence);
        }

        String translatedString = translatedSentences.stream()
                .collect(Collectors.joining()).trim();

        return new SithText(translatedString);
    }

    private String getSwappedSentence(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));
        String translatedSentence = swapWords(words).stream()
                .collect(Collectors.joining(" ", "", ". "));
        translatedSentence = translatedSentence.substring(0, 1).toUpperCase() + translatedSentence.substring(1).toLowerCase();
        return translatedSentence;
    }

    private List<String> swapWords(List<String> words) {
        for (int i = 0; i < words.size() / 2; i++) {
            Collections.swap(words, i * 2, i * 2 + 1);
        }
        return words;
    }

    private List<String> getRandomSentenceList() {
        List<String> randomSentenceList = new ArrayList<>();
        randomSentenceList.add("Well. ");
        randomSentenceList.add("Ummm. ");
        randomSentenceList.add("Hmm. ");
        randomSentenceList.add("Err. ");
        randomSentenceList.add("Huh. ");
        randomSentenceList.add("I mean. ");
        randomSentenceList.add("You know. ");
        randomSentenceList.add("I suppose. ");
        randomSentenceList.add("Right. ");
        return randomSentenceList;
    }

    public TranslatedText translateToWeirdLanguage(ReceivedForTranslation receivedForTranslation) {
        switch (receivedForTranslation.getLang()) {
            case "hu": {
                return new TranslatedText(translateToTeve(receivedForTranslation.getText()), "teve");
            }
            case "en": {
                return new TranslatedText(translateToGibberish(receivedForTranslation.getText()), "gibberish");
            }
            default:
                return null;
        }
    }

    private String translateToTeve(String textToTranslate) {
        List<String> textChars = textToStringList(textToTranslate);
        return addTeveCharsToString(textChars);
    }

    private String translateToGibberish(String textToTranslate) {
        List<String> textChars = textToStringList(textToTranslate);
        return addGibberishToString(textChars);
    }

    private List<String> textToStringList(String textToTranslate) {
        List<String> textChars = textToTranslate.chars()
                .mapToObj(e -> (char) e)
                .map(character -> character.toString())
                .collect(Collectors.toList());
        return textChars;
    }

    private String addTeveCharsToString(List<String> textChars) {
        List<String> huVowelsWithCapitals = getHuVowelList();
        String teveText = textChars.stream()
                .map(character -> huVowelsWithCapitals.contains(character) ? character + "v" + character.toLowerCase() : character)
                .collect(Collectors.joining());
        return teveText;
    }

    private String addGibberishToString(List<String> textChars) {
        List<String> enVowelsWithCapitals = getEnVowelList();
        for (int i = textChars.size() - 1; i >= 0; i--) {
            if (enVowelsWithCapitals.contains(textChars.get(i)) && (i == 0 || !(enVowelsWithCapitals.contains(textChars.get(i - 1))))) {
                if (((int) (textChars.get(i).charAt(0)) >= 65) && ((int) (textChars.get(i).charAt(0)) <= 90)) {
                    textChars.set(i, "Idig" + textChars.get(i).toLowerCase());
                } else {
                    textChars.set(i, "idig" + textChars.get(i));
                }
            }
        }
        return String.join("", textChars);
    }

    private List<String> getHuVowelList() {
        List<String> huVowels = Arrays.asList("a", "á", "e", "é", "i", "í", "o", "ó", "ö", "ő", "u", "ú", "ü", "ű");
        List<String> huVowelsWithCapitals = new ArrayList<>();
        huVowels.stream()
                .forEach(c -> {
                    huVowelsWithCapitals.add(c);
                    huVowelsWithCapitals.add(c.toUpperCase());
                });
        return huVowelsWithCapitals;
    }

    private List<String> getEnVowelList() {
        List<String> huVowels = Arrays.asList("a", "e", "i", "o", "u");
        List<String> huVowelsWithCapitals = new ArrayList<>();
        huVowels.stream()
                .forEach(c -> {
                    huVowelsWithCapitals.add(c);
                    huVowelsWithCapitals.add(c.toUpperCase());
                });
        return huVowelsWithCapitals;
    }

}
