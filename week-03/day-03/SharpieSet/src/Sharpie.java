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

    public boolean usable() {
        if (inkAmount <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
