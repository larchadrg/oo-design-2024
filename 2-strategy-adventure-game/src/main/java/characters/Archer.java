package characters;

import output.Output;

public class Archer extends GameCharacter {
    public Archer(int baseLifePoints, int speed) {
        super(baseLifePoints, speed);
        fightStyle = FightStyle.RANGED;
        name = "Archer";
    }
}
