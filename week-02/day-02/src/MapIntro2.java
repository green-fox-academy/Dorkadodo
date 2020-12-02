import java.util.HashMap;
import java.util.Map;

public class MapIntro2 {
    public static void main(String[] args) {
        Map<String, String> books = new HashMap<>();
        books.put("978-1-60309-452-8", "A Letter to Jo");
        books.put("978 - 1 - 60309 - 459 - 7", "Lupus");
        books.put("978 - 1 - 60309 - 444 - 3", "Red Panda and Moon Bear");
        books.put("978 - 1 - 60309 - 461 - 0", "The Lab");

        for (String key : books.keySet()) {
            String value = books.get(key);
            System.out.println(value + " (" + key + ")");
        }

        books.remove("978-1-60309-444-3");

        String keyToRemove = "";
        for (String value : books.values()) {
            String key = books.get(value);
            if (value == "The Lab") {
                keyToRemove = key;
            }
        }
        books.remove(keyToRemove);

        books.put("978-1-60309-450-4", "They Called Us Enemy");
        books.put("978-1-60309-453-5", "Why Did We Trust Him?");

        System.out.println(books.containsKey("478-0-61159-424-8"));
        System.out.println(books.get("978-1-60309-453-5"));
    }
}
