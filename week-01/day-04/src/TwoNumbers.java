public class TwoNumbers {
    public static void main(String[] args) {

        int num1 = 13;
        int num2 = 22;

        int result = num1 + num2;
        System.out.println("13 + 22 = " + result);

        result = num1 - num2;
        System.out.println("13 - 22 = " + result);

        result = num1 * num2;
        System.out.println("13 * 22 = " + result);

        double decimalresult = (double) 22 / 13;
        System.out.println("22 / 13 = " + decimalresult);

        result = num2 / num1;
        int remainder = num2 - (result * num1);
        System.out.println("22 / 13 = " + result + " egész, a maradék: " + remainder);
    }
}
