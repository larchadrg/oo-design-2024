package output;

import characters.GameCharacter;

public abstract class Logger implements Observer, Output{
    String message;
    @Override
    public void updateAttack(int damage, GameCharacter attacker, GameCharacter receiver) {
        message = attacker.getName() + " attacked " + receiver.getName()
                + " and dealt " + damage + " points of damage!";
        print(message);
    }

    @Override
    public void updateKill(GameCharacter killer, GameCharacter killed) {
        message = killer.getName() + " died.";
        print(message);
    }

    @Override
    public void updateWeapon(GameCharacter character) {
        message = character.name + " is now using " + character.weapon.getName();
        print(message);
    }
}
