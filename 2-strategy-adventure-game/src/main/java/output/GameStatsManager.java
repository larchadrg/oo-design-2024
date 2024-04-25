package output;

import characters.GameCharacter;
import weapons.WeaponBehaviour;

import java.util.Map;

public class GameStats implements Observer, Output{
    GameCharacter attacker;
    GameCharacter receiver;
    //TODO: PENSAR EN UN METODO PARA GUARDAR LAS ESTADISTICAS DE TODOS LOS PERSONAJES
    //MAP DE <JUGADOR,ARMA> -> <% VICTORIAS> ?
    Map<Character, WeaponBehaviour> map;

    @Override
    public void print(String content) {
    }

    @Override
    public void updateAttack(int damage, GameCharacter attacker, GameCharacter receiver) {
        this.attacker = attacker;
        this.receiver = receiver;
    }

    @Override
    public void updateDeath(GameCharacter character) {
        //last attacker wins
    }

    @Override
    public void updateWeapon(GameCharacter character) {
    }
}
