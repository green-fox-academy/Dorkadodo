import java.util.ArrayList;

public class SharpieSet {
    public ArrayList<Sharpie> sharpieSet;
    public SharpieSet (){
        sharpieSet = new ArrayList<>();
    }

    public void addSharpie (Sharpie sharpie){
        sharpieSet.add(sharpie);
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
