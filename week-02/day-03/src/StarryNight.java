import javax.swing.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
    public static void mainDraw(Graphics graphics) {
        // Draw the night sky:
        //  - The background should be black
        //  - The stars can be small squares
        //  - The stars should have random positions on the canvas
        //  - The stars should have random color (some shade of grey)

        for (int i = 0; i < 100; i++) {
            starryNight(graphics);
        }
    }

    public static void starryNight(Graphics graphics) {
        Random random = new Random();
        int grey = random.nextInt(200) + 56;
        int size = random.nextInt(10) + 1;
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);
        graphics.setColor(new Color(grey, grey, grey));
        graphics.fillRect(x, y, size, size);
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