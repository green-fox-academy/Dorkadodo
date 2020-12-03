import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Armada {
    private String nationOfArmada;
    private ArrayList<Ship> listOfShips;
    private boolean wonTheLastWar = false;

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private List<String> nations() {
        List<String> nations = new ArrayList<>();
        try {
            Path namePath = Paths.get("nations.txt");
            nations = Files.readAllLines(namePath);
        } catch (IOException ex) {
            nations.add("England");
            nations.add("France");
            nations.add("Spain");
        }
        return nations;
    }

    private List<String> nations = nations();

    public Armada() {
        String answer;
        listOfShips = new ArrayList<>();
        do {
            System.out.println("Would you like to decide the nation? press y or n");
            answer = scanner.next();
            if (answer.equals("y")) {
                System.out.println("Nationality of the armada:");
                nationOfArmada = scanner.next();
            } else if (answer.equals("n")) {
                nationOfArmada = nations.get(random.nextInt(nations.size()));
            } else {
                System.out.println("Wrong input.");
            }
        }
        while (!(answer.equals("y") || answer.equals("n")));
        System.out.println(nationOfArmada + " created its armada.");
    }

    public String getNationOfArmada() {
        return nationOfArmada;
    }

    public void collectShipsForArmada() {
        Ship ship;
        for (int i = 0; i < 4; i++) {
            ship = new Ship();
            ship.fillShip();
            listOfShips.add(ship);
        }
    }

    public ArrayList<Ship> getlistOfShips() {
        return listOfShips;
    }

    public Ship getArmadaShip(int index) {
        return listOfShips.get(index);
    }

    public void addArmadaShip(Ship ship) {
        listOfShips.add(ship);
    }

    public boolean war(Armada armada) {
        System.out.println();
        System.out.println("The war begins between " + this.nationOfArmada + " and " + armada.nationOfArmada);

        while ((!(this.listOfShips.size() == 0)) && (!(armada.listOfShips.size() == 0))) {
            this.getArmadaShip(0).battle(armada.getArmadaShip(0));
            if (this.getArmadaShip(0).wasWinnerOfLastBattle()) {
                armada.getlistOfShips().remove(0);
            } else if (armada.getArmadaShip(0).wasWinnerOfLastBattle()) {
                this.getlistOfShips().remove(0);
            }
        }
        winnerOfTheWar(armada);
        return this.wonTheLastWar;
    }

    private void winnerOfTheWar(Armada armada) {
        if (this.listOfShips.size() == 0) {
            System.out.println(armada.nationOfArmada + " won the war.");
            this.wonTheLastWar = false;
            armada.wonTheLastWar = true;
        } else {
            System.out.println(this.nationOfArmada + " won the war.");
            armada.wonTheLastWar = false;
            this.wonTheLastWar = true;
        }
    }
}
