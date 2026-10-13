import java.util.Scanner;

import static java.lang.IO.println;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Fjooltuf", 100, 15);
        Scanner scanner = new Scanner(System.in);

        Monster[] monsters = {
                new Monster("Grundor", 40,  14),
                new Monster("Orc", 50,  18),
                new Monster("Dragon", 80,  8),
        };

        for (Monster monster : monsters) {
            println("A wild " + monster.getName() + " appears!");

            runBattle(player, monster, scanner);

            // If player dies we break out of the for-loop / battle.
            if (!player.isAlive()) {
                break;
            }

            println("You defeated " + monster.getName() + "!");
        }

        if (player.isAlive()) {
            println("You defeated every monster. Victory!");
        } else {
            println("Your adventure ends here.");
        }

    }

    private static void runBattle(Player player, Monster monster, Scanner scanner) {
        while (player.isAlive() && monster.isAlive()) {

            println("""
                    What do you want to do?
                    1: Attack
                    2: Heal""");

            // hasNextInt() checks whether the next input can be read as an integer, without consuming it.
            if (!scanner.hasNextInt()) {
                println("Please enter a number.");
                scanner.nextLine(); // Discard the invalid input.
                continue;
            }
            int action = scanner.nextInt();
            scanner.nextLine();

            if (action == 1) {
                player.attack(monster);
                println(player.getName() + " attacked " + monster.getName());
            } else if (action == 2) {
                int healthBefore = player.getHealth();
                if (!player.useHealingPotion()) {
                    println("Cannot heal: no potions left or health is already full.");
                    continue;
                }
                int healed = player.getHealth() - healthBefore;
                println(player.getName() + " recovered " + healed + " HP");
                println("Potions remaining: " + player.getHealingPotions());

            } else {
                println("Invalid action. Choose 1 or 2.");
                continue;
                /*
                continue skips the rest of the current loop iteration and shows the menu again.
                Without it, entering something like 3 lets the monster attack even though the player made no valid move.
                 */
            }

            if (monster.isAlive()) {
                monster.attack(player);
                println(monster.getName() + " attacked " + player.getName());
            }

            println(player.getName() + " has " + player.getHealth() + " HP | " + monster.getName() + " has " + monster.getHealth() + " HP");
        }
    }
}
