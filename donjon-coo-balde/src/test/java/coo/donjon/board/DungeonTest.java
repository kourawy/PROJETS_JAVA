package coo.donjon.board;

import coo.donjon.actions.Action;
import coo.donjon.actions.Attack;
import coo.donjon.entities.Monster;
import coo.donjon.entities.Player;
import coo.donjon.items.HealPotion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DungeonTest {

    private Player p1;
    private Monster thor;
    private Player thor2;
    private Dungeon dojo;
    private Room piece1;
    private Action action;
    private HealPotion potion;

    @Before
    public void init() {
        this.action = new Attack();
        this.p1 = new Player("balde", 3, 2, 2);
        this.thor = new Monster("thor", 1, 2, 2);
        this.thor2 = new Player("thor2", 0, 2, 2);
        this.dojo = Dungeon.getDungeon();
        this.piece1 = new Room(true);
        this.potion = new HealPotion("potion", "energy");
        assertNotNull(this.dojo);


    }

    @Test
    public void testGetDungeon() {
        this.dojo.addRoom(this.piece1);
        assertNotNull(Dungeon.getDungeon());
    }

    @Test
    public void testAddRoom() {
        this.dojo.addRoom(this.piece1);
        assertNotNull(Dungeon.getDungeon());
    }

}
