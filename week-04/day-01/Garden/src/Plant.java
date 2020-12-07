public class Plant {
    protected String color;
    protected Double waterAmount;
    protected String type;

    protected Plant() {
        this("green");
    }

    protected Plant(String color) {
        this.color = color;
        waterAmount = 0.0;
        type = "Plant";
    }

    protected Integer getWateringTreshold() {
        return 0;
    }

    public boolean doesNeedWater() {
        if (waterAmount < getWateringTreshold()) {
            return true;
        }
        return false;
    }

    public void wateringStatus() {
        if (doesNeedWater()) {
            System.out.println("The " + color + " " + type + " needs water.");
        } else {
            System.out.println("The " + color + " " + type + " doesn't need water.");
        }
    }

    protected Double absorbedWaterPercent() {
        return 1.0;
    }

    protected void absorbWater(Double amount) {
        waterAmount += amount * absorbedWaterPercent();
    }
}
