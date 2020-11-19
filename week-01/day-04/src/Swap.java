public class Swap {
    public static void main(String[] args) {
        int a = 123;
        int b = 526;
        int c;

        System.out.println("First number is " + a);
        System.out.println("Second number is " + b);

        c = a;
        a = b;
        b = c;

        System.out.println("Now the first number is " + a);
        System.out.println("Now the second number is " + b);
    }
}
