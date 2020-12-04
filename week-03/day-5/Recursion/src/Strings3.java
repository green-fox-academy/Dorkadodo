import java.util.Scanner;

public class Strings3 {
    // Given a string,
// compute recursively a new string where
// all the adjacent chars are now separated by a `*`
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a string:");
        String line = scanner.nextLine();
        System.out.println(stringStar(line));
    }

    public static String stringStar(String line) {
        if (!(line.length() == 1)) {
            line = line.toCharArray()[0] + "*" + stringStar(line.substring(1));
        }
        return line;
    }
}
