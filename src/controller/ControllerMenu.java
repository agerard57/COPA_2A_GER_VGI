package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ControllerMenu {

    @FXML
    private VBox vbMenu;

    @FXML
    private AnchorPane apMenuPrincipal;

    @FXML
    private BorderPane bpMenu;

    @FXML
    private Label lblMenu;

    @FXML
    private AnchorPane apCentre;

    @FXML
    private AnchorPane apClients;

    @FXML
    private ImageView imgCli;

    @FXML
    private Label lblCli;

    @FXML
    private AnchorPane apProduits;

    @FXML
    private ImageView imgProd;

    @FXML
    private Label lblProd;

    @FXML
    private AnchorPane apCommandes;

    @FXML
    private ImageView imgCom;

    @FXML
    private Label lblCom;

    @FXML
    private AnchorPane apCategories;

    @FXML
    private ImageView imgCat;

    @FXML
    private Label lblCat;

    @FXML
    void pageGestionCategories	(MouseEvent event) throws IOException {
    	VBox pane = FXMLLoader.load(getClass().getResource("/menu_categorie.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }

    @FXML
    void pageGestionProduits(MouseEvent event) throws IOException {
    	VBox pane = FXMLLoader.load(getClass().getResource("/menu_produit.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }
    
    @FXML
    void pageGestionCommandes(MouseEvent event) throws IOException {
    	VBox pane = FXMLLoader.load(getClass().getResource("/menu_commande.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }
    
    @FXML
    void pageGestionClients(MouseEvent event) throws IOException {
    	VBox pane = FXMLLoader.load(getClass().getResource("/menu_client.fxml"));
    	apMenuPrincipal.getChildren().setAll(pane);
    }

}
