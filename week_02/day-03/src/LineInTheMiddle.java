import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LineInTheMiddle {
    public static void mainDraw(Graphics graphics){
        // draw a red horizontal line to the canvas' middle.
        // draw a green vertical line to the canvas' middle.

        graphics.setColor(Color.RED);
        graphics.drawLine(1, 160, 320, 160);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(160, 1, 160, 320);

        graphics.setColor(Color.RED);
        graphics.drawLine(1, 100, 320, 100);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(100, 1, 100, 320);

        graphics.setColor(Color.RED);
        graphics.drawLine(1, 220, 320, 220);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(220, 1, 220, 320);
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
            this.setBackground(Color.BLUE);
            mainDraw(graphics);
        }
    }
}