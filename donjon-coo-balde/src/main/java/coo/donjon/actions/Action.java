package coo.donjon.actions;

import coo.donjon.board.Room;
import coo.donjon.entities.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface that provide a model for all actions a player can perform.
 */
public interface Action {

    /**
     * Check if action can be perform.
     *
     * @param roomToPerform the room where action will be perform.
     * @return true if action can be perform, false otherwise.
     */
    boolean canPerform(Room roomToPerform);

    /**
     * Perform action.
     *
     * @param roomToPerform the room where action will be perform.
     * @param character     the character will be performing the action.
     */
    void perform(Room roomToPerform, Character character);

    /**
     * Describe action whith a string.
     *
     * @return a string that describe action.
     */
    String toString();

    /**
     * Get a list of all actions available.
     *
     * @return an arrayList that contains all actions available.
     */
    static List<Action> getActionsList() {
        List<Action> actionsList = new ArrayList<>();
        actionsList.add(new Look());
        actionsList.add(new Move());
        actionsList.add(new GetItem());
        actionsList.add(new Attack());


        return actionsList;
    }
}
