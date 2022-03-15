package characters;

public interface Hero {
    void attack(Hero enemy); //атака противника

    void damage(int value); //нанесение урона

    void move(int step); //передвижение

    int getLocation(); //локация противника

    boolean detectEnemy(Hero enemy); //определение противника

    boolean alive(); //жизнеспособность

    void superYuppers(); //супер способность

    void action(Hero enemy, boolean turn); //ход героя

    String getName(); //имя героя

    int getHp(); //кол-во жизней
}
