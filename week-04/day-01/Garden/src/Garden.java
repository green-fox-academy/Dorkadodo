import java.util.ArrayList;
import java.util.List;

public class Garden {
    List<Plant> plants;

    public Garden() {
        plants = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void watering(Integer amount) {
        System.out.println("Watering with " + amount);
        List<Plant> plantsToWater = plantsToWater(plants);
        Double amountForEach = Double.valueOf(amount) / plantsToWater.size();
        for (Plant plant : plantsToWater) {
            plant.absorbWater(amountForEach);
        }
    }

    public List<Plant> plantsToWater(List<Plant> plants) {
        List<Plant> plantsToWater = new ArrayList<>();
        addIfNeedsWater(plants, plantsToWater);
        return plantsToWater;
    }

    private void addIfNeedsWater(List<Plant> plants, List<Plant> plantsToWater) {
        for (Plant plant : plants) {
            if (plant.doesNeedWater()) {
                plantsToWater.add(plant);
            }
        }
    }

    public void gardenWateringStatus (){
        for (Plant plant : plants){
            plant.wateringStatus();
        }
    }
}
