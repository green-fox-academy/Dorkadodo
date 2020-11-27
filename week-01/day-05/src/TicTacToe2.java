import java.util.Scanner;

public class TicTacToe2 {
    public static void main(String[] args) {
        //draw the table
        drawTheTable();

        Scanner scanner = new Scanner(System.in);
        int[][] Steps = new int[2][9];
        int[][] Steps0 = new int[2][5];
        int[][] StepsX = new int[2][5];
        boolean winner = false;
        for (int step = 1; step < 10; step++) {            //get the step, check for issues, draw the table

            //get a number
            System.out.println("Row: ");
            int row = scanner.nextInt();
            System.out.println("Column: ");
            int column = scanner.nextInt();

            //check: between 1-3 and not occupied
            while (!(checkBetween(row, column) && notOccupied(row, column, step, Steps))) {
                System.out.println("Row: ");
                row = scanner.nextInt();
                System.out.println("Column: ");
                column = scanner.nextInt();
            }

            //change the coordinates to table-coordinates
            row = (row * 4) - 3;
            column = (column * 4) - 3;

            //store the step
            Steps[0][step - 1] = row;
            Steps[1][step - 1] = column;

            //print the table
            for (int k1 = 0; k1 < 11; k1++) {                      //sorokat számolja
                if ((k1 + 1) % 4 == 0) {
                    System.out.print("---+---+---");
                } else {
                    for (int k2 = 0; k2 < 11; k2++) {                   //egyes mezőket számolja a sorban
                        boolean tileXO = drawTheSeps(step, k1, k2, Steps);
                        if (!tileXO) {
                            if (((k2 + 1) % 4) == 0) {
                                System.out.print("|");
                            } else {
                                System.out.print(" ");
                            }
                        }
                    }
                }
                System.out.println();
            }

            //check: did he win
            if (step % 2 == 1) {
                Steps0[0][step / 2] = row;
                Steps0[1][step / 2] = column;
                winner = rowOrColumWins(Steps0);                        //filled a row or column
                if (!winner){
                    winner =diagonalWins(Steps0);                       //filled a diagonal
                }
            } else {
                StepsX[0][step / 2 - 1] = row;
                StepsX[1][step / 2 - 1] = column;
                winner = rowOrColumWins(StepsX);                        //filled a row or column
                if (!winner){
                    winner =diagonalWins(StepsX);                       //filled a diagonal
                }
            }

            if (winner) {
                System.out.println("Congratulations! You won!");
                break;
            }
        }
        if (!winner) {
            System.out.println("You filled all the tiles. Nobody won.");
        }
    }

    public static boolean rowOrColumWins(int[][] stepsX0) {
        boolean rowcolumn;
        int counter01 = 0;
        int counter02 = 0;
        int counter03 = 0;
        int counter11 = 0;
        int counter12 = 0;
        int counter13 = 0;
        for (int i = 0; i < 5; i++)
            if (!(stepsX0[0][i] == 0)) {
                if (stepsX0[0][i] == 1) {
                    ++counter01;
                }
                if (stepsX0[0][i] == 5) {
                    ++counter02;
                }
                if (stepsX0[0][i] == 9) {
                    ++counter03;
                }
                if (stepsX0[1][i] == 1) {
                    ++counter11;
                }
                if (stepsX0[1][i] == 5) {
                    ++counter12;
                }
                if (stepsX0[1][i] == 9) {
                    ++counter13;
                }
            }
        rowcolumn = counter01 == 3 || counter02 == 3 || counter03 == 3 || counter11 == 3 || counter12 == 3 || counter13 == 3;
        return rowcolumn;
    }

    public static boolean diagonalWins(int[][] stepsX0) {
        boolean diagonal;
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < 5; i++)
            if (!(stepsX0[0][i] == 0)) {
                if (stepsX0[0][i] == stepsX0[1][i]) {
                    ++counter1;
                }
                if (stepsX0[0][i] + stepsX0[1][i] == 10) {
                    ++counter2;
                }
            }
        diagonal = counter1 == 3 || counter2 == 3;
        return diagonal;
    }

    public static void drawTheTable() {
        for (int i = 0; i < 11; i++) {
            if ((i + 1) % 4 == 0) {
                System.out.println("---+---+---");
            } else {
                for (int j = 0; j < 11; j++) {
                    if (((j + 1) % 4) == 0) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static boolean checkBetween(int row, int column) {
        boolean checkbetween = (0 < row) && (row <= 3) && (0 < column) && (column <= 3);
        if (!checkbetween) {
            System.out.println("The row and column number should be between 1 and 3!");
        }
        return checkbetween;
    }

    public static boolean notOccupied(int row, int column, int step, int[][] Steps) {
        boolean notoccupied = true;
        row = (row * 4) - 3;
        column = (column * 4) - 3;
        for (int j = 0; j < (step - 1); j++) {
            if ((Steps[0][j] == row) && (Steps[1][j] == column)) {
                notoccupied = false;
                System.out.println("This tile is already occupied. Choose a new tile!");
                break;
            }
        }
        return notoccupied;
    }

    public static boolean drawTheSeps(int step, int k1, int k2, int[][] Steps) {
        boolean tileXO = false;
        for (int l = 0; l < step; l++) {                         //
            if ((Steps[0][l] == k1) && (Steps[1][l] == k2)) {
                tileXO = true;
            }
            if (tileXO) {
                //ha a tömb indexe páratlan és a tartalma nem 0, "X"et írunk
                if (l % 2 == 1) {
                    System.out.print("X");
                }
                //ha az index páros, "O"-t írunk
                else if (l % 2 == 0) {
                    System.out.print("O");
                }
                break;
            }
        }
        return tileXO;
    }
}


