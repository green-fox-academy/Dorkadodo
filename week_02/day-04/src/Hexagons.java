import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagons {


    public static void mainDraw(Graphics graphics) {
        for (int i = 0; i < 4; i++) {
            hexagons(i, graphics);
        }
        
        for (int i = 0; i < 3; i++) {
            hexagonsMiddle(i, graphics);
        }
    }

    public static void hexagons(int i, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int firstItem;
        for (int k = 0; k <= i; k++) {
            int[] xPoints = createXPoints(i, k);
            firstItem = (int) (i * 10 * Math.sqrt(3));
            int[] yPoints = createYPoints(i, firstItem);
            graphics.drawPolygon(xPoints, yPoints, 6);
            firstItem = (int) (HEIGHT - (i + 2) * Math.sqrt(3) * 10);
            yPoints = createYPoints(i, firstItem);
            graphics.drawPolygon(xPoints, yPoints, 6);
        }
    }

    public static void hexagonsMiddle(int i, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        for (int j = 2; j < 4; j++) {
            for (int k = 0; k <= j; k++) {
                int[] xPoints = createXPoints(j, k);
                int firstItem = (int) ((2 * i + j + 2) * 10 * Math.sqrt(3));
                int[] yPoints = createYPoints(i, firstItem);
                graphics.drawPolygon(xPoints, yPoints, 6);
            }
        }
    }

    public static int[] createYPoints(int i, int firstItem) {
        int[] yPoints = new int[6];
        yPoints[0] = firstItem;
        yPoints[1] = yPoints[0];
        yPoints[2] = (int) (yPoints[0] + 10 * Math.sqrt(3));
        yPoints[3] = (int) (yPoints[0] + 20 * Math.sqrt(3));
        yPoints[4] = yPoints[3];
        yPoints[5] = yPoints[2];
        return yPoints;
    }

    public static int[] createXPoints(int i, int k) {
        int[] xPoints = new int[6];
        xPoints[0] = WIDTH / 2 - (i * 30 + 10) + k * 60;
        xPoints[1] = xPoints[0] + 20;
        xPoints[2] = xPoints[0] + 30;
        xPoints[3] = xPoints[1];
        xPoints[4] = xPoints[0];
        xPoints[5] = xPoints[0] - 10;
        return xPoints;
    }

    static int WIDTH = 220;
    static int HEIGHT = (int) (140 * Math.sqrt(3));

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