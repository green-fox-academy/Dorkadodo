import java.util.Scanner;

public class CountFromTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1;
        int num2;
        System.out.println("Please write a number: ");
        num1 = scanner.nextInt();
        System.out.println("Please write a bigger number: ");
        num2 = scanner.nextInt();
        while (num1 > num2) {
            System.out.println("The second number should be bigger!");
            System.out.println("Please write a bigger number: ");
            num2 = scanner.nextInt();
        }
        for (int i=num1;i<num2;i++){
            System.out.println(i);
        }
    }
}
