import java.util.Arrays;
import java.util.Scanner;

public class DiagonalMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        int[][] matrix = new int[num][num];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
