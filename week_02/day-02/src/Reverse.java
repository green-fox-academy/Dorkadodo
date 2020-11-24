public class Reverse {
    public static void main(String... args) {
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Create a method that can reverse a String, which is passed as the parameter
        // Use it on this reversed string to check it!
        // Try to solve this using charAt() first, and optionally anything else after.

        System.out.println(reverse(toBeReversed));
        System.out.println(reverse2(toBeReversed));

    }

    public static String reverse(String toBeReversed) {
        char[] charToBeReversed = new char[toBeReversed.length()];
        String reverse = "";
        for (int i = 0; i < toBeReversed.length(); i++) {
            charToBeReversed[i] = toBeReversed.charAt(toBeReversed.length() - i - 1);
            reverse = reverse + charToBeReversed[i];
        }
        return reverse;
    }

    public static String reverse2(String toBeReversed) {
        String reverse = "";
        for (int i = 0; i < toBeReversed.length(); i++) {
            reverse += toBeReversed.substring(toBeReversed.length() - i - 1, toBeReversed.length() - i);
        }
        return reverse;
    }
}