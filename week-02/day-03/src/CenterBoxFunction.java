import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {

    public static void mainDraw(Graphics graphics) {
        // create a function that draws one square and takes 2 parameters:
        // the square size and the graphics
        // and draws a square of that size to the center of the canvas.
        // draw 3 squares with that function.
        // avoid code duplication.
        for (int i = 0; i < 3; i++) {
            int x = 30 * i + 5;
            centerBoxFunction(x, graphics);
        }
    }

    public static void centerBoxFunction(int x, Graphics graphics) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        graphics.drawRect((WIDTH - x) / 2, (HEIGHT - x) / 2, x, x);
    }

    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            this.setBackground(Color.GRAY);
            mainDraw(graphics);
        }
    }
}