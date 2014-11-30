package com;

/**
 * Created by Daniel on 11/30/2014.
 */
public class SelectedPlayer {

    private String selectedPlayerFileName;

    public SelectedPlayer (String selectedPlayerFileName){
        this.selectedPlayerFileName = selectedPlayerFileName;
    }

    public String getSelectedPlayerFileName() {
        return selectedPlayerFileName;
    }

    public void setSelectedPlayerFileName(String selectedPlayerFileName) {
        this.selectedPlayerFileName = selectedPlayerFileName;
    }
}
