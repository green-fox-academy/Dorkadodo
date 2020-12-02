import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        // Write a function that copies the contents of a file into another
        // It should take the filenames as parameters
        // It should return a boolean that shows if the copy was successful

        Path path1 = Paths.get("my-file.txt");
        Path path2 = Paths.get("mySecondFile.txt");
        System.out.println("The file was copied: " + successfullyCopiedFile(path1, path2));
    }

    public static boolean successfullyCopiedFile(Path path1, Path path2) {
        try {
            List<String> lines1 = new ArrayList<>(Files.readAllLines(path1));
            Files.write(path2, lines1, StandardOpenOption.APPEND);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
