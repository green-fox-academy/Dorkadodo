import java.util.Random;
import java.util.Scanner;

public class PirateShip {
    public static void main(String[] args) {

        Random random = new Random();

        try {
            Ship ship = new Ship();
            ship.fillShip();
            ship.printCrew();

            ship.getCrewMember(random.nextInt(ship.getCrew().size())).brawl(ship.getCrewMember(random.nextInt(ship.getCrew().size())));
            ship.statusOfShip();

        } catch (Exception ex) {
            System.out.println("Sorry, something went wrong.");
        }
    }
}
