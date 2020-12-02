import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Darts {
    public static void mainDraw(Graphics graphics) {
        Color[] colors = {Color.GREEN, Color.RED, Color.WHITE, Color.BLACK};
        int[][] size = {{50, 70, 170, 190, 310, 330},
                {600, 560, 360, 320, 80, 40}};

        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 10; k++) {
                graphics.setColor(colors[(i % 2) * 2+1]);
                graphics.fillArc(size[0][i], size[0][i], size[1][i], size[1][i], 2 * k * 18 + 9, 18);
                graphics.setColor(colors[(i % 2) * 2]);
                graphics.fillArc(size[0][i], size[0][i], size[1][i], size[1][i], 2 * k * 18 - 9, 18);
            }
        }

        for (int i=0;i<2;i++){
            graphics.setColor(colors[i]);
            graphics.fillArc(size[0][i+4], size[0][i+4], size[1][i+4], size[1][i+4], 0, 360);
        }
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
            this.setBackground(Color.WHITE);
            mainDraw(graphics);
        }
    }
}