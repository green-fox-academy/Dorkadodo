import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please write a distance in mile: ");
        double distanceMile = scanner.nextDouble();
        double distanceKm = distanceMile*1.609344;
        System.out.println(distanceMile + " mile = "+ distanceKm + " km");
    }
}