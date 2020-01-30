package plugin.listeners;

import plugin.file.FileEvent;

import java.util.EventListener;

/**
 * The interface for define a listener for detect if a file was added or removed.
 */
public interface FileListener extends EventListener {

    /**
     * method calls when a file is added.
     *
     * @param event the event
     */
    void fileAdded(FileEvent event);

    /**
     * method calls when a file is removed.
     *
     * @param event the event
     */
    void fileRemoved(FileEvent event);
}
