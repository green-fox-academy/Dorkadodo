import javax.swing.*;
import java.awt.*;

class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(Color.WHITE);
        mainDraw(graphics);
    }
}
}