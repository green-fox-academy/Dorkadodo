import java.util.Random;
import java.util.Scanner;

public class CAB {
    private int numberToGuess;
    private String state;
    private int counterOfGuesses;

    Scanner scanner;

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public String getState() {
        return state;
    }

    public void startGame() {
        numberToGuess = generateNumberToGuess();
        printStartOGame();
        counterOfGuesses = 0;
        state = "playing";
    }

    public void guesses() {
        counterOfGuesses++;
        scanner = new Scanner(System.in);
        System.out.print(" " + counterOfGuesses + "    ");
        int currentGuess = scanner.nextInt();
        currentGuess = checkInputValidity(currentGuess);
        System.out.println("Result:  " + resultOfGuess(currentGuess));
        ifWinner(currentGuess);
    }

    private void ifWinner(int currentGuess) {
        if (numberToGuess == currentGuess) {
            state = "finished";
            System.out.println("Congratulations! you guessed the number in " + counterOfGuesses + " guesses.");
        }
    }

    private int generateNumberToGuess() {
        Random random = new Random();
        return (random.nextInt(8999) + 1000);
    }

    private void printStartOGame() {
        System.out.println("Round  Guess");
    }

    private String resultOfGuess(int currentGuess) {
        int[] numberToGuessArray = numberToArray(numberToGuess);
        int[] currentGuessArray = numberToArray(currentGuess);
        int cow = 0;
        int bull = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (numberToGuessArray[i] == currentGuessArray[j]) {
                    if (i == j) {
                        cow++;
                    } else {
                        bull++;
                    }
                }
            }
        }
        return cow + " cow " + bull + " bull";
    }

    private int[] numberToArray(int number) {
        int[] numberArray = new int[4];
        for (int i = 3; i >= 0; i--) {
            numberArray[i] = number % 10;
            number = number / 10;
        }
        return numberArray;
    }

    private int checkInputValidity(int currentGuess) {
        while (!(999 < currentGuess && currentGuess < 10000)) {
            System.out.println();
            System.out.println("False input");
            System.out.print(" " + counterOfGuesses + "    ");
            currentGuess = scanner.nextInt();
        }
        return currentGuess;
    }
}
