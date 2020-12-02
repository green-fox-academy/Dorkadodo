import java.util.Scanner;

public class CreatePalindrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = scanner.next();
        System.out.println(palindrom(word));

    }

    public static String palindrom(String word) {
        char[] charWord = new char[2 * word.length()];
        for (int i = 0; i < word.length(); i++) {
            charWord[i] = word.charAt(i);
        }
        for (int i = word.length(); i < 2 * word.length(); i++) {
            charWord[i] = word.charAt(word.length() * 2 - 1 - i);
        }
        String palindrom = "";
        for (int i = 0; i < 2 * word.length(); i++) {
            palindrom += charWord[i];
        }
        return palindrom;
    }
}
