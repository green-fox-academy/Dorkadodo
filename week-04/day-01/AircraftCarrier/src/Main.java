public class Main {
    public static void main(String[] args) {
        Carrier carrier = new Carrier(50, 1000);
        carrier.addF16();
        carrier.addF35();
        carrier.addF16();
        carrier.addF35();
        carrier.addF16();
        carrier.addF35();
        carrier.fill();
        carrier.getStatus();
        System.out.println();

        Carrier carrier1 = new Carrier(60, 1000);
        carrier.addF16();
        carrier.addF35();
        carrier.addF16();
        carrier.addF35();
        carrier.addF16();
        carrier.addF35();
        carrier.fill();
        carrier.getStatus();
        System.out.println();

        carrier.fight(carrier1);
        carrier.getStatus();
        System.out.println();
        carrier1.getStatus();
    }
}
