package characters.character;

import characters.Hero;

import java.util.Random;

public class BaseHero implements Hero {
    private int attackRange; //дальность атаки
    private int mp; //защита
    private int hitMin; //наносимый урон - min
    private int hitMax; // наносимый урон - max
    private int hp; //здоровье
    private final int speed; //скорость
    private boolean privilege; //есть ли плюшка
    private int location; //Х-координата
    private String name; //тип героя

    private final Random random = new Random();

    public BaseHero(String name, int attackRange, int mp, int hitMin, int hitMax, int hp, int speed, boolean privilege, int location) {
        this.name = name;
        this.attackRange = attackRange;
        this.mp = mp;
        this.hitMin = hitMin;
        this.hitMax = hitMax;
        this.hp = hp;
        this.speed = speed;
        this.privilege = privilege;
        this.location = location;
    }

    public void setHitMax(int hitMax) {
        this.hitMax = hitMax;
    }

    public int getHitMax() {
        return hitMax;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLocation() {
        return location;
    }

    @Override
    //генерация наносимого урона выбирается рандомом из диапазона
    public void attack(Hero enemy) {
        int dealtDamage = random.nextInt(this.hitMin, this.hitMax + 1);
        System.out.println("Hero hit enemy with " + dealtDamage + " HP.");
        enemy.damage(dealtDamage);
    }

    @Override
    public void damage(int value) {
        //как только закончится мана защиты отнимаем жизни
        if (this.mp > 0) {
            if (value > this.mp) {
                this.hp -= value - this.mp;
                this.mp = 0;
            } else {
                this.mp -= value;
            }
            System.out.println("Current MP: " + this.mp);
        } else {
            this.hp -= value;
        }
    }

    @Override
    public void move(int step) {
        System.out.println("Hero moved forward " + Math.abs(step) + " steps.");
        this.location += step;
        System.out.println("Current location: " + this.location + ".");
    }

    @Override
    public boolean detectEnemy(Hero enemy) {
        System.out.println("Enemy is in attack range: " + (this.attackRange >= Math.abs(enemy.getLocation() - this.location)));
        return (this.attackRange >= Math.abs(enemy.getLocation() - this.location));
    }

    @Override
    public boolean alive() {
        return (this.hp >= 0);
    }

    @Override
    public void superYuppers() {
        System.out.println("Hero uses super-power.");
    }

    @Override
    public void action(Hero enemy, boolean turn) {
        if(detectEnemy(enemy)) {
            if (this.privilege) {
                if(random.nextBoolean()) {
                    attack(enemy);
                } else {
                    superYuppers();
                }
            } else {
                attack(enemy);
            }
        } else {
            if (turn) { //флаг начального расположения героя
                move(speed);
            } else {
                move(-speed);
            }
        }
    }
}
