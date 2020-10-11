package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;

public class controller {

    @FXML
    private Menu quitter_btn;

    @FXML
    void quitterProgramme() {
    	
        // get a handle to the stage
    	Platform.exit();
    }

}
