import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rows should there be (only odd numbers)?");
        int num = scanner.nextInt();

        // checking, whether the number is even
        while (num % 2 == 0) {
            System.out.println("Sorry, the number is even. Please type an odd number: ");
            num = scanner.nextInt();
        }

        for (int i = 1; i < (num + 1); i++) {
            int j;
            if (i <= num / 2 + 1) {
                for (j = 0; j < (num - (num / 2) - i); j++) {
                    System.out.print(" ");
                }
                for (j = 0; j < i * 2 - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (j = 0; j < (i - (num / 2) - 1); j++) {
                    System.out.print(" ");
                }
                for (j = 0; j < (num - i) * 2 + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}