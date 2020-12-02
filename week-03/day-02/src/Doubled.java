import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Doubled {

    public static void main(String[] args) {
        // Create a method that decrypts the duplicated-chars.txt

        Path path = Paths.get("duplicated-chars.txt");
        try {
            decryptFile(path);
            System.out.println("The file is decrypted.");
        } catch (IOException ex) {
            System.out.println("Sorry, something went wrong.");
        }
    }

    public static void decryptFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Files.write(path, overwriteWrongLines(lines));
    }

    public static List<String> overwriteWrongLines(List<String> lines) {
        for (int j = 0; j < lines.size(); j++) {
            String newString = "";
            deleteSecondLetters(lines, j, newString);
        }
        return lines;
    }

    public static void deleteSecondLetters(List<String> lines, int j, String newString) {
        char[] chars = lines.get(j).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                newString += chars[i];
            }
        }
        lines.set(j, newString);
    }
}