import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TicTacToeWins {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("win.txt");
            final char player1 = 'X';
            final char player2 = 'O';
            List<String> rows = Files.readAllLines(path);
            char[][] steps = fileToCharArray(rows);
            boolean player1wins = false;
            boolean player2wins = false;
            columnWins(player1, steps);
            columnWins(player2, steps);
            rowWins(player1, steps);
            rowWins(player2, steps);

            //for (int i = 0; i < 3; i++) {
            //System.out.println(Arrays.toString(steps[i]));
            //}

        } catch (IOException ex) {
            System.out.println("Sorry, something wnet wrong with the file win.txt");
        }
    }

    public static char[][] fileToCharArray(List<String> rows) {
        char[][] steps = new char[3][3];
        for (int i = 0; i < 3; i++) {
            steps[i] = rows.get(i).toCharArray();
        }
        return steps;
    }

    public static boolean columnWins(char player, char[][] steps) {
        int[] columnWins = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (steps[i][j] == player) {
                    columnWins[j]++;
                }
            }
        }
        boolean contains = false;
        for (int stepCount : columnWins) {
            if (stepCount == 3) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public static boolean rowWins(char player, char[][] steps) {
        int[] rowWins = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (steps[i][j] == player) {
                    rowWins[i]++;
                }
            }
        }
        boolean contains = false;
        for (int stepCount : rowWins) {
            if (stepCount == 3) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}