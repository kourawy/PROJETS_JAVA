package coo.donjon.entities;

import coo.donjon.actions.Action;
import coo.donjon.actions.Attack;
import coo.donjon.board.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {


    private Player p1;
    private Player thor;
    private Player thor2;
    private Room piece;
    private Room piece1;
    private Action action;

    @Before
    public void setUpBeforeClass() {
        this.action = new Attack();
        this.p1 = new Player("balde", 3, 2, 2);
        this.thor = new Player("thor", 1, 2, 2);
        this.thor2 = new Player("thor2", 0, 2, 2);
        this.piece = new Room(false);
        this.piece1 = new Room(false);
        assertNotNull(this.thor);
        assertNotNull(this.thor2);

    }


    @Test
    public void testDie() {
        assertFalse(this.p1.die());
        assertFalse(this.thor.die());
        //this.piece1.addMonster(thor);
        this.thor.setLifePoints(0);
        assertTrue(this.thor.die());
        //this.action.(piece1, p1);


    }


    @Test
    public void testGetName() {
        assertEquals("thor", this.thor.getName());
    }

    @Test
    public void testSetName() {
        assertEquals("thor", this.thor.getName());
        this.thor2.setName("Thanos");
        assertEquals("Thanos", this.thor2.getName());
    }

    @Test
    public void testGetLifePoints() {
        assertEquals(1, this.thor.getLifePoints());

        assertEquals(0, this.thor2.getLifePoints());
    }

    @Test
    public void testSetLifePoints() {
        this.thor2.setLifePoints(1);
        assertEquals(1, this.thor2.getLifePoints());
    }

    @Test
    public void testGetCoins() {
        assertEquals(2, this.thor.getCoins());
        assertEquals(2, this.thor2.getCoins());
    }

    @Test
    public void testSetCoins() {
        assertEquals(2, this.thor.getCoins());
        this.thor.setCoins(4);
        assertEquals(4, this.thor.getCoins());
    }

    @Test
    public void testGetStrength() {
        assertEquals(2, this.thor.getStrength());
        assertEquals(2, this.thor2.getStrength());
    }

    @Test
    public void testSetStrength() {
        assertEquals(2, this.thor.getStrength());
        this.thor.setStrength(4);
        assertEquals(4, this.thor.getStrength());
    }

}

