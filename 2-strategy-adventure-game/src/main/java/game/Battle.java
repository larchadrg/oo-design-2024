package game;

import characters.GameCharacter;
import output.ScreenLogger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Battle {
    GameCharacter character1;
    GameCharacter character2;

    public Battle(GameCharacter character1, GameCharacter character2) {
        this.character1 = character1;
        this.character2 = character2;
    }

    public GameCharacter winner(){
        if(character1.isAlive() && character2.isAlive()) throw new IllegalStateException("both characters are alive");
        if(!character2.isAlive() && !character2.isAlive()) throw new IllegalStateException("both characters died");
        if (character1.isAlive()) return character1; else return character2;
    }

    private List<GameCharacter> getAttackOrder() {
        List<GameCharacter> gameCharacters = new ArrayList<>();
        gameCharacters.add(character1);
        gameCharacters.add(character2);
        gameCharacters.sort(new Comparator<GameCharacter>() {
            @Override
            public int compare(GameCharacter o1, GameCharacter o2) {
                return Math.min(o1.getSpeed(), o2.getSpeed());
            }
        });
        return gameCharacters;
    }

    private String getAttackMessage(GameCharacter attacker, GameCharacter receiver){
        return String.format("%s attacked %s and dealt %d damage.",
                attacker.getName(),
                receiver.getName(),
                attacker.calculateEffectiveDamageAgainst(receiver));

    }

    boolean bothAlive(GameCharacter c1, GameCharacter c2){
        return c1.isAlive() && c2.isAlive();
    }

    GameCharacter getFirstAttacker(GameCharacter character1, GameCharacter character2){
        return character1.getSpeed() >= character2.getSpeed() ? character1 : character2;
    }
    GameCharacter getSecondAttacker(GameCharacter character1, GameCharacter character2){
        return getFirstAttacker(character1, character2) == character1 ? character2 : character1;
    }
}
