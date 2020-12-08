public class Main {
    public static void main(String[] args) {
        Gnirts gnirt = new Gnirts("Does it work correctly?");
        System.out.println(gnirt.charAt(4));
        System.out.println(gnirt.length());
        System.out.println(gnirt.subSequence(5, 10));
        System.out.println(gnirt.toString());

        ShiftedCharSequence shifter = new ShiftedCharSequence("example", 2);
        System.out.println(shifter.charAt(0));
    }
}
