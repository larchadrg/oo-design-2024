package characters;

import output.Output;

public class Mage extends GameCharacter {
    public Mage(int lifePoints, int speed){
        super(lifePoints, speed);
        fightStyle = FightStyle.MAGIC;
        name = "Mage";
    }
}
