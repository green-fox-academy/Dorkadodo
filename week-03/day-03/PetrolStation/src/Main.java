import java.time.Period;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Station station = new Station();

        car.gasAmount = 0;
        car.capacity = 100;
        System.out.println("Gas amount in the car: " + car.gasAmount);

        station.refill(car);
        System.out.println("Gas amount in the car: " + car.gasAmount);

    }
}
