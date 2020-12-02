import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int divisor = scanner.nextInt();
        try {
            System.out.println("10 / " + divisor + " = " + (10 / divisor));
        } catch (ArithmeticException ex) {
            System.out.println("fail");
        }
    }
}
