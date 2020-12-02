import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps {
    public static void mainDraw(Graphics graphics) {
        // Reproduce this:
        // [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r3.png]
        for (int i = 0; i < 30; i++) {
            int x = 20 * i + 5;
            purpleSteps(x, graphics);
        }
    }

    public static void purpleSteps(int x, Graphics graphics) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        graphics.fillRect(x, x, 20, 20);
        graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        graphics.drawRect(x, x, 20, 20);

    }

    static int WIDTH = 700;
    static int HEIGHT = 700;

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