package coo.donjon.actions;

import coo.donjon.board.Room;
import coo.donjon.entities.Monster;
import coo.donjon.entities.Player;
import coo.donjon.items.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest {

    private Action action;
    private Player p1;
    private Monster thor;
    private Monster thor2;
    private Room piece;
    private Room piece1;
    private Item objet;
    private Item fum;

    @Before
    public void init() {
        this.action = new Move();
        this.p1 = new Player("balde", 3, 2, 2);
        this.thor = new Monster("thor", 1, 2, 2);
        this.thor2 = new Monster("thor2", 0, 2, 2);
        this.piece = new Room(true);
        this.piece1 = new Room(true);

        assertNotNull(this.action);
    }

    @Test
    public void testCanPerform() {


        assertTrue(this.action.canPerform(piece));
        assertTrue(this.action.canPerform(piece1));
        this.piece1.addMonster(thor);

        assertFalse(this.action.canPerform(piece1));

        this.piece.addItem(this.fum);
        assertTrue(this.action.canPerform(piece));

        this.piece.addMonster(thor);
        assertFalse(this.action.canPerform(piece));
    }

    @Test
    public void testPerform() {
        assertTrue(this.action.canPerform(piece1));
        this.piece1.addItem(this.objet);
        assertTrue(this.action.canPerform(piece1));

        this.piece.addMonster(thor);
        assertFalse(this.action.canPerform(piece));


    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(coo.donjon.actions.MoveTest.class);
    }


}










