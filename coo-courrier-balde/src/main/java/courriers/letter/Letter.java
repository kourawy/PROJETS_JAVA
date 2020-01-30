package courriers.letter;

import courriers.content.Content;
import courriers.inhabitant.Inhabitant;

public abstract class Letter<C extends Content> implements Content {

    protected Inhabitant sender;
    protected Inhabitant receiver;
    protected C content;

    public Letter(Inhabitant sender, Inhabitant receiver, C content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public abstract float getCost();

    public abstract void action();

    public Inhabitant getSender() {
        return sender;
    }

    public void setSender(Inhabitant sender) {
        this.sender = sender;
    }

    public Inhabitant getReceiver() {
        return receiver;
    }

    public C getContent() {
        return content;
    }

}
