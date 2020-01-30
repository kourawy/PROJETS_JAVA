package plugin.logger;

import plugin.file.FileEvent;
import plugin.listeners.FileListener;

/**
 * A simple logger for detecting if a file was added or removed.
 */
public class PluginAddedLogger implements FileListener {

    /**
     * Init a new logger.
     */
    public PluginAddedLogger() {
    }

    @Override
    public void fileAdded(FileEvent event) {
        System.out.println("plugin " + event.getFileName() + " added");
    }

    @Override
    public void fileRemoved(FileEvent event) {
        System.out.println("plugin " + event.getFileName() + " removed");
    }
}
