import java.util.ArrayList;
import java.util.List;

public class Carrier {
    List<Aircraft> aircrafts;
    private int amountOfAmmoStored;
    private int HP;

    public Carrier(int amountOfAmmoStored, int HP) {
        aircrafts = new ArrayList<>();
        this.amountOfAmmoStored = amountOfAmmoStored;
        this.HP = HP;
    }

    public void addF16() {
        Aircraft F16 = new F16();
        aircrafts.add(F16);
    }

    public void addF35() {
        Aircraft F35 = new F35();
        aircrafts.add(F35);
    }

    public void fill() {
        boolean fillPriority = true;
        fillQueue(fillPriority);
        fillPriority = false;
        fillQueue(fillPriority);
    }

    private void fillQueue(boolean isPriority) {
        try {
            for (Aircraft aircraft : aircrafts) {
                checkAmmoAmount();
                if (isPriority) {
                    amountOfAmmoStored = aircraft.refill(amountOfAmmoStored);
                }
            }
        } catch (OutOfAmmoException ex) {
            System.out.println("You are out of Ammo");
        }

    }

    private void checkAmmoAmount() throws OutOfAmmoException {
        if (amountOfAmmoStored <= 0) {
            throw new OutOfAmmoException("You are out of Ammo");
        }
    }

    public void fight(Carrier carrier) {
        int damage = 0;
        for (Aircraft aircraft : aircrafts) {
            damage += aircraft.fight();
        }
        carrier.HP -= damage;
    }

    private int getTotalDamage() {
        int totalDamage = 0;
        for (Aircraft aircraft : aircrafts) {
            totalDamage = aircraft.getAmountOfAmmo() * aircraft.getBaseDamage();
        }
        return totalDamage;
    }

    public void getStatus() {
        if (HP > 0) {
            System.out.println("HP: " + HP + ", Aircraft count: " + aircrafts.size() + ", Ammo Storage: "
                    + amountOfAmmoStored + ", Total damage: " + getTotalDamage());
            System.out.println("Aircrafts:");
            for (Aircraft aircraft : aircrafts) {
                aircraft.getStatus();
            }
        } else {
            System.out.println("It's dead Jim :(");
        }
    }
}
