import java.awt.*;
import java.util.Random;

public class Wall extends Tiles{
    public Wall (){
        super("Wall");
    }

    @Override
    public void drawTile(int startX, int startY, int width, int height, Graphics graphics) {
        int x0 = startX;
        int y0=startY;
        int n = (width/50);
        graphics.setColor(Color.GRAY);
        graphics.fillRect(x0, y0, width, height);
        graphics.setColor(Color.DARK_GRAY);
        graphics.drawRect(x0, y0, width, height);
    }
}
