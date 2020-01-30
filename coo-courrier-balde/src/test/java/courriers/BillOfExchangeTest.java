package courriers;

import courriers.content.Money;
import courriers.inhabitant.Inhabitant;
import courriers.letter.BillOfExchange;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BillOfExchangeTest {

    private City cityTest;
    private Inhabitant hab, hab2;
    private BillOfExchange bill;

    @Before
    public void initBillOfExchange() {
        cityTest = new City("CityTest");
        hab = new Inhabitant("Benjamin", cityTest);
        hab2 = new Inhabitant("Elodie", cityTest);
        bill = new BillOfExchange(hab, hab2, new Money(100));
        hab.sendLetter(bill);
    }

    @Test
    public void getCost() {
        assertEquals(101, bill.getCost(), 0);
    }

    @Test
    public void action() {
        cityTest.distributeLetters();
        assertEquals(200, hab2.getAccount(), 0);
    }

    @Test
    public void costWillDebitFromSenderAccount() {
        cityTest.distributeLetters();
        assertEquals(-1, hab.getAccount(), 0);
    }
}
