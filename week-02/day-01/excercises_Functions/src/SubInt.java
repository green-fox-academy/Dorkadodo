import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SubInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get digit
        System.out.println("Enter one digit: ");
        int num = scanner.nextInt();

        //get list
        System.out.println("Now enter five numbers for the list: ");
        int[] subIntArray = new int[5];
        for (int i = 0; i < subIntArray.length; i++) {
            System.out.println("Enter the " + (i + 1) + ". number of the list:");
            subIntArray[i] = scanner.nextInt();
        }
        System.out.println(subInteger(subIntArray, num));
    }

    public static String subInteger(int[] subIntArray, int num) {

        //convert integer array to string array
        String strSubInt[] = new String[subIntArray.length];
        for (int i = 0; i < subIntArray.length; i++)
            strSubInt[i] = String.valueOf(subIntArray[i]);

        //convert digit to string
        String strNum = String.valueOf(num);

        //function
        String index = "";
        for (int i = 0; i < subIntArray.length; i++) {
            if (strSubInt[i].contains(strNum)) {
                index += i + ", ";
            }
        }
        return index.substring(0, index.length() - 2);
    }
}
