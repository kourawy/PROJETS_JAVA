package coo.donjon;

import coo.donjon.actions.Action;
import coo.donjon.board.Dungeon;
import coo.donjon.board.Room;
import coo.donjon.directions.Direction;
import coo.donjon.entities.Monster;
import coo.donjon.entities.Player;
import coo.donjon.items.HealPotion;
import coo.donjon.items.Item;
import coo.donjon.utils.ListChooser;

/**
 * The main class of the game with method play who manage the game.
 */
public class AdventureGame {

    private Room currentRoom;
    private Player player;

    /**
     * Get the player of the game.
     *
     * @return the actual player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter for the player of the game.
     *
     * @param player the new value of player attribute
     */
    void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Create a new game and init the current room to the first room of the dungeon.
     *
     * @param dungeon the game board
     */
    AdventureGame(Dungeon dungeon) {
        this.currentRoom = dungeon.getRoom(0);
    }

    /**
     * Get the room where the player is.
     *
     * @return the actual current room
     */
    public Room currentRoom() {
        return this.currentRoom;
    }

    /**
     * Main method of the game, contains the logic of the game.
     *
     * @param player the player of the game
     */
    private void play(Player player) {
        System.out.println("Bienvenue au jeu du donjon !");

        ListChooser<Action> choixAction = new ListChooser<>();

        // main loop of the game
        while (!isFinished()) {
            System.out.println("\n" + player.toString() + "\n");
            System.out.println("\nQue voulez vous faire ?");
            Action action = choixAction.choose(Action.getActionsList());

            if (action.canPerform(currentRoom)) {
                action.perform(currentRoom, player);
            } else {
                System.out.println("Vous ne pouvez pas effectuer cette action.");
            }
        }
    }

    /**
     * Add a new monster in a selected room.
     *
     * @param monstre the monster to add
     * @param room    the room to add the monster
     */
    private void addMonster(Monster monstre, Room room) {
        room.addMonster(monstre);
    }

    /**
     * Add a new item in a selected room.
     *
     * @param item the item to add
     * @param room the room to add the item
     */
    private void addItem(Item item, Room room) {
        room.addItem(item);
    }

    /**
     * Say if the game is finish, if player is died or if player is in an exit of the dungeon.
     *
     * @return true if the game is finish, false otherwise
     */
    private boolean isFinished() {
        if (player.die()) {
            System.out.println("Vous etes mort !");
            return true;
        }

        if (currentRoom.getMonsters().size() == 0 && currentRoom.isExit()) {
            System.out.println("Bravo vous avez gagné !");
            return true;
        }
        return false;
    }

    /**
     * A little main method to test the game with a simple dungeon.
     *
     * @param args arguments from the command line
     */
    public static void main(String[] args) {
        Room start = new Room(false);
        Room end = new Room(true);
        start.setDirection(Direction.NORTH);
        end.setDirection(Direction.SOUTH);
        Dungeon dungeon = Dungeon.getDungeon();
        dungeon.addRoom(start);
        dungeon.addRoom(end);
        AdventureGame game = new AdventureGame(dungeon);
        Player benjamin = new Player("Benjamin", 100, 20, 30);
        game.addItem(new HealPotion("potion soin", "rends 50 pv"), start);
        game.addMonster(new Monster("zombie", 50, 50, 20), start);

        game.setPlayer(benjamin);
        game.play(benjamin);
    }
}