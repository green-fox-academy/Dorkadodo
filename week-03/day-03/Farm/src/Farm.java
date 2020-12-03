import java.util.ArrayList;

public class Farm {
    private ArrayList<Animal> farm;
    private final int slots;

    public Farm(int slots) {
        farm = new ArrayList<>();
        this.slots = slots;
    }

    public void addAnimal(Animal animal) {
        farm.add(animal);
    }

    public Animal getAnimal(int index) {
        return farm.get(index);
    }

    public void setAnimal(int index, Animal animal) {
        farm.set(index, animal);
    }

    public ArrayList<Animal> getFarm() {
        return farm;
    }

    public void setFarm(ArrayList<Animal> farm) {
        this.farm = farm;
    }

    public void breed() {
        if (farm.size() < slots) {
            Animal animal = new Animal();
            farm.add(animal);
        } else {
            System.out.println("There are no empty slots for animals. Slaughter a few.");
        }
    }

    public void slaughter() {
        Animal leastHungryAnimal = farm.get(0);
        for (int i = 1; i < farm.size(); i++) {
            if (leastHungryAnimal.getHunger() > farm.get(i).getHunger()) {
                leastHungryAnimal = farm.get(i);
            }
        }
        farm.remove(leastHungryAnimal);
    }

    public int numberOfFreeSlots() {
        return slots - farm.size();
    }
}
