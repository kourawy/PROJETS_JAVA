package coo.donjon.board;

import coo.donjon.actions.Action;
import coo.donjon.actions.Attack;
import coo.donjon.entities.Monster;
import coo.donjon.entities.Player;
import coo.donjon.items.HealPotion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {

    private Player p1;
    private Monster thor;
    private Player thor2;
    private Room piece;
    private Room piece1;
    private Action action;
    private HealPotion potion;

    @Before
    public void init() {
        this.action = new Attack();
        this.p1 = new Player("balde", 3, 2, 2);
        this.thor = new Monster("thor", 1, 2, 2);
        this.thor2 = new Player("thor2", 0, 2, 2);
        this.piece = new Room(false);
        this.piece1 = new Room(true);
        this.potion = new HealPotion("potion", "energy");
        assertNotNull(this.piece);
        assertNotNull(this.piece1);

    }


    @Test
    public void testAddMonster() {
        assertTrue(this.piece1.getMonsters().isEmpty());
        this.piece1.addMonster(thor);
        assertFalse(this.piece1.getMonsters().isEmpty());

    }

    @Test
    public void testAddItem() {
        assertTrue(this.piece1.getItems().isEmpty());
        this.piece1.addItem(potion);
        assertFalse(this.piece1.getItems().isEmpty());

    }

    @Test
    public void testGetMonsters() {
        assertTrue(this.piece1.getMonsters().isEmpty());
        this.piece1.addMonster(thor);
        assertFalse(this.piece1.getMonsters().isEmpty());
    }

    @Test
    public void testGetItems() {
        assertTrue(this.piece1.getItems().isEmpty());
        this.piece1.addItem(potion);
        assertFalse(this.piece1.getItems().isEmpty());
    }

    @Test
    public void testIsExit() {
        assertTrue(this.piece1.isExit());
        assertFalse(this.piece.isExit());
    }


}
