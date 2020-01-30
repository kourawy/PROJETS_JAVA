package courriers.inhabitant;

public class Account {

    private float amount;

    public Account(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void debit(float debit) {
        amount -= debit;
    }
}
