package plugin.listeners;

import plugin.file.FileEvent;

public class MockFileListener implements FileListener {
    private  int cpt ;

    public MockFileListener(){
        super();
    }

    /**
     * method calls when a file is added.
     *
     * @param event the event
     */
    public void fileAdded(FileEvent event){
        this.cpt = 0;
        this.cpt ++;
    }

    /**
     * method calls when a file is removed.
     *
     * @param event the event
     */
    public void fileRemoved(FileEvent event){
        this.cpt = 0;
        this.cpt ++;
    }

    public  int getcpt(){
        return this.cpt;
    }
}
