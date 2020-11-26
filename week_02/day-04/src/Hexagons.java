import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagons {
    static int size = 10;

    public static void mainDraw(Graphics graphics) {
        int i = 0;
        for (i = 0; i < (int) (2 * size / 5); i++) {
            hexagons(i, graphics);
        }
        int k = i;
        hexagonsMiddle(i, k, graphics);
    }

    public static void hexagons(int i, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        for (int k = 0; k <= i; k++) {
            int[] xPoints = createXPoints(i, k);
            int[] yPoints = createYPoints(i);
            int[] y2Points = createY2Points(i);
            graphics.drawPolygon(xPoints, yPoints, 6);
            graphics.drawPolygon(xPoints, y2Points, 6);
        }
        for (int k = 0; k < i - 1; k++) {
            int[] xPoints = createXPoints(i, k);
            int[] yPoints = createYPoints(i);
            int[] y2Points = createY2Points(i);
            graphics.drawPolygon(xPoints, yPoints, 6);
            graphics.drawPolygon(xPoints, y2Points, 6);
        }

    }

    public static void hexagonsMiddle(int i, int k, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int i1 = i+1;
       // (i1+1)*size*M
        for (i = i1; i < 2 * i1; i++) {
            for (k = 0; k <= i; k++) {
                int[] xPoints = createXPoints(i, k);

                int[] yPoints = createYPoints(i);
                graphics.drawPolygon(xPoints, yPoints, 6);
            }
        }
    }

    public static int[] createYPoints(int i) {
        int[] yPoints = new int[6];
        yPoints[0] = (int) (i * size * Math.sqrt(3));
        yPoints[1] = yPoints[0];
        yPoints[2] = (int) (yPoints[0] + size * Math.sqrt(3));
        yPoints[3] = (int) (yPoints[0] + 2 * size * Math.sqrt(3));
        yPoints[4] = yPoints[3];
        yPoints[5] = yPoints[2];
        return yPoints;
    }
    public static int[] createY2Points(int i) {
        int[] y2Points = new int[6];
        y2Points[0] = (int) (HEIGHT - (i + 2) * Math.sqrt(3) * size);
        y2Points[1] = y2Points[0];
        y2Points[2] = (int) (y2Points[0] + size * Math.sqrt(3));
        y2Points[3] = (int) (y2Points[0] + 2 * size * Math.sqrt(3));
        y2Points[4] = y2Points[3];
        y2Points[5] = y2Points[2];
        return y2Points;
    }
    public static int[] createXPoints(int i, int k) {
        int[] xPoints = new int[6];
        xPoints[0] = WIDTH / 2 - (i * (3 * size) + size) + k * (6 * size);
        xPoints[1] = xPoints[0] + (2 * size);
        xPoints[2] = xPoints[0] + (3 * size);
        xPoints[3] = xPoints[1];
        xPoints[4] = xPoints[0];
        xPoints[5] = xPoints[0] - size;
        return xPoints;
    }

    static int WIDTH = 22 * size;
    static int HEIGHT = (int) (14 * size * Math.sqrt(3));

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