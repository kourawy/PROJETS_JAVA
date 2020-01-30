package plugin.file;

import java.io.FilenameFilter;

public class MockFileChecker extends FileChecker{
    private int cpt ;

    public  MockFileChecker(String directory, FilenameFilter filter){
        super(directory , filter) ;
    }

    public void checkFiles(){
        cpt = 0;
        cpt ++;

    }

    public void fireFileAdded(String filename){
        cpt = 0;
        cpt ++;
    }

    public void fireFileRemoved(String filename){
        cpt = 0;
        cpt ++;
    }

    public int getCpt(){
        return this.cpt ;
    }


}
