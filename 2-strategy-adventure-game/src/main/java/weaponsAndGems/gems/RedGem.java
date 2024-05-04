package weaponsAndGems.gems;
import weaponsAndGems.Weapon;

public class RedGem extends Gem{
    public RedGem(Weapon weapon){
        super(weapon);
        gemDamage = 20;
    }

    @Override
    public String getName() {
        return weapon.getName() + ", red gem";
    }
}
