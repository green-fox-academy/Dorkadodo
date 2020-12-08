public class Tiles {
    private final String type;
    private boolean wasChecked = false;

    public Tiles (String type){
        this.type=type;
    }

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
