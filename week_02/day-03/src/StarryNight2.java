import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight2 {
    public static void mainDraw(Graphics graphics) {
        // Draw the night sky:
        //  - The background should be black
        //  - The stars can be small squares
        //  - The stars should have random positions on the canvas
        //  - The stars should have random color (some shade of grey)

        for (int i = 0; i < 100; i++) {
            //coordinates of two rectangles put together as a star
            double[] xPoints1 = {0, 0, Math.sqrt(3)};
            double[] yPoints1 = {0, 2, 1};
            double[] xPoints2 = {2 * (Math.sqrt(3) / 3), -(Math.sqrt(3) / 3), 2 * (Math.sqrt(3) / 3)};
            double[] yPoints2 = {2, 1, 0};
            starryNight(xPoints1, yPoints1, xPoints2, yPoints2, graphics);
        }
    }

    public static void starryNight(double[] xPoints1, double[] yPoints1, double[] xPoints2, double[] yPoints2, Graphics graphics) {
        Random random = new Random();
        int grey = random.nextInt(180) + 56;
        int size = random.nextInt(10) + 1;
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);
        graphics.setColor(new Color(grey, grey, grey));

        //set the size and position of the current star
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        for (int i = 0; i < 3; i++) {
            xPoints[i] = (int) ((xPoints1[i] * size) + x);
        }
        for (int i = 0; i < 3; i++) {
            yPoints[i] = (int) ((yPoints1[i] * size) + y);
        }
        graphics.fillPolygon(xPoints, yPoints, 3);

        for (int i = 0; i < 3; i++) {
            xPoints[i] = (int) ((xPoints2[i] * size) + x);
        }
        for (int i = 0; i < 3; i++) {
            yPoints[i] = (int) ((yPoints2[i] * size) + y);
        }
        graphics.fillPolygon(xPoints, yPoints, 3);
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
            this.setBackground(Color.BLACK);
            mainDraw(graphics);
        }
    }
}