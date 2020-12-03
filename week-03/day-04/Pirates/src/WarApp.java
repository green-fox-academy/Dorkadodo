public class WarApp {
    public static void main(String[] args) {
        Armada armada1 = new Armada();
        armada1.collectShipsForArmada();
        Armada armada2 = new Armada();
        armada2.collectShipsForArmada();
        armada1.war(armada2);


    }
}
