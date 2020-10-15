package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerMenuProduit {

    @FXML
    private Menu quitter_btn;

    @FXML
    private Label lbl_gestion_produit;

    @FXML
    private ImageView btn_ajouter_produit;

    @FXML
    void pageAjoutProduit(MouseEvent event) throws IOException {
    	Parent part = FXMLLoader.load(getClass().getResource("/ajouter_produit.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void quitterProgramme(ActionEvent event) {

    }

}
