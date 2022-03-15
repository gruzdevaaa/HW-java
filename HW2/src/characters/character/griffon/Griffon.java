package characters.character.griffon;

import characters.Hero;
import characters.character.BaseHero;

import java.util.Random;

public class Griffon implements Hero {
    private BaseHero base;

    private final Random random = new Random();

    public Griffon(BaseHero base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return this.base.getName();
    }

    @Override
    public int getHp() {
        return this.base.getHp();
    }

    @Override
    public void attack(Hero enemy) {
        this.base.attack(enemy);
    }

    @Override
    public void damage(int value) {
        this.base.damage(value);
    }

    @Override
    public void move(int step) {
        this.base.move(step);
    }

    @Override
    public int getLocation() {
        return this.base.getLocation();
    }

    @Override
    public boolean detectEnemy(Hero enemy) {
        return this.base.detectEnemy(enemy);
    }

    @Override
    public boolean alive() {
        return this.base.alive();
    }

    @Override
    //плюшка увеличивает максимальную атаку в двое
    public void superYuppers() {
        System.out.println("The maximum damage is now doubled.");
        base.setHitMax(base.getHitMax()*2);
    }

    @Override
    public void action(Hero enemy, boolean turn)
    {
        if(detectEnemy(enemy)) {
            if(random.nextBoolean()) {
                attack(enemy);
            } else {
                superYuppers();
            }
        } else {
            if (turn) {
                move(this.base.getSpeed());
            } else {
                move(-this.base.getSpeed());
            }
        }
    }
}
