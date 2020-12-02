import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDatabase {
    public static void main(String[] args) {
        Map<String, Integer> productDatabase = new HashMap<>();
        createList(productDatabase);

        // How much is the fish?
        // What is the most expensive product?
        // What is the average price?
        // How many products' price is below 300?
        // Is there anything we can buy for exactly 125?
        // What is the cheapest product?

        System.out.println("The fish costs " + productDatabase.get("fish"));
        System.out.println("The most expensive product is the " + mostExpensive(productDatabase));
        System.out.println("The average price of the products is " + average(productDatabase));
        System.out.println(belowPrize(productDatabase) + " item's price is below 300.");
        if (productDatabase.containsValue(125)) {
            System.out.println("Yes, we can buy something for 125.");
        } else {
            System.out.println("No, we can't buy anything for 125.");
        }
        System.out.println("The cheapest product is the " + cheapest(productDatabase));


        // Which products cost less than 201? (just the name)
        // Which products cost more than 150? (name + price)

        System.out.println("Following products cost less than 201: " + lessThan(productDatabase));
        System.out.println("Following items cost more than 150: " + moreThan(productDatabase));
    }

    public static void createList(Map<String, Integer> productDatabase) {
        productDatabase.put("eggs", 200);
        productDatabase.put("milk", 200);
        productDatabase.put("fish", 400);
        productDatabase.put("apple", 150);
        productDatabase.put("bread", 50);
        productDatabase.put("chicken", 550);
    }

    public static String mostExpensive(Map<String, Integer> productDatabase) {
        int max = 0;
        String item = "";
        for (String product : productDatabase.keySet()) {
            if (productDatabase.get(product) > max) {
                max = productDatabase.get(product);
                item = product;
            }
        }
        return item;
    }

    public static double average(Map<String, Integer> productDatabase) {
        double average = 0;
        for (String key : productDatabase.keySet()) {
            average += productDatabase.get(key);
        }
        average = average / productDatabase.size();
        return average;
    }

    public static int belowPrize(Map<String, Integer> productDatabase) {
        int counter = 0;
        for (String key : productDatabase.keySet()) {
            if (productDatabase.get(key) < 300) {
                ++counter;
            }
            ;
        }
        return counter;
    }

    public static String cheapest(Map<String, Integer> productDatabase) {
        int min = Integer.MAX_VALUE;
        String item = "";
        for (String product : productDatabase.keySet()) {
            if (productDatabase.get(product) < min) {
                min = productDatabase.get(product);
                item = product;
            }
        }
        return item;
    }

    public static List<String> lessThan(Map<String, Integer> productDatabase) {
        List<String> itemList = new ArrayList<>();
        for (String key : productDatabase.keySet()) {
            if (productDatabase.get(key) < 201) {
                itemList.add(key);
            }
        }
        return itemList;
    }

    public static Map<String, Integer> moreThan(Map<String, Integer> productDatabase) {
        Map<String, Integer> itemList = new HashMap<>();
        for (String key : productDatabase.keySet()) {
            if (productDatabase.get(key) > 150) {
                itemList.put(key, productDatabase.get(key));
            }
        }
        return itemList;
    }
}
