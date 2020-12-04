import java.util.Scanner;

public class SumDigit {
    // Given a non-negative integer n, return the sum of it's digits recursively
    // (without loops).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a number above 0:");
        int num = scanner.nextInt();
        System.out.println(sumDigits(num));
    }

    private static int sumDigits(int n) {
        if (!(n == 0)) {
            n = sumDigits(n / 10) + (n % 10);
        }
        return n;
    }
}
