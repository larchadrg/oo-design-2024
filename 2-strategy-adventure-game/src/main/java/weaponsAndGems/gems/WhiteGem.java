package weaponsAndGems.gems;
import weaponsAndGems.Weapon;

public class WhiteGem extends Gem {
    public WhiteGem(Weapon weapon){
        super(weapon);
        gemDamage = 10;
    }

    @Override
    public String getName() {
        return weapon.getName() + ", white gem";
    }
}
