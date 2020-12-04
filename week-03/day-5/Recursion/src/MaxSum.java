import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxSum {
    // Create a function called `maxSum` which
// expects an array of five integers as an input parameter and
// returns the maximum values that can be
// calculated by summing exactly four of the five integers.
//
// Examples
//
// [1 2 3 4 5] -> 14
//
// We can calculate the following sums using four of the five integers:
//
// 1 + 2 + 3 + 4 = 10
// 1 + 2 + 3 + 5 = 11
// 1 + 2 + 4 + 5 = 12
// 1 + 3 + 4 + 5 = 13
// 2 + 3 + 4 + 5 = 14
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Provide 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Number:");
            int num = scanner.nextInt();
            numbers.add(num);
        }
        int counter = 0;
        System.out.print(numbers);
        System.out.println(" -> " + maximumSum(numbers, counter));
    }

    private static Integer maximumSum(List<Integer> numbers, int counter) {
        if (counter == 4) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += numbers.get(i);
            }
            return sum;
        }

        int sum = maximumSum(numbers, counter + 1);
        if (counter < 4) {
            int item = numbers.get(counter);
            numbers.remove(counter);
            int localSum = 0;
            for (int i = 0; i < 4; i++) {
                localSum += numbers.get(i);
            }
            if (localSum > sum) {
                sum = localSum;
            }
            numbers.add(counter, item);
        }
        return sum;
    }
}
