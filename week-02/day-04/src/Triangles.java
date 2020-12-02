import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static void mainDraw(Graphics graphics) {
        for (int i = 0; i < (WIDTH / 20); i++) {
            triangles(i, graphics);
        }
    }

    public static void triangles(int i, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        for (int k = 0; k <= i; k++) {
            int[] xPoints = {WIDTH / 2 - i * 10 + k * 20, WIDTH / 2 - (i - 1) * 10 + k * 20, WIDTH / 2 - (i + 1) * 10 + k * 20};
            int[] yPoints = {(int) (i * 10 * Math.sqrt(3)), (int) ((i + 1) * 10 * Math.sqrt(3)), (int) ((i + 1) * 10 * Math.sqrt(3))};
            graphics.drawPolygon(xPoints, yPoints, 3);
        }
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