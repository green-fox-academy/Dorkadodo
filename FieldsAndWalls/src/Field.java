import java.awt.*;
import java.util.Random;

public class Field extends Tiles {
    public Field() {
        super("Field");
    }

    @Override
    public void drawTile(int startX, int startY, int width, int height, Graphics graphics) {

        int x0 = startX;
        int y0=startY;
        int n = (width/50);
        Random random = new Random();
        graphics.setColor(new Color(17, random.nextInt(15)+90, 30));
        graphics.fillRect(x0, y0, width, height);
        graphics.setColor(new Color(4, 38, 9));
        graphics.drawRect(x0, y0, width, height);
        drawGrass(x0, y0, n, graphics);
    }

    public void drawGrass (int x0, int y0, int n, Graphics graphics){
        Random random = new Random();
        int add1 = random.nextInt(20);
        int add2 = random.nextInt(30);
        graphics.setColor(Color.BLACK);
        graphics.drawArc(x0+(-8)*n+add1*n, y0+5*n+add2*n, 20*n, 20*n, 0, 70);
        graphics.drawArc(x0+(-10)*n+add1*n, y0+5*n+add2*n, 30*n, 30*n, 45, 45);
        graphics.drawArc(x0+12*n+add1*n, y0+(-1)*n+add2*n, 40*n, 40*n, 110, 40);
        graphics.drawArc(x0+19*n+add1*n, y0+(-7)*n+add2*n, 45*n, 45*n, 140, 40);
    }
}
