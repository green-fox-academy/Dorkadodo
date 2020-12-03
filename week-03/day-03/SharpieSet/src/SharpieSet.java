import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    private ArrayList<Sharpie> sharpieSet;

    public SharpieSet (){
        sharpieSet = new ArrayList<>();
    }

    public void addSharpie (Sharpie sharpie){
        sharpieSet.add(sharpie);
    }

    public Sharpie getSharpie(int index){
        return sharpieSet.get(index);
    }

    public void setSharpie(int index, Sharpie sharpie){
        sharpieSet.set(index, sharpie);
    }

    public ArrayList getSharpieSet(){
        return sharpieSet;
    }

    public void setSharpieSet(ArrayList<Sharpie>sharpieSet){
        this.sharpieSet = sharpieSet;
    }

    public int countUsable(){
        int usableSharpies = 0;
        for (int i = 0; i < sharpieSet.size(); i++) {
            if (sharpieSet.get(i).usable()){
                usableSharpies++;
            }
        }
        return usableSharpies;
    }

    public void removeTrash(){
        for (int i = sharpieSet.size()-1; i >=0; i--) {
            if (!(sharpieSet.get(i).usable())){
                sharpieSet.remove(i);
            }
        }
    }
}
