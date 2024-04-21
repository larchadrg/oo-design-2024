package weapons;

import characters.FightStyle;
import output.ScreenLogger;

public class BareHands extends Weapon implements WeaponBehaviour{
    public BareHands(){
        fightStyle = FightStyle.MELEE;
    }

    @Override
    public String getName() {
        return "Fist";
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
