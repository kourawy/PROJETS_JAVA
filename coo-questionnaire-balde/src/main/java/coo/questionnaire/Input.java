package coo.questionnaire;

import java.io.IOException;
import java.util.Scanner;

/**
 * A class to read the user input in CLI mode.
 */
public class Input {

    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    /**
     * Create a new input class.
     */
    public Input() {
    }

    /**
     * Read a string from the command line.
     *
     * @return the string that was read
     * @throws IOException throws if some input/output problems was raised
     */
    public static String readString() throws IOException {
        return scanner.next();
    }

    /**
     * Read a string line from the command line.
     *
     * @return the line that was read
     * @throws IOException throws if some input/output problems was raised
     */
    public static String readLine() throws IOException {
        return scanner.nextLine();
    }

    /**
     * Read an int from the command line.
     *
     * @return the integer that was read
     * @throws IOException throws if some input/output problems was raised
     */
    public static int readInt() throws IOException {
        return scanner.nextInt();
    }
}
