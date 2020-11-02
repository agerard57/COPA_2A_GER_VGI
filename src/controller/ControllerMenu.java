package controller;

import java.io.IOException;

import dao.factory.DAOFactory;
import enumz.ModeDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerMenu
{

	
	
 //--------------------------ITEMS------------------------------	
	
	
	
    @FXML
    private AnchorPane apMenuPrincipal;
    
    
    @FXML
    private Label lblMenu;

    
    
 //--------------------------ACTIONS-----------------------------    
    
    
    
    @FXML
    public void initialize() throws IOException
    {
		if(ControllerSettings.getDaof() == null) 
		{
			ControllerSettings.setDaof(DAOFactory.getDAOFactory(ModeDAO.LISTE_MEMOIRE));
		}
    }

    
    
    @FXML
    void txtCategorie(MouseEvent event) {
    	lblMenu.setText("Gestion des categories");
    }

    
    
    @FXML
    void txtClient(MouseEvent event) {
    	lblMenu.setText("Gestion des clients");
    }

    
    
    @FXML
    void txtCommandes(MouseEvent event) {
    	lblMenu.setText("Gestion des commandes");
    }

    
    
    @FXML
    void txtProduit(MouseEvent event) {
    	lblMenu.setText("Gestion des produits");
    }
    
    
    
    @FXML
    void txtMenu(MouseEvent event) {
    	lblMenu.setText("Bienvenue dans la boutique des meilleurs pires pull !");
    }

    
    
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
