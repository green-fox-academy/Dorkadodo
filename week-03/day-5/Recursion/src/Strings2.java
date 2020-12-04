import java.util.Scanner;

public class Strings2 {
    // Given a string,
// compute recursively a new string where
// all the 'x' chars have been removed.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a string:");
        String line = scanner.nextLine();
        System.out.println(stringX(line));
    }

    public static String stringX(String line) {
        if (!(line.length() == 0)) {
            if (line.toCharArray()[0] == 'x') {
                line = stringX(line.substring(1));
            } else {
                line = line.toCharArray()[0] + stringX(line.substring(1));
            }
        }

        return line;
    }
}
