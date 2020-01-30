package coo.donjon.utils;

import java.util.List;
import java.util.Scanner;

/**
 * Class allow user to pick an element in a list of any type object.
 *
 * @param <T> generic type of object
 */
public class ListChooser<T> {

    private Scanner scan;

    /**
     * Init the scanner use to get the choice.
     */
    public ListChooser() {
        this.scan = new Scanner(System.in);
    }

    /**
     * Method who print all the list and wait a choice from the keyboard.
     *
     * @param options the list in which we want choose an element
     * @return the element that user choose
     */
    public T choose(List<T> options) {
        for (T option : options) {
            System.out.println(option.toString() + " (" + options.indexOf(option) + ")");
        }
        int choice = scan.nextInt();
        if (options.contains(options.get(choice)))
            return options.get(choice);
        return null;
    }
}
