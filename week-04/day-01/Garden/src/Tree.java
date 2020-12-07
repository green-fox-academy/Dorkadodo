public class Tree extends Plant {
    public Tree(String color) {
        super(color);
        this.type = "Tree";
    }

    public Tree() {
        this("brown");
    }

    @Override
    protected Integer getWateringTreshold() {
        return 10;
    }

    @Override
    protected Double absorbedWaterPercent() {
        return 0.4;
    }
}
