import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first word: ");
        String word1 = scanner.next();
        System.out.println("Enter the second word: ");
        String word2 = scanner.next();

        boolean isAnagram = false;
        if (word1.equals(null) || word2.equals(null)){
            throw new NullPointerException();
        }

        if (hasEqualLength(word1, word2)){
            isAnagram=anagram(word1, word2);
        }

        System.out.println("The words are an anagram of each other: " + isAnagram);
    }

    private static boolean hasEqualLength(String word1, String word2) {
        return (word1.length() == word2.length());
    }

    public static boolean anagram(String word1, String word2) {
        List<Character> charWord1 = getCharacterArray(word1);
        List<Character> charWord2 = getCharacterArray(word2);
        final int size = charWord1.size();

        for (int i = size-1; i >=0; i--) {
            for (int j = i; j >=0; j--) {
                if (charWord1.get(i).equals(charWord2.get(j))) {
                    charWord1.remove(i);
                    charWord2.remove(j);
                    break;
                }
            }
        }

        if (charWord1.isEmpty() && charWord2.isEmpty()) {
            return true;
        }
        return false;
    }

    private static List<Character> getCharacterArray(String word1) {
        List<Character> charWord2 = new ArrayList<>();
        for (int i = 0; i < word1.length(); i++) {
            charWord2.add(word1.charAt(i));
        }
        return charWord2;
    }
}
