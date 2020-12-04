import java.util.Scanner;

public class Fibonacci {
    // The fibonacci sequence is a famous bit of mathematics,
// and it happens to have a recursive definition.
// The first two values in the sequence are 0 and 1 (essentially 2 base cases).
// Each subsequent value is the sum of the previous two values,
// so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
// Define a recursive fibonacci(n) method that
// returns the nth fibonacci number,
// with n=0 representing the start of the sequence.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a number:");
        int num = scanner.nextInt();
        int result = 0;
        System.out.println(fibonacci(num, result));
    }

    private static int fibonacci(int n, int result) {
        if ((n > 3)) {
            result = fibonacci(n - 1, result) + fibonacci(n - 2, result);
        } else {
            result = 1;
        }
        return result;
    }
}
