package events;
import characters.GameCharacter;


public class AttackEventGame implements GameEvent{
    GameCharacter attacker;
    GameCharacter receiver;
    int damage;

    public AttackEventGame(GameCharacter attacker, GameCharacter receiver){
        this.attacker = attacker;
        this.receiver = receiver;
        this.damage = attacker.calculateEffectiveDamageAgainst(receiver);
        perform();
    }

    @Override
    public String createEventMessage() {
        return attacker.getName() + " attacked " + receiver.getName() + " and dealt " + damage + " points of damage!";
    }

    @Override
    public void perform() {
        attacker.attack(receiver);
    }
}
