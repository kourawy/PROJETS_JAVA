package coo.donjon.actions;

import coo.donjon.board.Room;
import coo.donjon.entities.Character;
import coo.donjon.items.Item;
import coo.donjon.utils.ListChooser;

/**
 * Class who manage the action to pick up an item in a room.
 */
public class GetItem implements Action {

    @Override
    public boolean canPerform(Room roomToPerform) {
        return roomToPerform.getItems().size() > 0;
    }

    @Override
    public void perform(Room roomToPerform, Character character) {
        ListChooser<Item> itemList = new ListChooser<>();
        Item item = itemList.choose(roomToPerform.getItems());
        item.use(character);
        roomToPerform.getItems().remove(item);
    }

    public String toString() {
        return "Ramasser un objet";
    }
}
