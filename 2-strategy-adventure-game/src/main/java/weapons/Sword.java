package weapons;

import characters.FightStyle;
import output.ScreenLogger;

public class Sword extends Weapon{
    public Sword() {
        fightStyle = FightStyle.MELEE;
    }

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public int getDamage() {
        return 40;
    }
}
