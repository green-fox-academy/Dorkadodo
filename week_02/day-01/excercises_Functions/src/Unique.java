import java.util.Arrays;
import java.util.Scanner;

public class Unique {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as a parameter
        //  Returns a list of numbers where every number in the list occurs only once
        Scanner scanner = new Scanner(System.in);
        String[] original = new String[8];
        System.out.println("Please enter 8 numbers for the list.");
        for (int i = 0; i < original.length; i++) {
            original[i] = scanner.next();
        }

        System.out.println(Arrays.toString(unique(original)));
    }

    public static String[] unique(String[] original) {
        int counter = 0;
        String[] unique = new String[8];
        for (int i = 0; i < original.length; i++) {
            boolean notEqual = true;
            for (int j = i + 1; j < original.length; j++) {
                if (original[i].equals(original[j])) {
                    notEqual = false;
                }
            }
            if (notEqual) {
                unique[counter] = String.valueOf(original[i]);
                ++counter;
            }
        }
        String[] uniqueFinal = new String[counter];
        for (int i = 0; i < counter; i++) {
            uniqueFinal[i] = unique[i];
        }
        return uniqueFinal;
    }
}