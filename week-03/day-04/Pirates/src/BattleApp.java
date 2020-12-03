public class BattleApp {
    public static void main(String[] args) {
        Ship ship1 = new Ship();
        ship1.fillShip();
        ship1.printCrew();

        Ship ship2 = new Ship();
        ship2.fillShip();
        ship2.printCrew();

        ship1.battle(ship2);

        ship1.fillShip();
        ship2.fillShip();

        ship1.partyTime();
        ship2.partyTime();

        ship1.battle(ship2);
    }
}
