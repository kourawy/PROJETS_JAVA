package coo.donjon;

import coo.donjon.board.Dungeon;
import coo.donjon.board.Room;
import coo.donjon.entities.Monster;
import coo.donjon.entities.Player;
import coo.donjon.items.HealPotion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class AdventureGameTest {

    private Player p1;
    private Monster thor;
    private Player thor2;
    private Room piece;
    private Room piece1;
    private AdventureGame game;
    private HealPotion potion;
    private Dungeon dojo = Dungeon.getDungeon();

    @Before
    public void init() {
        this.dojo.addRoom(this.piece1);
        this.dojo.addRoom(this.piece);

        this.p1 = new Player("balde", 3, 2, 2);

        this.thor = new Monster("thor", 1, 2, 2);
        this.thor2 = new Player("thor2", 0, 2, 2);
        this.piece = new Room(false);
        this.piece1 = new Room(true);
        this.potion = new HealPotion("potion", "energy");
        this.game = new AdventureGame(this.dojo);
        this.game.setPlayer(this.p1);
        assertNotNull(this.game);


    }

    @Test
    public void testGetPlayer() {
        assertEquals(this.p1, this.game.getPlayer());

    }

    @Test
    public void testSetPlayer() {
        assertEquals(this.p1, this.game.getPlayer());
        this.game.setPlayer(this.thor2);
        assertEquals(this.thor2, this.game.getPlayer());
    }


}
