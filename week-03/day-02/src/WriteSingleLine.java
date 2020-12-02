import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class WriteSingleLine {
    public static void main(String[] args) {
        // Write a function that is able to manipulate a file
        // By writing your name into it as a single line
        // The file should be named "my-file.txt"
        // In case the program is unable to write the file,
        // It should print the following error message: "Unable to write file: my-file.txt"

        List<String> name = new ArrayList<>();
        name.add("Dorka");

        try {
            Path filepath = Paths.get("my-file.txt");
            Files.write(filepath, name, StandardOpenOption.APPEND);
            System.out.println();
            printFile(filepath);
        } catch (IOException ex) {
            System.out.println("Unable to write file: my-file.txt");
        }
    }

    public static void printFile(Path filepath) throws IOException {
        List<String> lines = Files.readAllLines(filepath);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}