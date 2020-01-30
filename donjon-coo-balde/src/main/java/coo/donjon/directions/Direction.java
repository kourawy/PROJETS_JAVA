package coo.donjon.directions;

import java.util.ArrayList;

/**
 * An enum of the different directions.
 */
public enum Direction {

    NORTH("Nord"),
    SOUTH("Sud"),
    EAST("Est"),
    WEST("Ouest");

    private String direction;

    /**
     * Init a new direction.
     *
     * @param direction value of the direction
     */
    Direction(String direction) {
        this.direction = direction;
    }

    /**
     * Get list of all directions (use with ListChooser.
     *
     * @return a list all directions available
     */
    public static ArrayList<Direction> getDirectionList() {
        ArrayList<Direction> directionList = new ArrayList<>();
        directionList.add(NORTH);
        directionList.add(SOUTH);
        directionList.add(EAST);
        directionList.add(WEST);

        return directionList;
    }

    /**
     * Print the value of the direction.
     *
     * @return a string version of the direction
     */
    public String toString() {
        return this.direction;
    }
}
