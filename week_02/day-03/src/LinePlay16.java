import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;

public class LinePlay16 {
    public static void mainDraw(Graphics graphics) {
        // Create a function that draws a single line and takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i < (WIDTH / 80 + 1); i++) {
                    linePlay1(i, j, k, graphics);
                    linePlay2(i, j, k, graphics);
                }
            }
        }
    }

    public static void linePlay1(int i, int j, int k, Graphics graphics) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        graphics.drawLine(i * 20 + WIDTH * j / 4, HEIGHT * k / 4, WIDTH * (j + 1) / 4, i * 20 + HEIGHT * k / 4);
    }

    public static void linePlay2(int i, int j, int k, Graphics graphics) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        graphics.drawLine(WIDTH * j / 4, i * 20 + HEIGHT * k / 4, i * 20 + WIDTH * j / 4, HEIGHT * (k + 1) / 4);
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