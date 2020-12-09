import java.awt.*;

public abstract class Tiles {
    private final String type;
    private boolean wasChecked = false;

    public Tiles (String type){
        this.type=type;
    }

    public abstract void drawTile(int startX, int startY, int width, int heights, Graphics graphics);

    public boolean getWasChecked() {
        return wasChecked;
    }

    public void setWasChecked(boolean wasChecked) {
        this.wasChecked = wasChecked;
    }

    public String getType (){
        return type;
    }
}
