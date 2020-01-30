package plugin.listeners;

import plugin.file.FileEvent;

/**
 * A basic file listener for debugging.
 */
public class SimpleFileListener implements FileListener {

    /**
     * Init a new file listener.
     */
    public SimpleFileListener() {
    }

    @Override
    public void fileAdded(FileEvent event) {
        System.out.println(".class " + event.getFileName() + " added");
    }

    @Override
    public void fileRemoved(FileEvent event) {
        System.out.println(".class " + event.getFileName() + " removed");
    }
}
