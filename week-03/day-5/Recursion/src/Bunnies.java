import java.util.Scanner;

public class Bunnies {
    // We have a number of bunnies and each bunny has two big floppy ears.
// We want to compute the total number of ears
// across all the bunnies recursively (without loops or multiplication).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a number:");
        int num = scanner.nextInt();
        System.out.println(bunnies(num));
    }

    public static int bunnies(int n) {
        if (!(n == 0)) {
            n = bunnies(n - 1) + 2;
        }
        return n;
    }
}
