import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TableDrawings {

    Table table;
    public void mainDraw(Graphics graphics) {
        System.out.println("drawing");

        table.drawTable(graphics);

    }

    static int WIDTH = 1000;
    static int HEIGHT = WIDTH;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        TableDrawings tableDrawings = new TableDrawings();
        tableDrawings.table = new Table(10);
        tableDrawings.table.getCorrectTable();
        //panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            this.setBackground(Color.WHITE);
            mainDraw(graphics);
        }
    }
}