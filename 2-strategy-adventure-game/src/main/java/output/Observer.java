package output;

import characters.GameCharacter;

public interface Observer {
    void updateAttack(int damage, GameCharacter attacker, GameCharacter receiver);
    void updateKill(GameCharacter killer, GameCharacter killed);
    void updateWeapon(GameCharacter character);
}
