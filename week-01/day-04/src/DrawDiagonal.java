import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write a number: ");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            int j;
            if ((i == 1) || (i == num)) {                                     //első és utolsó sor végig csillag
                for (j = 0; j < num; j++) {
                    System.out.print("%");
                }
                System.out.println();
            } else {
                for (j = 0; j < num; j++) {
                    if ((j == 0) || (j == (num - 1)) || (i == j)) {           //a sor első és utolsó helye csillag
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
