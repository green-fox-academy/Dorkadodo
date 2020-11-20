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
        for (int step = 1; step < 10; step++) {
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
            switch (row) {
                case 1: {
                    row = 2;
                }
                case 2: {
                    row = 6;
                }
                case 3: {
                    row = 10;
                }
            }
            switch (column) {
                case 1: {
                    column = 2;
                }
                case 2: {
                    column = 6;
                }
                case 3: {
                    column = 10;
                }
            }

            //check: not occupied
            boolean notoccupied;
            do {
                notoccupied = true;
                for (int j = 0; j < step; j++) {
                    if ((Steps[0][j] == row) && (Steps[1][j] == column)) {
                        notoccupied = false;
                        break;
                    }
                }
                System.out.println("This tile is already occupied. Choose a new tile!");
                System.out.println("Row: ");
                row = scanner.nextInt();
                System.out.println("Column: ");
                column = scanner.nextInt();
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
                        for (int l = 0; l < step; l++) {
                            if ((Steps[0][l] == k1) && (Steps[1][l] == k2)) {
                                tileXO = true;
                            }

                        }

                        //ha a tömb indexe páratlan és a tartalma nem 0, "X"et írunk
                        if ((step % 2 == 1) && tileXO) {
                            System.out.println("X");
                        }
                        //ha az index páros, "O"-t írunk
                        else if ((step % 2 == 0) && tileXO) {
                            System.out.println("O");
                        } else if (((k2 + 1) % 4) == 0) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }

    }


    //get the previous image
    //insert the new figure

    //check : between 1-3


    //check: did he win

}