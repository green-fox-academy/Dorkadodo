import java.sql.SQLOutput;
import java.util.Scanner;

public class SubStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write a sentence!");
        String input = scanner.nextLine();
        System.out.println("Now please write a word!");
        String q = scanner.nextLine();
        if (input.length() >= q.length()) {
            System.out.println("The index of the first letter of the word " +
                    "in the sentence is " + subStr(input, q));
        } else {
            System.out.println("The index of the first letter of the word " +
                    "in the sentence is -1");
        }

    }
    // Create a function that takes two strings as a parameter
    // Returns the starting index where
    // the second one is starting in the first one
    // Returns `-1` if the second string is not in the first one
    // Example:
    // should print: `17`
    //System.out.println(subStr("this is what I'm searching in", "searching"));
    // should print: `-1`
    // System.out.println(subStr("this is what I'm searching in", "not"));}

    public static int subStr(String input, String q) {
        int StartIndex = 0;

        while (!q.equals(input.substring(StartIndex, (StartIndex + q.length())))) {
            if (StartIndex <= (input.length() - q.length()) - 1) {
                StartIndex = StartIndex + 1;
            } else {
                break;
            }
        }
        if ((((input.length() - q.length())) > StartIndex) || q.equals(input.substring(StartIndex))) {
            return StartIndex + 1;
        } else {
            return -1;
        }
    }
}
