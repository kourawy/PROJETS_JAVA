package courriers;

import courriers.content.Text;
import courriers.inhabitant.Inhabitant;
import courriers.letter.SimpleLetter;

public class main {
    public static void main(String[] args) {
        System.out.println("ca marche !");
        City city = new City("Lille");
        Inhabitant hab1 = new Inhabitant("benjamin", city);
        Inhabitant hab2 = new Inhabitant("elodie", city);
        SimpleLetter simpleLetter = new SimpleLetter(hab1, hab2, new Text("Coucou"));
        hab1.sendLetter(simpleLetter);

        city.distributeLetters();
    }
}
