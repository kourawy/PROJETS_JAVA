package coo.donjon.entities;

/**
 * Class who describe the player of the game.
 */
public class Player extends Character {

    /**
     * Construct new player
     *
     * @param name       the name of the monster
     * @param lifePoints the number of heart points of a monster
     * @param coins      number of gold than the monsters drop when he died
     * @param strength   the damage a monster can be made
     */
    public Player(String name, int lifePoints, int coins, int strength) {
        super(name, lifePoints, coins, strength);
    }

    @Override
    public boolean die() {
        return this.getLifePoints() <= 0;
    }

    @Override
    public String toString() {
        return "Player: \tname: " + this.getName() + "\tlife points: " + this.getLifePoints();
    }
}
