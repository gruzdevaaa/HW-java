package characters;

import java.util.Random;

public class Battle {
    private final Hero first;
    private final Hero second;

    private final Random random = new Random();
    private static final int BOUND = 51;
    private static final int CONDITION = 25;

    public Battle(Hero first, Hero second) {
        this.first = first;
        this.second = second;
    }

    public String winner() {
        if (this.first.alive()) {
            return this.first.getName() + " win.";
        }
        return this.second.getName() + " win";
    }

    public void vitals() {
        System.out.println(this.first.getName() + "'s current health: " + this.first.getHp() + " HP.");
        System.out.println(this.second.getName() + "'s current health: " + this.second.getHp() + " HP.");
    }

    public void fight() {
        System.out.println("THE BATTLE BEGINS!");
        int count = 1;
        do {
            System.out.println((count) + " ROUND.");
            vitals();
            if (random.nextInt(BOUND) > CONDITION) {
                System.out.println("It is " + this.first.getName() + "'s turn.");
                this.first.action(this.second, true);
            } else {
                System.out.println("It is " + this.second.getName() + "'s turn.");
                this.second.action(this.first, false);
            }
            count++;
        } while (this.first.alive() && this.second.alive());

        System.out.println(winner());
    }
}
