import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        System.out.println("Please write your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }
}