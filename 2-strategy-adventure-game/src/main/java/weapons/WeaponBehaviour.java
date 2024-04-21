package weapons;

import characters.FightStyle;

public interface WeaponBehaviour {
    public String getName();
    public FightStyle getFightStyle();

    int getDamage();
}
