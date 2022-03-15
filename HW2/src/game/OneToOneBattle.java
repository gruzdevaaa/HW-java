package game;

import characters.Battle;
import characters.character.BaseHero;
import characters.character.griffon.Griffon;
import characters.character.shooter.Archer;

public class OneToOneBattle {
    public static void main (String[] args)
    {
        Archer archer = new Archer(new BaseHero("Archer", 6, 3, 2,
                3, 10, 4, false, 0));
        Griffon griffon = new Griffon(new BaseHero("Griffon", 8, 8, 3,
                6, 25, 6, true, 25));

        new Battle(archer, griffon).fight();
    }
}
