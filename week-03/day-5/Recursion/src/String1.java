import java.util.Scanner;

public class String1 {
    // Given a string, compute recursively (no loops) a new string where
// all the lowercase 'x' chars have been changed to 'y' chars.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a string:");
        String line = scanner.nextLine();
        System.out.println(stringXY(line));
    }

    public static String stringXY(String line) {

        if (!(line.length() == 0)) {
            if (line.toCharArray()[0] == 'x') {
                line = "y" + stringXY(line.substring(1));
            } else {
                line = line.toCharArray()[0] + stringXY(line.substring(1));
            }
        }

        return line;
    }
}
