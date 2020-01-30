package courriers.content;

public class Money implements Content {

    protected float amount;

    public Money(int amout) {
        this.amount = amout;
    }

    public float getAmount() {
        return amount;
    }
}
