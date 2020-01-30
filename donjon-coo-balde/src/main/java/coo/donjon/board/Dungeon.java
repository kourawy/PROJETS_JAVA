package coo.donjon.board;

import java.util.LinkedList;

/**
 * A class for manage the dungeon, bassicaly a list of rooms.
 */
public class Dungeon {

    // the only instance of the game
    private static final Dungeon instance = new Dungeon();

    private LinkedList<Room> rooms;

    /**
     * Construct a new dungeon.
     */
    private Dungeon() {
        this.rooms = new LinkedList<>();
    }

    /**
     * Dungeon is a singleton, one dungeon per game
     *
     * @return the instance of the dungeon
     */
    public static Dungeon getDungeon() {
        return instance;
    }

    /**
     * Get one room by index.
     *
     * @param i the index of the room to return
     * @return the room at the index
     */
    public Room getRoom(int i) {
        return rooms.get(i);
    }

    /**
     * Add a new room in the dungeon.
     *
     * @param roomToAdd the room to add in the list
     */
    public void addRoom(Room roomToAdd) {
        this.rooms.add(roomToAdd);
    }

}
