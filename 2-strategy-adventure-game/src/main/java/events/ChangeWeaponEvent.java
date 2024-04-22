package events;
import characters.GameCharacter;
import weapons.WeaponBehaviour;

public class ChangeWeaponEvent implements GameEvent{
    GameCharacter character;
    WeaponBehaviour weapon;

    public ChangeWeaponEvent(GameCharacter c, WeaponBehaviour w){
        character = c;
        weapon = w;
    }
    @Override
    public String getMessage() {
        return character.getName() + " is now using " + weapon.getName();
    }

    @Override
    public void perform() {
        character.setWeapon(weapon);
    }
}