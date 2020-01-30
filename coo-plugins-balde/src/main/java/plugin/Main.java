package plugin;

/**
 * The main class of the editor, that create a new editor and display it.
 */
public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor("repository");
        editor.start();
    }
}
