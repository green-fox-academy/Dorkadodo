public class Sharpie {
    String color;
    float width;
    float inkAmount;

    public Sharpie(String color, float width) {
        inkAmount = 100;
    }

    public void use(int num) {
        inkAmount = inkAmount - num;
    }
}
