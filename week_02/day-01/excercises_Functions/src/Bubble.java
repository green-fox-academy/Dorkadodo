import java.util.Arrays;
import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] original = new int[8];
        System.out.println("Please enter 8 numbers for the list.");
        for (int i = 0; i < original.length; i++) {
            original[i] = scanner.nextInt();
        }
        System.out.println("Should it be in descending order? Write Yes or No.");
        String descending = scanner.next();
        boolean desc = false;
        if (descending.equals("yes")) {
            desc = true;
        }
        if (desc) {
            System.out.println(Arrays.toString(bubblereverse(original)));
        } else {
            System.out.println(Arrays.toString(bubble(original)));
        }


    }

    public static int[] bubble(int[] original) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (original[i] > original[j]) {
                    int a;
                    a = original[i];
                    original[i] = original[j];
                    original[j] = a;
                }
            }
        }
        return original;
    }

    public static int[] bubblereverse(int[] original) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (original[i] < original[j]) {
                    int a;
                    a = original[i];
                    original[i] = original[j];
                    original[j] = a;
                }
            }
        }
        return original;
    }
}
