package plugin.logger;

import plugin.file.FileChecker;
import plugin.filters.PluginFilter;
import plugin.listeners.FileListener;

import java.io.IOException;

/**
 * A main for testing the simple file listener.
 */
public class PluginAddedLoggerMain {

    /**
     * Create a new logger.
     */
    public PluginAddedLoggerMain() {
    }

    public static void main(String[] args) throws IOException {

        String current = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + current);
        FileChecker checker = new FileChecker("dropins", new PluginFilter());
        FileListener listener = new PluginAddedLogger();
        checker.addFileListener(listener);
        checker.start();
    }
}
