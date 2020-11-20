import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {

        // Write a program that asks for a number.
        // It would ask this many times to enter an integer,
        // if all the integers are entered, it should print the sum and average of these
        // integers like:
        //
        // Sum: 22, Average: 4.4

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write a number: ");
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            System.out.println("Please enter an integer");
            int num2 = scanner.nextInt();
            sum = sum + num2;
        }
        double average = (double) sum / num;
        System.out.println("Sum: " + sum + ", Average: " + average);
    }
}
