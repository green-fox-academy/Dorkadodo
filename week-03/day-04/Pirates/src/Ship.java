import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ship {
    private String shipName;
    private List<Pirates> crew;
    private Pirates captain;
    private boolean wasWinnerOfLastBattle = false;


    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private List<String> shipNames() {
        List<String> shipNames = new ArrayList<>();
        try {
            Path namePath = Paths.get("names.txt");
            shipNames = Files.readAllLines(namePath);
        } catch (IOException ex) {
            shipNames.add("Albert");
            shipNames.add("Bob");
            shipNames.add("BlackBeard");
        }
        return shipNames;
    }

    private List<String> shipNames = shipNames();

    public Ship() {
        String answer;
        crew = new ArrayList<>();
        do {
            System.out.println("Would you like to name the ship? press y or n");
            answer = scanner.next();
            if (answer.equals("y")) {
                System.out.println("Name of the ship:");
                shipName = scanner.next();
            } else if (answer.equals("n")) {
                shipName = shipNames.get(random.nextInt(shipNames.size()));
            } else {
                System.out.println("Wrong input.");
            }
        }
        while (!(answer.equals("y") || answer.equals("n")));
        System.out.println(shipName + " is added to the armada.");

    }

    public String getShipName() {
        return shipName;
    }

    public Pirates getCaptain() {
        return captain;
    }

    public List<Pirates> getCrew() {
        return crew;
    }

    public Pirates getCrewMember(int i) {
        return crew.get(i);
    }

    private void addPirate() {
        Pirates pirate = new Pirates();
        crew.add(pirate);
        System.out.println(pirate.getName() + " is added to the crew of " + shipName);
    }

    private void addCaptain() {
        Pirates pirate = new Pirates();
        captain = pirate;
        System.out.println(pirate.getName() + " is added as captain to the crew of " + shipName);

    }

    public void fillShip() {
        addCaptain();
        for (int i = 0; i < random.nextInt(5) + 5; i++) {
            addPirate();
        }
    }

    public void printCrew() {
        System.out.println("The captain of the ship is " + captain.getName());
        System.out.println("The crew:");
        for (int i = 0; i < crew.size(); i++) {
            System.out.println(crew.get(i).getName());
        }
    }

    private int numberOFAlivePirates() {
        int counter = 0;
        for (int i = 0; i < crew.size(); i++) {
            if (crew.get(i).getIsAlive()) {
                counter++;
            }
        }
        return counter;
    }

    public void statusOfShip() {
        System.out.println("The status of the ship " + shipName);
        System.out.println("Captain: " + captain.getName() +
                "\n  who already consumed " + captain.getIntoxication() + " rum");
        if (captain.getIsAlive()) {
            if (captain.getIsPassedOut()) {
                System.out.println("  and is passed out but alive.");
            } else {
                System.out.println("  and is alive and awake.");
            }
        } else {
            System.out.println("  and already died.");
        }
        System.out.println("There are " + numberOFAlivePirates() + " pirates alive on the ship.");
    }

    public int getBattleScore() {
        return numberOFAlivePirates() - captain.getIntoxication();
    }

    public void battle(Ship ship) {
        Ship winner;
        Ship loser;
        System.out.println();
        System.out.println(this.shipName + " and " + ship.shipName + " will have a battle.");
        System.out.println("Battle score of " + this.shipName + ": " + this.getBattleScore());
        System.out.println("Battle score of " + ship.shipName + ": " + ship.getBattleScore());
        if (this.getBattleScore() < ship.getBattleScore()) {
            winner = ship;
            loser = this;
        } else if (this.getBattleScore() > ship.getBattleScore()) {
            winner = this;
            loser = ship;
        } else {
            battleLosses(ship);
            battleLosses(this);
            System.out.println("The battle ended with a draw.");
            return;
        }
        battleLosses(loser);
        battleWinnings(winner);
        printBattleResult(winner, loser);
    }

    private void printBattleResult(Ship winner, Ship loser) {
        System.out.println("The winner is the ship " + winner.shipName);
        winner.statusOfShip();
        System.out.println("The loser is the ship " + loser.shipName);
        loser.statusOfShip();
    }

    private void battleWinnings(Ship winner) {
        for (int i = 0; i < winner.getCrew().size(); i++) {
            winner.getCrewMember(i).drinkSomeRum();
        }
        winner.captain.drinkSomeRum();
        winner.wasWinnerOfLastBattle = true;
    }

    private void battleLosses(Ship loser) {
        for (int i = 0; i < random.nextInt(loser.getCrew().size()); i++) {
            loser.getCrewMember(i).die();
        }
        loser.wasWinnerOfLastBattle = false;
    }

    public void partyTime() {
        System.out.println("Party Time!");
        for (int i = 0; i < getCrew().size(); i++) {
            getCrewMember(i).drinkSomeRum();
        }
        captain.drinkSomeRum();
        getCrewMember(random.nextInt(getCrew().size())).brawl(getCrewMember(random.nextInt(getCrew().size())));
    }

    public boolean wasWinnerOfLastBattle() {
        return wasWinnerOfLastBattle;
    }
}
