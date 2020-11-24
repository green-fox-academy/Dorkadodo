import java.util.ArrayList;
import java.util.List;

public class ListIntro1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        System.out.println(names.size());
        names.add("William");
        System.out.println(names.isEmpty());
        names.add("John");
        names.add("Amanda");
        System.out.println(names.size());
        System.out.println(names.get(2));
        for (String name : names) {
            System.out.println(name);
        }
        for (int i = 1; i < names.size() + 1; i++) {
            System.out.println(i + ". " + names.get(i - 1));
        }
        names.remove(1);
        for (int i = names.size(); i > 0; i--) {
            System.out.println(names.get(i - 1));
        }
        names.clear();
        System.out.println(names.size());
    }

}
