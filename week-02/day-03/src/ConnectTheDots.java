import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
    public static void mainDraw(Graphics graphics) {
        // Create a function that takes 2 parameters:
        // An array of {x, y} points and graphics
        // and connects them with green lines.
        // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
        // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
        // {120, 100}, {85, 130}, {50, 100}}

        //int[][] dots = {{10, 10}, {290, 10}, {290, 290}, {10, 290}};
        int[][] dots = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}};

        int[] xPoints = new int[dots.length];
        int[] yPoints = new int[dots.length];
        for (int i = 0; i < dots.length; i++) {
            xPoints[i] = dots[i][0];
        }
        for (int i = 0; i < dots.length; i++) {
            yPoints[i] = dots[i][1];
        }
        connectTheDots(xPoints, yPoints, graphics);
    }

    public static void connectTheDots(int[] xPoints, int [] yPoints, Graphics graphics) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

        graphics.drawPolygon(xPoints, yPoints, xPoints.length);
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