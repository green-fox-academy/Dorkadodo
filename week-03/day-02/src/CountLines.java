import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    public static void main(String[] args) {
        // Write a function that takes a filename as string,
        // then returns the number of lines the file contains.
        // It should return zero if it can't open the file, and
        // should not raise any error.
        Path filepath = Paths.get("my-file.txt");
        try {
            List<String> lines = Files.readAllLines(filepath);
            System.out.println(lines.size());
        } catch (IOException ex) {
            System.out.println("0");
        }

    }
}
