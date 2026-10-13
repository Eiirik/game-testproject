import static java.lang.IO.println;

public class Main {
    public static void main(String[] args) {

        GameCharacter player = new Player("Fjooltuf", 100, 15);
        GameCharacter monster = new Monster("Grundor", 40, 8);

        while (player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            println(player.getName() + " attacked " + monster.getName());

            if (monster.isAlive()) {
                monster.attack(player);
                println(monster.getName() + " attacked " + player.getName());
            }
        }

        println();
        println(player.getName() + " has " + player.getHealth() + " HP");
        println(monster.getName() + " has " + monster.getHealth() + "HP");

    }
}
