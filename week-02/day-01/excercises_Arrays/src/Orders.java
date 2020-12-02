import java.util.Arrays;

public class Orders {
    public static void main(String[] args) {
        String[] orders = {"first", "second", "third"};
        String container;
        container = orders[0];
        orders[0] = orders[2];
        orders[2] = container;
        System.out.println(Arrays.toString(orders));
    }
}
