import java.util.Scanner;

public class PartyIndicator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many boys are at the party? ");
        int boys = scanner.nextInt();
        System.out.println("How many girls are at the party?");
        int girls = scanner.nextInt();

        if ((boys == girls) && ((boys + girls) > 19)) {
            System.out.println("The party is excellent!");
        } else if (girls == 0) {
            System.out.println("Sausage party");
        } else if (!(boys == girls) && ((boys + girls) > 19)) {
            System.out.println("Quite cool party!");
        } else {
            System.out.println("Average party...");
        }

    }

}
