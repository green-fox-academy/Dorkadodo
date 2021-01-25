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

//    public SithText translateToSith(Text text) {
//        String toTranslate = text.getText();
//        String[] sentencesToTranslate = toTranslate.split(". ");
//        List<String> transLatedSentences = new ArrayList<>();
//        for (String sentence : sentencesToTranslate) {
//            List<String>words = Arrays.asList(sentence.split(" "));
//            for (int i = 0; i < words.size() % 2; i++) {
//                Collections.swap(words, i * 2, i * 2 + 1);
//            }
//            String translatedSentence = words.stream()
//                    .collect(Collectors.joining(" ", "", ". "));
//            translatedSentence.substring(0,1).toUpperCase();
//
//            transLatedSentences.add(translatedSentence);
//
//    }

}
