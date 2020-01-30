package courriers.letter;

import courriers.inhabitant.Inhabitant;
import courriers.content.Text;

public class SimpleLetter extends Letter {

    public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text text) {
        super(sender, receiver, text);
    }

    @Override
    public float getCost() {
        return (float) 0.5;
    }

    @Override
    public void action() {

    }
}
