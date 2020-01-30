package coo.donjon.items;

import coo.donjon.entities.Character;

/**
 * A bag full of gold.
 */
public class GoldPurse extends Item {

    /**
     * Constructor for a gold purse.
     *
     * @param name the name of the item
     * @param description what the item doing
     */
    public GoldPurse(String name, String description) {
        super(name, description);
    }

    @Override
    public void use(Character characterUsing) {
        characterUsing.setCoins(characterUsing.getCoins() + 100);
    }
}
