import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int side = 10;
        printTable(generateTable(side));

    }

    private static void printTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.println(Arrays.toString((table)[i]));
        }
    }

    private static int[][] generateTable(int side) {
        int[][] fieldsAndWalls = new int[side][side];
        Random random = new Random();
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < 10; j++) {
                if (1 < random.nextInt(10)) {
                    fieldsAndWalls[i][j] = 0;
                } else {
                    fieldsAndWalls[i][j] = 1;
                }
            }
        }
        return fieldsAndWalls;
    }

    private static int[][] floodFillCheck(int[][] table) {
        table[0][0] = 0;
        int numberOfCorrectFields = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

            }
        }
        return table;
    }

    private static boolean isItAFreeField(int i, int j, int[][] table) {
        if ((j >= 0) && ((j) <= 10) && (i >= 0) && ((i) <= 10) && (table[i][j]) == 0) {
            return true;
        }
        return false;
    }

    private static int continueToNextField(int i, int j, int[][] table) {
        if (!(isItAFreeField(i, j - 1, table) && isItAFreeField(i, j + 1, table)
                && isItAFreeField(i + 1, j, table) && isItAFreeField(i - 1, j, table))) {
            int counter = 1;
            return counter;
        }

        isItAFreeField(i, j - 1, table) {
            isItAFreeField(i, j - 1, table);
        }
                    ||isItAFreeField(i, j + 1, table)
                || isItAFreeField(i - 1, j, table) || isItAFreeField(i + 1, j, table) ){
        }
    }
}
