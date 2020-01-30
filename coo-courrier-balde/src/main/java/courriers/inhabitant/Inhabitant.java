package courriers.inhabitant;

import courriers.City;
import courriers.letter.Letter;

public class Inhabitant {

    protected String name;
    protected City city;
    protected Account account;

    public Inhabitant(String name, City city) {
        this.name = name;
        this.city = city;
        this.account = new Account(100);
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public float getAccount() {
        return account.getAmount();
    }

    public void setAccount(float account) {
        this.account.setAmount(account);
    }

    public void sendLetter(Letter<?> letter) {
        account.debit(letter.getCost());
        getCity().addLetter(letter);
    }

    public void receiveLetter(Letter<?> letter) {
        letter.action();
    }

    public void credit(float credit) {
        this.setAccount(this.getAccount() + credit);
    }

    public void debit(float debit) {
        this.setAccount(this.getAccount() - debit);
    }
}