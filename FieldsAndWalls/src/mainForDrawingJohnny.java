import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;import static javax.swing.WindowConstants.EXIT_ON_CLOSE;public class Main extends JComponent implements MouseListener {    static int SCREEN_SIZE = 800;
    static int IMAGE_SIZE = 40;    private Resource resource;
    private Grid grid;    static int topInset;
    static int leftInset;    public Main() {
        setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        setVisible(true);        this.resource = new Resource();
        this.grid = new Grid(SCREEN_SIZE / IMAGE_SIZE);
    }    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        System.out.println("asd");
        grid.draw(graphics, IMAGE_SIZE, resource);
    }    public static void main(String[] args) {
        // Here is how you set up a new window and adding our board to it
        JFrame frame = new JFrame("Minesweeper");
        Main main = new Main();
        frame.add(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        // Here is how you can add a key event listener
        // The board object will be notified when hitting any key
        // with the system calling one of the below 3 methods
        frame.addMouseListener(main);
        topInset = frame.getInsets().top;
        leftInset = frame.getInsets().left;
        // Notice (at the top) that we can only do this
        // because this Board class (the type of the board object) is also a KeyListener
    }    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println(e.getX() + " " + e.getY());
        grid.handleClick((e.getX() - leftInset) / IMAGE_SIZE + 1, (e.getY() - topInset) / IMAGE_SIZE + 1);        if(grid.getGameState() == GameState.LOSE){
            grid.revealAll();
            System.out.println("You lost! Sucker");
        }else if(grid.getGameState() == GameState.WIN){
            System.out.println("You won!");
        }        repaint();
    }    @Override
    public void mousePressed(MouseEvent e){    }    @Override
    public void mouseReleased(MouseEvent e){    }    @Override
    public void mouseEntered(MouseEvent e){    }    @Override
    public void mouseExited(MouseEvent e){    }
}
