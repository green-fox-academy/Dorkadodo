import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        //draw the table
        for (int i = 0; i < 11; i++) {
            if ((i + 1) % 4 == 0) {
                System.out.println("-----------");
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

        int[][] Steps = new int[2][9];
        boolean diagonal = false;
        for (int step = 1; step < 10; step++) {            //get the step, check for issues, draw the table
            //get a number
            Scanner scanner = new Scanner(System.in);
            System.out.println("Row: ");
            int row = scanner.nextInt();
            System.out.println("Column: ");
            int column = scanner.nextInt();

            //check : between 1-3
            while (!((0 < row) && (row <= 3) && (0 < column) && (column <= 3))) {
                System.out.println("The row and column number should be between 1 and 3!");
                System.out.println("Row: ");
                row = scanner.nextInt();
                System.out.println("Column: ");
                column = scanner.nextInt();
            }

            //change the coordinates to table-coordinates
            row = (row * 4) - 3;
            column = (column * 4) - 3;

            //check: not occupied
            boolean notoccupied;
            do {
                notoccupied = false;
                for (int j = 0; j < (step - 1); j++) {
                    if ((Steps[0][j] == row) && (Steps[1][j] == column)) {
                        notoccupied = true;
                        System.out.println("This tile is already occupied. Choose a new tile!");
                        System.out.println("Row: ");
                        row = scanner.nextInt();
                        System.out.println("Column: ");
                        column = scanner.nextInt();

                        row = (row * 4) - 3;
                        column = (column * 4) - 3;
                        break;
                    }
                }

            } while (notoccupied);

            //store the step
            Steps[0][step - 1] = row;
            Steps[1][step - 1] = column;


            //print the table
            for (int k1 = 0; k1 < 11; k1++) {                      //sorokat számolja
                if ((k1 + 1) % 4 == 0) {
                    System.out.println("-----------");
                } else {
                    for (int k2 = 0; k2 < 11; k2++) {                   //egyes mezőket számolja a sorban
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

            //check: did he win - are the tiles 11-55-99 or 19-55-91 all odd or even indexed

            int a1 = -1;
            int a2 = -1;
            int a3 = -1;
            int b1 = -1;
            int b3 = -1;
            for (int i = 0; i < 9; i++) {
                if ((Steps[0][i] == 1) && (Steps[1][i] == 1)) {
                    a1 = i;
                }
                else if ((Steps[0][i] == 5) && (Steps[1][i] == 5)) {
                    a2 = i;
                }
                else if ((Steps[0][i] == 9) && (Steps[1][i] == 9)) {
                    a3 = i;
                }
                else if ((Steps[0][i] == 1) && (Steps[1][i] == 9)) {
                    b1 = i;
                }
                else if ((Steps[0][i] == 9) && (Steps[1][i] == 1)) {
                    b3 = i;
                }

                if (((a1 >= 0) && (a2 >= 0) && (a3 >= 0)) && (!(a1 % 2 == step % 2 ) && !(a2 % 2 == step % 2) && !(a3 % 2 == step % 2))) {
                    diagonal = true;
                } else if (((b1 >= 0) && (a2 >= 0) && (b3 >= 0)) && (!(b1 % 2 == step % 2) && !(a2 % 2 == step % 2) && !(b3 % 2 == step % 2))) {
                    diagonal = true;
                }
            }
            if (diagonal) {
                System.out.println("Congratulations! You won!");
                break;
            }
        }
        if (!diagonal){
            System.out.println("You filled all the tiles. Nobody won.");
        }
    }
}


