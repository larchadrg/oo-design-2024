package output;
import characters.GameCharacter;
import weaponsAndGems.Weapon;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameStatsManager implements Observer{
    private static class PairCharacterWeapon{
        public String character; // to increase efficiency
        public String weapon;
        public PairCharacterWeapon(GameCharacter character){
            this.character = character.name;
            this.weapon = character.weapon.getName();
        }
        public PairCharacterWeapon(String character, String weapon){
            this.character = character;
            this.weapon = weapon;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            PairCharacterWeapon other = (PairCharacterWeapon) obj;
            return Objects.equals(character, other.character) &&
                    Objects.equals(weapon, other.weapon);
        }
    }
    Map<PairCharacterWeapon, Integer> battlesWon;
    Map<PairCharacterWeapon, Integer> battlesPlayed;


    public GameStatsManager(){
        battlesPlayed = new HashMap<>();
        battlesWon = new HashMap<>();
    }

    @Override
    public void updateAttack(int damage, GameCharacter attacker, GameCharacter receiver) {
    }

    @Override
    public void updateKill(GameCharacter killer, GameCharacter victim) {
        PairCharacterWeapon killerPair = new PairCharacterWeapon(killer);
        PairCharacterWeapon victimPair = new PairCharacterWeapon(victim);
        Integer killerBattlesPlayed = battlesPlayed.getOrDefault(killerPair,0);
        Integer killerBattlesWon = battlesWon.getOrDefault(killerPair, 0);
        Integer victimBattlesPlayed = battlesWon.getOrDefault(victimPair, 0);

        battlesPlayed.put(killerPair, killerBattlesPlayed+1);
        battlesWon.put(killerPair,killerBattlesWon+1);
        battlesPlayed.put(victimPair,victimBattlesPlayed+1);
    }

    @Override
    public void updateWeapon(GameCharacter character) {
    }

    public double getWinPercentage(GameCharacter character, Weapon weapon){
        PairCharacterWeapon pair = new PairCharacterWeapon(character.name, weapon.getName());
        int characterBattlesPlayed = battlesPlayed.getOrDefault(pair,0);
        if(characterBattlesPlayed == 0) return 0;
        int characterBattlesWon = battlesWon.getOrDefault(pair, 0);
        return (double) characterBattlesWon / characterBattlesPlayed;
    }
}
