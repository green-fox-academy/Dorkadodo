import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {

    public static void main(String[] args) {
        // Create a method that decrypts reversed-order.txt


        Path path = Paths.get("reversed-order.txt");
        try {
            decryptFile(path);
            System.out.println("The file is decrypted.");
        } catch (IOException ex) {
            System.out.println("Sorry, something went wrong.");
        }
    }

    public static void decryptFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Files.write(path, reverseOrderOfLines(lines));
    }

    public static List<String> reverseOrderOfLines(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for (int j = lines.size() - 1; j >= 0; j--) {
            newLines.add(lines.get(j));
        }
        return newLines;
    }
}

