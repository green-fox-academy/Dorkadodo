public class Flower extends Plant {
    public Flower(String color) {
        super(color);
        this.type = "Flower";
    }

    public Flower() {
        this("red");
    }

    @Override
    protected Integer getWateringTreshold() {
        return 5;
    }

    @Override
    protected Double absorbedWaterPercent() {
        return 0.75;
    }
}
