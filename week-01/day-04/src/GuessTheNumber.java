import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int rand1 = rand.nextInt(10);

        System.out.println("Guess the number between 0 and 9: ");
        int num = scanner.nextInt();
        while (!(rand1 == num)) {
            if (rand1 > num) {
                System.out.println("The stored number is higher");
            } else {
                System.out.println("The stored number is lower");
            }
            System.out.println("Guess the number between 0 and 9: ");
            num = scanner.nextInt();
        }
        System.out.println("You found the number: " + rand1);

    }
}
