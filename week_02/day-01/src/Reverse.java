import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 6, 7};
        int container;

        for (int i = 0; i < ((numbers.length - 1) / 2); i++) {
            container = numbers[i];
            numbers[i] = numbers[(numbers.length - 1 - i)];
            numbers[numbers.length - 1 - i] = container;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
