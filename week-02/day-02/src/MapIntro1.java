import java.util.HashMap;
import java.util.Map;

public class MapIntro1 {
    public static void main(String[] args) {
        Map<Integer, Character> test = new HashMap<>();
        System.out.println(test.isEmpty());
        test.put(97, 'a');
        test.put(98, 'b');
        test.put(99, 'c');
        test.put(65, 'A');
        test.put(66, 'B');
        test.put(67, 'C');
        for (Integer key : test.keySet()) {
            System.out.println(key);
        }
        for (Character value : test.values()) {
            System.out.println(value);
        }
        test.put(68, 'D');
        System.out.println(test.size());
        System.out.println(test.get(99));
        test.remove(97);
        System.out.println(test.containsKey(100));
        test.clear();

    }
}
