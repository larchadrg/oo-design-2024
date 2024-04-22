package events;
import characters.GameCharacter;


public class AttackEventGame implements GameEvent{
    GameCharacter attacker;
    GameCharacter receiver;
    int damage;
    String message;

    public AttackEventGame(GameCharacter attacker, GameCharacter receiver){
        this.attacker = attacker;
        this.receiver = receiver;
        this.damage = attacker.calculateEffectiveDamageAgainst(receiver);
        this.message = constructEventMessage();
        perform();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void perform() {
        attacker.attack(receiver);
    }

    private String constructEventMessage(){
        return attacker.getName() + " attacked " + receiver.getName() + " and dealt " + damage + " points of damage!";
    }
}
