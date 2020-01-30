package courriers;

import courriers.content.Text;
import courriers.inhabitant.Inhabitant;
import courriers.letter.SimpleLetter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InhabitantTest {

    private City cityTest;
    private Inhabitant hab, hab2;

    @Before
    public void initInhabitant() {
        cityTest = new City("CityTest");
        hab = new Inhabitant("Benjamin", cityTest);
        hab2 = new Inhabitant("Elodie", cityTest);
    }

    @Test
    public void sendSimpleLetter() {
        SimpleLetter letterTest = new SimpleLetter(hab, hab2, new Text("coucou"));
        hab.sendLetter(letterTest);

        assertEquals(hab.getAccount(), 100 - letterTest.getCost(), 0);
        assertTrue(cityTest.mailbox.contains(letterTest));
    }

    @Test
    public void credit() {
        assertEquals(100, hab.getAccount(), 0);
        hab.credit(5);
        assertEquals(105, hab.getAccount(), 0);
    }

    @Test
    public void debit() {
        hab.setAccount(10);
        hab.debit(5);
        assertEquals(5, hab.getAccount(), 0);
    }
}
