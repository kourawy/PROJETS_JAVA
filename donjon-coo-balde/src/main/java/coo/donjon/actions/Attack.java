package coo.donjon.actions;

import coo.donjon.board.Room;
import coo.donjon.entities.Character;
import coo.donjon.entities.Monster;
import coo.donjon.utils.ListChooser;

/**
 * This class manage the fact that a player can attack some monsters.
 */
public class Attack implements Action {

    @Override
    public boolean canPerform(Room roomToPerform) {
        return roomToPerform.getMonsters().size() != 0;
    }

    @Override
    public void perform(Room roomToPerform, Character character) {
        ListChooser<Monster> monsterList = new ListChooser<>();
        Monster monster = monsterList.choose(roomToPerform.getMonsters());
        monster.setLifePoints(monster.getLifePoints() - character.getStrength());
        if (monster.die()) {
            character.setCoins(character.getCoins() + monster.getCoins());
            roomToPerform.getMonsters().remove(monster);
        }
    }

    public String toString() {
        return "Attaquer un monstre";
    }
}
