public class AppendAFunc {
    public static void main(String[] args) {
        String typo = "Chinchill";
        System.out.println(appensAFunc(typo));
    }

    public static String appensAFunc(String typo) {
        typo += "a";
        return typo;
    }
}
