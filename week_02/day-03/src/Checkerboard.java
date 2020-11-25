import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
    public static void mainDraw(Graphics graphics) {
        // Fill the canvas with a checkerboard pattern.

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                checkerboard(i, j, graphics);
            }
        }
    }

    public static void checkerboard(int i, int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(i * WIDTH/8, j * WIDTH/4 + (i % 2) * WIDTH/8, WIDTH/8, WIDTH/8);
    }

    static int WIDTH = 320;
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