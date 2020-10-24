package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.factory.DAOFactory;
import enumz.ModeDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ControllerGabarit  implements Initializable{

    @FXML
    private AnchorPane apMenu;

    @FXML
    private ImageView btnQuit;

    @FXML
    private ImageView btnClose;

    @FXML
    private ImageView btnSettings;

    @FXML
    private AnchorPane apContenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
   
            
    }

}