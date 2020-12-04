import java.util.Scanner;

public class Power {
// Given base and n that are both 1 or more, compute recursively (no loops) the
// value of base to the n power, so powerN(3, 2) is 9 (3 squared).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a base number:");
        int base = scanner.nextInt();
        System.out.println("Provide another number:");
        int num = scanner.nextInt();
        System.out.println(power(base, num));
    }

    public static int power(int base, int n) {
        if (!(n == 1)) {
            base = power(base, n - 1) * base;
        }
        return base;
    }
}
