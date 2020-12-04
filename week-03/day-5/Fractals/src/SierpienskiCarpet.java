
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpienskiCarpet {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int startX = WIDTH / 3;
        int startY = HEIGHT / 3;
        int side = WIDTH / 3;
        sierpienskiCarpet(startX, startY, side, graphics);
    }

    public static void sierpienskiCarpet(int startX, int startY, int side, Graphics graphics) {
        if (!(side > 1)) {
            return;
        }
        graphics.drawRect(startX, startY, side, side);
        int[] startXArray = {-((2 * side) / 3), -((2 * side) / 3), -((2 * side) / 3), side / 3,
                (4 * side) / 3, (4 * side) / 3, (4 * side) / 3, side / 3};
        int[] startYArray = {-((2 * side) / 3), side / 3, (4 * side) / 3, (4 * side) / 3,
                (4 * side) / 3, side / 3, -((2 * side) / 3), -((2 * side) / 3)};
        for (int i = 0; i < 8; i++) {
            graphics.drawRect(startX + startXArray[i], startY + startYArray[i], side / 3, side / 3);
            sierpienskiCarpet(startX + startXArray[i], startY + startYArray[i], side / 3, graphics);
        }
    }

    static int WIDTH = 900;
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