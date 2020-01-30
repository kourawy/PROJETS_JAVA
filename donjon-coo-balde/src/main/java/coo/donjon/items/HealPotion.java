package coo.donjon.items;

import coo.donjon.entities.Character;

/**
 * A potion for restore player's life.
 */
public class HealPotion extends Item {

    /**
     * Constructor for a potion.
     *
     * @param name the name of the item
     * @param description describe item effect
     */
    public HealPotion(String name, String description) {
        super(name, description);
    }

    /**
     * Restore 50 life points to the player.
     *
     * @param characterUsing character using item
     */
    @Override
    public void use(Character characterUsing) {
        characterUsing.setLifePoints(characterUsing.getLifePoints() + 50);
    }

}
