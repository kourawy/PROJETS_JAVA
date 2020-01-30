package coo.donjon.board;

import coo.donjon.directions.Direction;
import coo.donjon.entities.Monster;
import coo.donjon.items.Item;

import java.util.ArrayList;

/**
 * A class who represent a room of the game.
 */
public class Room {

    private ArrayList<Monster> monsters;
    private ArrayList<Item> items;
    private boolean isExit;
    private ArrayList<Direction> directions;

    /**
     * Create a new room, init attributes.
     *
     * @param isExit if the room is an exit of the game
     */
    public Room(boolean isExit) {
        this.monsters = new ArrayList<>();
        this.items = new ArrayList<>();
        this.directions = new ArrayList<>();
        this.isExit = isExit;
    }

    /**
     * Add a monster in the room.
     *
     * @param monster the monster to add
     */
    public void addMonster(Monster monster) {
        this.monsters.add(monster);
    }

    /**
     * Add an item to the room.
     *
     * @param item the item to add
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Get the list of the monsters in the room.
     *
     * @return the list of monsters alive in the room
     */
    public ArrayList<Monster> getMonsters() {
        return this.monsters;
    }

    /**
     * Get the list of the items in the room.
     *
     * @return the list of items in the room
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    /**
     * Show if the room had an escape of the dungeon.
     *
     * @return true is the room is an exit, false otherwise
     */
    public boolean isExit() {
        return this.isExit;
    }

    /**
     * Get the directions the player can move from this room.
     *
     * @return the list of directions
     */
    public ArrayList<Direction> getDirections() {
        return this.directions;
    }

    /**
     * Set the direction of the room.
     *
     * @param direction the direction to add to the room
     */
    public void setDirection(Direction direction) {
        this.directions.add(direction);
    }
}
