package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-------------------------------------------------------------------

public class ControllerGabarit  {

    @FXML
    private VBox vbMenu;

    @FXML
    private AnchorPane apMenu;

    @FXML
    private ImageView btnQuit;

    @FXML
    private ImageView btnClose;

    @FXML
    private ImageView btnSettings;

    @FXML
    private ImageView btnHome;

    @FXML
    private AnchorPane apMenuPrincipal;

//-------------------------------------------------------------------
   
	@FXML 
    void pageHome(MouseEvent event) throws IOException {
    	VBox pane = FXMLLoader.load(getClass().getResource("/menu.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }
    
    @FXML 
    void pageSettings(MouseEvent event) throws IOException {
    	Parent part = FXMLLoader.load(getClass().getResource("/settings.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    void pageReduire(MouseEvent event) throws IOException {
    	Stage stage = (Stage) btnClose.getScene().getWindow(); 
    	stage.setIconified(true);
    }

@FXML 
	void pageFermer(MouseEvent event) throws IOException {
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
}

@FXML
public void initialize() throws IOException{
	VBox pane = FXMLLoader.load(getClass().getResource("/menu.fxml"));
	apMenuPrincipal.getChildren().setAll(pane);	
}

}
