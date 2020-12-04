import java.util.Scanner;

public class BunniesAgain {
    // We have bunnies standing in a line,
// numbered 1, 2, 3, 4, ...
// The odd bunnies (1, 3, ...) have the normal 2 ears.
// The even bunnies (2, 4, ..) we'll say have 3 ears,
// because they each have a raised foot.
// Recursively return the number of "ears" in
// the bunny line 1, 2, ... n (without loops or multiplication).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a number:");
        int num = scanner.nextInt();
        System.out.println(bunnies(num));
    }

    public static int bunnies(int n) {
        if (!(n == 0)) {
            if (n % 2 == 1) {
                n = bunnies(n - 1) + 2;
            } else {
                n = bunnies(n - 1) + 3;
            }
        }
        return n;
    }
}
