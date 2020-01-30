package plugin.filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 * A simple filter for select only the .class files.
 */
public class ClassFilenameFilter implements FilenameFilter {

    /**
     * Create a new filter.
     */
    public ClassFilenameFilter() {
    }

    /**
     * Define if a file are accepted or not.
     *
     * @param dir      the directory to search
     * @param fileName the name of the file to filter
     * @return true if file is accepted, false otherwise
     */
    public boolean accept(File dir, String fileName) {
        return fileName.endsWith(".class");
    }
}
