package courriers.letter;

import courriers.inhabitant.Inhabitant;
import courriers.content.Money;

public class BillOfExchange extends Letter<Money> {

    public BillOfExchange(Inhabitant sender, Inhabitant receiver, Money content) {
        super(sender, receiver, content);
    }

    @Override
    public float getCost() {
        return content.getAmount() + (float) 1/100 * content.getAmount();
    }

    @Override
    public void action() {
        receiver.credit(content.getAmount());
    }
}
