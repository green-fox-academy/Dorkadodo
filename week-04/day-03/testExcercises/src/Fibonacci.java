import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a positive, not 0 number:");
        int num = scanner.nextInt();
        int result = 0;
        System.out.println(fibonacci(num, result));
    }

    public static int fibonacci(int n, int result) {
        if ((n > 3)) {
            result = fibonacci(n - 1, result) + fibonacci(n - 2, result);
        } else if (n == 1) {
            result = 0;
        } else {
            result = 1;
        }
        return result;
    }
}
