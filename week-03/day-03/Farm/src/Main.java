import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm(5);
        for (int i = 0; i < 5; i++) {
            farm.breed();
        }

        Random random = new Random();
        for (int i = 0; i < random.nextInt(300); i++) {
            farm.getAnimal(random.nextInt(farm.getFarm().size())).play();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(farm.getAnimal(i).getHunger());
        }
        farm.slaughter();
        for (int i = 0; i < 4; i++) {
            System.out.println(farm.getAnimal(i).getHunger());
        }
    }
}
