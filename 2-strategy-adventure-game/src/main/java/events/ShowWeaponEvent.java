package events;

import characters.GameCharacter;

public class ShowWeaponEvent implements GameEvent {
    GameCharacter character;
    public ShowWeaponEvent(GameCharacter character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        return character.getName() + " uses " + character.getWeapon().getName();
    }

    @Override
    public void perform() {

    }
}
