import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class WriteMultipleLines {
    public static void main(String[] args) {
        // Create a function that takes 3 parameters: a path, a word and a number
        // and is able to write into a file.
        // The path parameter should be a string that describes the location of the file you wish to modify
        // The word parameter should also be a string that will be written to the file as individual lines
        // The number parameter should describe how many lines the file should have.
        // If the word is 'apple' and the number is 5, it should write 5 lines
        // into the file and each line should read 'apple'
        // The function should not raise any errors if it could not write the file.
        String word = "apple";
        int number = 5;
        Path path = Paths.get("mySecondFile.txt");
        try {
            addWordToFile(word, number, path);
            printFile(path);
        } catch (IOException ex) {
        }
    }

    public static void addWordToFile(String word, int number, Path path) throws IOException {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lines.add(word);
        }
        Files.write(path, lines, StandardOpenOption.APPEND);
    }

    public static void printFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
