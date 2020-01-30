package plugin.file;

import plugin.listeners.FileListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The class who search regulary for a plugin file.
 */
public class FileChecker {

    private static final int DEFAULT_PERIOD = 1000;
    private Timer timer;
    private FilenameFilter filter;
    private List<String> knownFileNames;
    private File dir;
    private int period;
    private ArrayList<FileListener> fileListeners;

    /**
     * Init a new checker.
     *
     * @param directory the directory to search
     * @param filter    the filter to use
     */
    public FileChecker(String directory, FilenameFilter filter) {
        this.filter = filter;
        this.period = 1000;
        this.timer = new Timer(this.period, new FileChecker.FileActionListener());
        this.knownFileNames = new ArrayList<>();
        this.dir = new File(directory);
        this.fileListeners = new ArrayList<>();
    }

    /**
     * Check for the files in the directory and call the right method fire.
     */
    private void checkFiles() {
        ArrayList<String> fileToProcess = new ArrayList<>(this.knownFileNames);
        String[] fileList = Objects.requireNonNull(this.dir.list(this.filter)).clone();

        for (String file : fileList) {
            if (!this.knownFileNames.contains(file)) {
                this.fireFileAdded(file);
                this.knownFileNames.add(file);
            } else {
                fileToProcess.remove(file);
            }
        }

        for (String file : fileToProcess) {
            this.fireFileRemoved(file);
            this.knownFileNames.remove(file);
        }
    }

    /**
     * Add a new listener that calls by the checker.
     *
     * @param listener the new listener to add
     */
    public synchronized void addFileListener(FileListener listener) {
        if (!this.fileListeners.contains(listener)) {
            this.fileListeners.add(listener);
        }
    }

    /**
     * Delete a listener in the checker's list
     *
     * @param listener the listener to remove
     */
    public synchronized void removeFileListener(FileListener listener) {
        this.fileListeners.remove(listener);
    }

    /**
     * Start the timer.
     */
    public void start() {
        this.timer.start();
    }

    private void fireFileAdded(String filename) {
        ArrayList fileList = (ArrayList) this.fileListeners.clone();
        if (fileList.size() != 0) {
            FileEvent event = new FileEvent(this, filename);

            for (Object o : fileList) {
                FileListener listener = (FileListener) o;
                listener.fileAdded(event);
            }
        }
    }

    private void fireFileRemoved(String filename) {
        ArrayList fileList = (ArrayList) this.fileListeners.clone();

        if (fileList.size() != 0) {
            FileEvent event = new FileEvent(this, filename);

            for (Object o : fileList) {
                FileListener listener = (FileListener) o;
                listener.fileRemoved(event);
            }
        }
    }

    /**
     * Set a new velue for the period of the timer.
     *
     * @param period the new period
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    private class FileActionListener implements ActionListener {
        private FileActionListener() {

        }

        public final   FileActionListener getInstance( ){
            return new FileActionListener();
        }

        public void actionPerformed(ActionEvent var1) {
            FileChecker.this.checkFiles();
        }
    }
}
