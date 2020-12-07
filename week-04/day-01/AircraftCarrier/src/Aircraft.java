public class Aircraft {
    private String type;
    private int amountOfAmmo;
    private int maxAmmo;
    private int baseDamage;
    private boolean priority;

    protected Aircraft(String type, int amountOfAmmo, int maxAmmo, int baseDamage, boolean priority) {
        this.type = type;
        this.amountOfAmmo = amountOfAmmo;
        this.maxAmmo = maxAmmo;
        this.baseDamage = baseDamage;
        this.priority = priority;
    }

    public int fight() {
        int damage = amountOfAmmo * baseDamage;
        amountOfAmmo = 0;
        return damage;
    }

    public int refill(Integer amount) {
        amountOfAmmo += amount;
        int remaining = 0;
        if (amountOfAmmo > maxAmmo) {
            remaining = amountOfAmmo - maxAmmo;
            amountOfAmmo = maxAmmo;
        }
        return remaining;
    }

    public String getType() {
        return type;
    }

    public int getAmountOfAmmo(){
        return amountOfAmmo;
    }

    public boolean isPriority() {
        return priority;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void getStatus() {
        System.out.println("Type: " + type + ", Ammo: " + amountOfAmmo + ", Base Damage: " + baseDamage
                + ", Damage: " + amountOfAmmo * baseDamage);
    }
}
