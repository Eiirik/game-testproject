public abstract class GameCharacter {
    private String name;
    private int health;
    private final int maxHealth;
    private int attackDamage;

    public GameCharacter(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackDamage = attackDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    // might not need setHealth() method
    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        // Sets the player's health to health - damage. If that is less than 0, it sets health to 0.
        this.health = Math.max(0, health - damage);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(GameCharacter target) {
        target.takeDamage(this.attackDamage);
    }

    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot heal less than 0 HP");
        }
        // amount param will get added to current health. Cannot exceed maxHealth.
        health = Math.min(health + amount, maxHealth);
    }
}
