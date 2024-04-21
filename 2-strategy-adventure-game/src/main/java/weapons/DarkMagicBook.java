package weapons;

import characters.FightStyle;
import output.ScreenLogger;

public class DarkMagicBook  extends Weapon implements WeaponBehaviour{
    @Override
    public String getName() {
        return "Dark Magic Book";
    }

    @Override
    public FightStyle getFightStyle() {
        return FightStyle.MAGIC;
    }

    @Override
    public int getDamage() {
        return 80;
    }
}
