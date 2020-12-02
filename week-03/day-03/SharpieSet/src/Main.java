import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sharpie sharpie0 = new Sharpie("black", 20);
        Sharpie sharpie1 = new Sharpie("blue", 20);
        Sharpie sharpie2 = new Sharpie("green", 20);
        Sharpie sharpie3 = new Sharpie("yellow", 20);
        Sharpie sharpie4 = new Sharpie("red", 20);
        Sharpie sharpie5 = new Sharpie("pink", 20);
        Sharpie sharpie6 = new Sharpie("grey", 20);
        Sharpie sharpie7 = new Sharpie("white", 20);
        Sharpie sharpie8 = new Sharpie("purple", 20);

        SharpieSet sharpieSet = new SharpieSet();
        sharpieSet.addSharpie(sharpie0);
        sharpieSet.addSharpie(sharpie1);
        sharpieSet.addSharpie(sharpie2);
        sharpieSet.addSharpie(sharpie3);
        sharpieSet.addSharpie(sharpie4);
        sharpieSet.addSharpie(sharpie5);
        sharpieSet.addSharpie(sharpie6);
        sharpieSet.addSharpie(sharpie7);
        sharpieSet.addSharpie(sharpie8);

        Random random = new Random();

        for (int i = 0; i < 80; i++) {
            sharpieSet.sharpieSet.get(random.nextInt(9)).use(random.nextInt(20));
        }
        System.out.println(sharpieSet.sharpieSet.size());
        System.out.println(sharpieSet.countUsable());
        sharpieSet.removeTrash();
        System.out.println(sharpieSet.sharpieSet.size());
    }
}
