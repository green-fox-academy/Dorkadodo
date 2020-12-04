import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumFinder {
    // Write a function that finds the largest element of an array using recursion.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Provide 7 numbers:");
        for (int i = 0; i < 7; i++) {
            System.out.println("Number:");
            int num = scanner.nextInt();
            numbers.add(num);
        }
        System.out.println(maximumFinder(numbers));
    }

    private static Integer maximumFinder(List<Integer> numbers) {
        if (numbers.size() == 1) {
            return numbers.get(0);
        }
        int item = numbers.get(numbers.size() - 1);

        if (numbers.size() > 1) {
            numbers.remove(numbers.size() - 1);
            int num = maximumFinder(numbers);
            if (item < num) {
                return num;
            }

        }
        return item;

    }
}