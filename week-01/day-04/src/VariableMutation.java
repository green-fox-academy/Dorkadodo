public class VariableMutation {
    public static void main(String[] args) {
        int a = 3;
        a += 10;
        System.out.println(a);

        int b = 100;
        b -= 7;
        System.out.println(b);

        int c = 44;
        c = c * 2;
        System.out.println(c);

        int d = 125;
        d = d / 5;
        System.out.println(d);

        int e = 8;
        e = e * e * e;
        System.out.println(e);

        int f1 = 123;
        int f2 = 345;
        boolean answer = f1 > f2;
        System.out.println(f1 + " is bigger than " + f2 + ": " + answer);
        // tell if f1 is bigger than f2 (print as a boolean)

        int g1 = 350;
        int g2 = 200;
        answer = (g2 * 2) > g1;
        System.out.println("The double of " + g2 + " is bigger than " + g1 + ": " + answer);
        // tell if the double of g2 is bigger than g1 (print as a boolean)

        int h = 135798745;
        answer = (h % 11 == 0);
        System.out.println("11 is a divider of " + h + ": " + answer);        // tell if it has 11 as a divisor (print as a boolean)

        int i1 = 10;
        int i2 = 3;
        answer = (i1>(i2*i2)) && (i1<(i2*i2*i2));
        System.out.println(i1 + " is higher than " + i2 +
                " squared and smaller than " + i2 + " cubed: " + answer);        // tell if i1 is higher than i2 squared and smaller than i2 cubed (print as a boolean)

        int j = 1521;
        answer = (j % 3 == 0) || (j % 5 == 0);
        System.out.println(j + " is dividable by 3 or 5: " + answer);
        // tell if j is dividable by 3 or 5 (print as a boolean)
    }
}