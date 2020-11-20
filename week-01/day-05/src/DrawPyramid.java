import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rows should there be?");
        int num = scanner.nextInt();

        for (int i = 1; i < (num + 1); i++) {
            int j;
            for (j = 0; j < (num - i); j++) {
                System.out.print(" ");
            }
            for (j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
