import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonalFinance {
    public static void main(String[] args) {
        List<Integer> finance = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));
        System.out.println("This month, I spent " + sum(finance) + ".");
        System.out.println("This month, my greatest expense was " + greatest(finance) + ".");
        System.out.println("This month, my cheapest expense was " + cheapest(finance) + ".");
        System.out.println("This month, my average expense was " + average(finance) + ".");

    }

    public static int sum(List<Integer> finance) {
        int sum = 0;
        for (Integer expense : finance) {
            sum += expense;
        }
        return sum;
    }

    public static int greatest(List<Integer> finance) {
        int max = finance.get(0);
        for (Integer expense : finance) {
            if (expense > max) {
                max = expense;
            }
        }
        return max;
    }

    public static int cheapest(List<Integer> finance) {
        int min = finance.get(0);
        for (Integer expense : finance) {
            if (expense < min) {
                min = expense;
            }
        }
        return min;
    }

    public static double average(List<Integer> finance) {
        double average = 0;
        for (Integer expense : finance) {
            average += expense;
        }
        average = average / finance.size();
        return average;
    }

}
