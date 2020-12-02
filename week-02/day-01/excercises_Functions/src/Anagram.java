import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first word: ");
        String word1 = scanner.next();
        System.out.println("Enter the second word: ");
        String word2 = scanner.next();

        boolean result = false;

        if (word1.length() == word2.length()) {
            result = anagramma(word1, word2);
        }
        System.out.println("The words are an anagram of each other: " + result);
    }

    public static boolean anagramma(String word1, String word2) {
        char[] charWord1 = new char[word1.length()];
        for (int i = 0; i < word1.length(); i++) {
            charWord1[i] = word1.charAt(i);
        }

        char[] charWord2 = new char[word2.length()];
        for (int i = 0; i < word2.length(); i++) {
            charWord2[i] = word2.charAt(i);
        }

        for (int i = 0; i < charWord1.length; i++) {
            for (int j = 0; j < charWord1.length; j++) {
                if (charWord1[i] == charWord2[j]) {
                    charWord1[i] = ' ';
                    charWord2[j] = ' ';
                }
            }
        }
        boolean result = true;
        for (int i = 0; i < charWord1.length; i++) {
            if (!(charWord1[i] == charWord2[i])) {
                result = false;
            }
        }
        return result;
    }
}
