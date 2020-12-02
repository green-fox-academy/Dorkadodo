import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logs {
    public static void main(String[] args) {
        Path path = Paths.get("logs.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            List<String> IPAdresses = new ArrayList<>();
            for (String line : lines) {
                addIfNotThere(getAddress(line), line, IPAdresses);
            }

            System.out.println("The unique IP Adresses: ");
            for (String adress : IPAdresses) {
                System.out.println(adress);
            }

            int getCounter = 0;
            int postCounter = 0;
            for (String line : lines) {
                if (line.contains("GET")) {
                    getCounter++;
                } else if (line.contains("POST")) {
                    postCounter++;
                }
            }
            System.out.println("The GET vs POST error ratio is: " + getCounter + " / " + postCounter);

        } catch (Exception ex) {
            System.out.println("Sorry, something went wrong");
        }
    }

    public static String getAddress(String line) {
        return line.substring(27, 38);
    }

    public static void addIfNotThere(String ipadress, String line, List<String> IPAdresses) {
        if (!(IPAdresses.contains(ipadress))) {
            IPAdresses.add(getAddress(line));
        }
    }
}
