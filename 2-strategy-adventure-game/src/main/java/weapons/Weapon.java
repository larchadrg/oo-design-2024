package weapons;

import characters.FightStyle;
import output.Output;

public abstract class Weapon implements WeaponBehaviour{
    FightStyle fightStyle;

    @Override
    public FightStyle getFightStyle() {
        return fightStyle;
    }
}
