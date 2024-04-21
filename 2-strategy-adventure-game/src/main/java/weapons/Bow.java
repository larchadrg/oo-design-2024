package weapons;

import characters.FightStyle;
import output.ScreenLogger;

public class Bow extends Weapon implements WeaponBehaviour {

    public Bow() {
        fightStyle = FightStyle.RANGED;
    }

    @Override
    public String getName(){
        return "Bow";
    }

    @Override
    public int getDamage() {
        return 50;
    }
}
