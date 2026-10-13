public class Player extends GameCharacter {

    private int healingPotions = 3;

    public Player(String name, int health, int attackDamage) {
        super(name, health, attackDamage);
    }

    public int getHealingPotions() {
        return healingPotions;
    }

    public boolean useHealingPotion() {
        if (healingPotions <= 0 || getHealth() >= getMaxHealth()) {
            return false;
        }
        heal(20);
        healingPotions--;
        return true;
    }

}
