package plugin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import plugin.file.MockFileChecker;
import plugin.filters.ClassFilenameFilter;
import plugin.filters.PluginFilter;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FileCheckerTest {

    @Before
    public void init(){
        PluginFilter filter = new PluginFilter();
        File directory;
        File filetest;
        directory = new File("tests/");
        directory.mkdirs();

        filetest = new File(directory + "/test.txt");
    }

    @Test
    public  void testCheckFile(){
        MockFileChecker m1 = new MockFileChecker("repository", new ClassFilenameFilter());
        m1.checkFiles();
        assertEquals(1 , m1.getCpt());
    }

    @Test
    public  void testfireFileAdded(){
        MockFileChecker m1 = new MockFileChecker("repository", new ClassFilenameFilter());
        m1.fireFileAdded("ibrahima");
        assertEquals(1 , m1.getCpt());
    }


    @Test
    public  void testfireFileRemoved(){
        MockFileChecker m1 = new MockFileChecker("repository", new ClassFilenameFilter());
        m1.fireFileRemoved("ibrahima");
        assertEquals(1 , m1.getCpt());
    }

}
