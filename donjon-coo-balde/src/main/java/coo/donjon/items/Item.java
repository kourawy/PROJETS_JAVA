package coo.donjon.items;

import coo.donjon.entities.Character;

/**
 * Abstract class for a generic item in the game.
 */
public abstract class Item {

    private String name;
    private String description;

    /**
     * Constructor for an item.
     *
     * @param name        the name of the item
     * @param description what the item doing
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Getter for the name attribute
     *
     * @return the name of the current item
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name attribute.
     *
     * @param name the new value of the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the description attribute.
     *
     * @return the current description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the description attribute.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The main method, apply the effect an destroy item.
     *
     * @param characterUsing character using item
     */
    public abstract void use(Character characterUsing);

    /**
     * get an human-readable description of the item.
     *
     * @return a string who show name and item description
     */
    public String toString() {
        return "Item: \tname: " + this.name + "\n\tdescription: " + this.description;
    }
}
