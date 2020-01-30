package coo.donjon.actions;

import coo.donjon.board.Room;
import coo.donjon.directions.Direction;
import coo.donjon.entities.Character;

/**
 * A player can look around him for informations about the current room (monsters, items, exit etc.)
 */
public class Look implements Action {

    @Override
    public boolean canPerform(Room roomToPerform) {
        return true;
    }

    @Override
    public void perform(Room roomToPerform, Character character) {
        System.out.println("Vous regardez autour de vous");
        if (roomToPerform.getMonsters().size() > 0)
            System.out.println("Attention il y a " + roomToPerform.getMonsters().size() + " Monstres !");

        if (roomToPerform.getItems().size() > 0)
            System.out.println("Il y a " + roomToPerform.getItems().size() + " objets dans la piece");

        if (roomToPerform.getDirections().size() > 0) {
            for (Direction dir : roomToPerform.getDirections()) {
                System.out.println("vous pouvez aller vers la salle " + dir.toString());
            }
        }
    }

    public String toString() {
        return "Regardez autour de vous";
    }
}
