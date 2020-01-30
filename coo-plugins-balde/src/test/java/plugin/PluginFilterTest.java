package plugin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import plugin.filters.PluginFilter;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;




public class PluginFilterTest {

    PluginFilter filter = new PluginFilter();
    File directory;
    File testfile;

    @Before
    public void initFilter() {
        directory = new File("tests/");
        directory.mkdirs();
    }

    @After
    public void removeFiles() {
        testfile.delete();
        directory.delete();
    }

    @Test
    public void acceptNotClassFileTest() throws IOException {
        testfile = new File(directory + "/test.txt");
        testfile.createNewFile();
        assertFalse(filter.accept(testfile, testfile.getName()));
    }
}
