import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void mainDraw(Graphics graphics) {
        // Create a function that draws a single line and takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.
        for (int i = 0; i < (WIDTH / 40 + 1); i++) {
            envelopeStar(i, graphics);
        }
    }

    public static void envelopeStar(int i, Graphics graphics) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        int[] xPoints = {WIDTH / 2, WIDTH / 2 + (i) * 20, WIDTH / 2, WIDTH / 2 - (i) * 20};
        int[] yPoints = {i * 20, HEIGHT / 2, HEIGHT - i * 20, HEIGHT / 2};
        graphics.drawPolygon(xPoints, yPoints, 4);
    }

    static int WIDTH = 720;
    static int HEIGHT = WIDTH;

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
            this.setBackground(Color.WHITE);
            mainDraw(graphics);
        }
    }
}