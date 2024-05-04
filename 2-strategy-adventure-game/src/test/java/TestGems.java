import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weaponsAndGems.gems.RedGem;
import weaponsAndGems.gems.WhiteGem;
import weaponsAndGems.weapons.Bow;
import weaponsAndGems.Weapon;
import weaponsAndGems.weapons.Sword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestGems {
    Weapon weapon;
    int originalDamage;

    @BeforeEach
    void setUpWeapon(){
        weapon = new Sword();
        originalDamage = weapon.getDamage(); //50
    }

    @Test
    public void bowWithWhiteGemMakes10MoreDamage(){
        Weapon wWithGem = new WhiteGem(weapon);
        assertEquals(originalDamage+10, wWithGem.getDamage());
        assertEquals("Sword, white gem", wWithGem.getName());
    }

    @Test
    public void bowWithTwoWhitesGemMakes20MoreDamage(){
        Weapon wWithGems = new WhiteGem(new WhiteGem(weapon));
        assertEquals(originalDamage+20, wWithGems.getDamage());
        assertEquals("Sword, white gem, white gem", wWithGems.getName());
    }

    @Test
    public void oneRedGemAndOneWhiteGem(){
        Weapon newWeapon = new RedGem(new WhiteGem(weapon));
        assertEquals(originalDamage+30, newWeapon.getDamage());
        assertEquals("Sword, white gem, red gem", newWeapon.getName());
    }

    @Test
    public void BowCantHaveMoreThanOneGem(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                weapon = new RedGem(new WhiteGem(new Bow())));
        assertEquals("Weapon cant have more than 1 gems.", exception.getMessage());
    }

}
