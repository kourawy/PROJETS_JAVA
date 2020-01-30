package courriers;

import courriers.inhabitant.Inhabitant;
import courriers.letter.Letter;

import java.util.ArrayList;
import java.util.List;

public class City {

    protected String name;
    protected List<Inhabitant> inhabitants;
    protected List<Letter<?>> mailbox;

    public City(String name) {
        this.name = name;
        inhabitants = new ArrayList<>();
        mailbox = new ArrayList<>();
    }

    public void addLetter(Letter letter) {
        mailbox.add(letter);
    }

    public void distributeLetters() {
        List<Letter<?>> mailbag = new ArrayList<Letter<?>>(mailbox);
        for (Letter<?> letter : mailbag) {
            letter.getReceiver().receiveLetter(letter);
            mailbox.remove(letter);
        }
    }
}
