import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        List<String> shoppingList = new ArrayList<>(Arrays.asList("eggs", "milk", "fish", "apples",
                "bread", "chicken"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("What are you searching for on the list?");
        String item = scanner.nextLine();
        if (shoppingList.contains(item)) {
            System.out.println("Yes, you have " + item + " on the list.");
        } else {
            System.out.println("No, you don't have " + item + " on the list.");
        }
    }
}
