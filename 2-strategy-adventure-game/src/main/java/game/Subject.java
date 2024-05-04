package game;
import characters.GameCharacter;
import output.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserversAttack(int damage, GameCharacter attacker, GameCharacter receiver);
    public void notifyObserversKill(GameCharacter killer, GameCharacter victim);
    public void notifyObserversWeapon(GameCharacter character);
}
