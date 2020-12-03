import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pirates {
    private String name;
    private int intoxication = 0;
    private boolean isAlive = true;
    private boolean isPassedOut = false;

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private List<String> names = names();

    private List<String> names() {
        List<String> names = new ArrayList<>();
        try {
            Path namePath = Paths.get("names.txt");
            names = Files.readAllLines(namePath);
        } catch (IOException ex) {
            names.add("Albert");
            names.add("Bob");
            names.add("BlackBeard");
        } return names;
    }

    public Pirates() {
        String answer;
        do {
            System.out.println("Would you like to name the pirate? press y or n");
            answer = scanner.next();
            if (answer.equals("y")) {
                System.out.println("Name of the pirate:");
                name = scanner.next();
            } else if (answer.equals("n")) {
                name = names.get(random.nextInt(names.size()));
            } else {
                System.out.println("Wrong input.");
            }
        }
        while (!(answer.equals("y") || answer.equals("n")));
        System.out.println(name + " is a new pirate.");
    }

    public int getIntoxication() {
        return intoxication;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public boolean getIsPassedOut() {
        return isPassedOut;
    }

    public String getName() {
        return name;
    }

    public void drinkSomeRum() {
        if (isAlive) {
            intoxication += random.nextInt(5);
        } else {
            dead();
        }
    }

    private void dead() {
        System.out.println(name + " is dead.");
    }

    public void die() {
        if (isAlive) {
            isAlive = false;
            System.out.println(name + " just died.");
        } else {
            dead();
        }
    }

    public void howsItGoingMate() {
        if (isAlive) {
            if (intoxication < 5) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
            }
        } else {
            dead();
        }
    }

    public void brawl(Pirates pirate) {
        if (isAlive) {
            if (pirate.isAlive) {
                Random random = new Random();
                int result = random.nextInt(3);
                System.out.println("A brawl started between " + name + " and " + pirate.name);
                switch (result) {
                    case 0:
                        this.die();
                        break;
                    case 1:
                        pirate.die();
                        break;
                    case 2:
                        this.isPassedOut = true;
                        pirate.isPassedOut = true;
                        System.out.println("The brawl is a draw, they both passed out.");
                        break;
                }
            } else {
                pirate.dead();
            }
        } else {
            dead();
        }
    }

    public void douseWithWater(Pirates pirate) {
        if (this.isAlive) {
            if (isAlive) {
                if (isPassedOut) {
                    isPassedOut = false;
                    intoxication = 0;
                    System.out.println("You can stop pouring water, I am awake!");
                } else {
                    System.out.println("Hey mate, I wasn't passed out! I'ma kill you for this!");
                    this.brawl(pirate);
                }
            } else {
                dead();
            }
        } else {
            this.dead();
        }
    }
}
