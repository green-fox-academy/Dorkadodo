import java.util.Scanner;

public class GreatestCommonDivisor {
    // Find the greatest common divisor of two numbers using recursion.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide two numbers:");
        System.out.println("Number 1:");
        int num1 = scanner.nextInt();
        System.out.println("Number 2:");
        int num2 = scanner.nextInt();
        if (num1 > num2) {
            int c = num1;
            num1 = num2;
            num2 = c;
        }
        int counter = num1;
        System.out.println(greatestCommonDivisor(num1, num2, counter));
    }

    private static int greatestCommonDivisor(int num1, int num2, int counter) {
        if (counter == 1) {
            return 1;
        }
        int divisor = greatestCommonDivisor(num1, num2, counter - 1);
        if (counter > 1) {
            if ((num1 % counter == 0) && (num2 % counter == 0)) {
                divisor = counter;
            }
        }
        return divisor;
    }
}
