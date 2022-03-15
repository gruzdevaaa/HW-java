package characters.character.shooter;

import characters.Hero;
import characters.character.BaseHero;

public class Archer implements Hero {
    private BaseHero base;

    public Archer(BaseHero base) {
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
    public void superYuppers() {

    }

    @Override
    public void action(Hero enemy, boolean turn)
    {
        this.base.action(enemy, turn);
    }
}
