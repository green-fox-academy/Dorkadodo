import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntro2 {
    public static void main(String[] args) {
        List<String> ListA = new ArrayList<>(Arrays.asList("Apple", "Avocado", "Blueberries", "Durian", "Lychee"));
        List<String> ListB = new ArrayList<>(ListA);
        System.out.println(ListA.contains("Durian"));
        ListB.remove("Durian");
        ListA.add(4, "Kiwifruit");
        if (ListA.size() < ListB.size()) {
            System.out.println("ListB has more elements.");
        } else if (ListA.size() == ListB.size()) {
            System.out.println("ListA and List B have the same number of elements.");
        } else {
            System.out.println("ListA has more elements.");
        }
        System.out.println(ListA.indexOf("Avocado"));
        System.out.println((ListB.indexOf("Durian")));
        ListB.addAll(Arrays.asList("Passion Fruit", "Pomelo"));
        System.out.println(ListA.get(2));
    }
}
