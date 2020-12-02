import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelephoneBook {
    public static void main(String[] args) {
        Map<String, String> PhoneBook = new HashMap<>();
        createMap(PhoneBook);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Whose phone number would you like to have?");
        System.out.println(PhoneBook.get(scanner.nextLine()));
        System.out.println("Which number do you have?");
        System.out.println(whoseNumber(PhoneBook, scanner.nextLine()));
        System.out.println("Whose phone number would you like to know if exists?");
        System.out.println(PhoneBook.containsKey(scanner.nextLine()));
    }

    public static Map createMap(Map<String, String> PhoneBook) {
        PhoneBook.put("William A. Lathan", "405-709-1865");
        PhoneBook.put("John K. Miller", "402-247-8568");
        PhoneBook.put("Hortensia E. Foster", "606-481-6467");
        PhoneBook.put("Amanda D. Newland", "319-243-5613");
        PhoneBook.put("Brooke P. Askew", "307-687-2982");
        return PhoneBook;
    }

    public static String whoseNumber(Map<String, String> PhoneBook, String number) {
        String name = "";
        for (String key : PhoneBook.keySet()) {
            String value = PhoneBook.get(key);
            if (value.equals(number)) {
                name = key;
            }
        }
        return name;
    }
}
