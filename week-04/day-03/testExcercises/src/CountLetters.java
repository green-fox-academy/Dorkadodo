import java.util.HashMap;

public class CountLetters {
    public HashMap<Character, Integer> countLetters(String line) {
        if (line.equals(null)){
            throw new NullPointerException();
        }

        HashMap<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            if (dictionary.containsKey(line.charAt(i))) {
                dictionary.put(line.charAt(i), dictionary.get(line.charAt(i)) + 1);
            } else {
                dictionary.put(line.charAt(i), 1);
            }
        }
        return dictionary;
    }
}
