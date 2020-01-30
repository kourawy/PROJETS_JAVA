package coo.donjon.entities;

/**
 * Abstract class for a generic character in the game.
 */
public abstract class Character {

    private String name;
    private int lifePoints;
    private int coins;
    private int strength;

    /**
     * Construct a new character.
     *
     * @param name       the name of the character
     * @param lifePoints number of HP of a character
     * @param coins      number of gold coins of a character
     * @param strength   the capacity to fight of a character
     */
    Character(String name, int lifePoints, int coins, int strength) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.coins = coins;
        this.strength = strength;
    }

    /**
     * Getter for the name attribute.
     *
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name attribute.
     *
     * @param name the new name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the lifePoints attribute.
     *
     * @return the current number of Hp
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Setter for the lifePoints attribute.
     *
     * @param lifePoints the new lifePoints value
     */
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
     * Getter for the coins attribute.
     *
     * @return the current number of player's coins
     */
    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * Getter for the strength attribute.
     *
     * @return the current strength value
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Setter for the strength attribute.
     *
     * @param strength the new strength value
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Give all needed information from a character in a string.
     *
     * @return String whith all parameters in a human readable way
     */
    public String toString() {
        return "Character: \tname: " + this.name + "\tlife points: " + this.lifePoints;
    }

    /**
     * Method who manage the diying of the character.
     */
    public abstract boolean die();
}
