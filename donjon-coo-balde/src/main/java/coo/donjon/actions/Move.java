package coo.donjon.actions;

import coo.donjon.board.Room;
import coo.donjon.directions.Direction;
import coo.donjon.entities.Character;
import coo.donjon.utils.ListChooser;

/**
 * A class to manage player's move in the dungeon.
 */
public class Move implements Action {

    @Override
    public boolean canPerform(Room roomToPerform) {
        return roomToPerform.getMonsters().size() == 0;
    }

    @Override
    public void perform(Room roomToPerform, Character character) {
        ListChooser<Direction> directionChooser = new ListChooser<>();
        Direction direction = directionChooser.choose(Direction.getDirectionList());
    }

    @Override
    public String toString() {
        return "Vous déplacez vers une autre piece";
    }
}
