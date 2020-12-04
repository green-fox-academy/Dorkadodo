import java.util.Scanner;

public class NumberAdder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a number:");
        int num = scanner.nextInt();
        System.out.println(numberAdder(num));
    }

    private static int numberAdder(int n) {
        if (!(n==0)){
            n=numberAdder(n-1)+n;
        }
        return n;
    }
}
