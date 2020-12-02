import java.util.ArrayList;

public class Farm {
    public ArrayList<Animal> farm;
    int slots;

    public Farm(int slots) {
        farm = new ArrayList<>();
        this.slots = slots;
    }

    public void breed(Animal animal) {
        if (farm.size() < slots) {
            farm.add(animal);
        } else {
            System.out.println("There are no empty slots for animals. Slaughter a few.");
        }
    }

    public void slaughter() {
        Animal leastHungryAnimal = farm.get(0);
        for (int i = 0; i < farm.size(); i++) {
            if (leastHungryAnimal.hunger > farm.get(i).hunger) {
                leastHungryAnimal = farm.get(i);
            }
        }
        farm.remove(leastHungryAnimal);
    }
}
