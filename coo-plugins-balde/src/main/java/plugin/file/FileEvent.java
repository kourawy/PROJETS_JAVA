package plugin.file;

import java.util.EventObject;

/**
 * The event for detect files moves.
 */
public class FileEvent extends EventObject {
    private String fileName;

    /**
     * Create a new file event.
     *
     * @param object   the object of the event
     * @param fileName the name of the file
     */
    public FileEvent(Object object, String fileName) {
        super(object);
        this.fileName = fileName;
    }

    /**
     * Get the name of the file.
     *
     * @return the filename
     */
    public String getFileName() {
        return this.fileName;
    }
}
