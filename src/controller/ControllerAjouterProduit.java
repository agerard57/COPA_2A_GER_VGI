package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import categorie.Categorie;
import dao.factory.DAOFactory;
import enumz.ModeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import produits.Produit;
import javafx.collections.FXCollections;



public class ControllerAjouterProduit implements Initializable{

    @FXML
    private VBox vbAddProduit;

    @FXML
    private GridPane gpSaisieProduit;

    @FXML
    private Label lblNom;

    @FXML
    private TextField tfNom;

    @FXML
    private Label lblDesc;

    @FXML
    private Label lblTarif;

    @FXML
    private Label lblCat;

    @FXML
    private TextArea taDesc;

    @FXML
    private TextField tfTarif;

    @FXML
    private Label lblEuros;

    @FXML
    private ChoiceBox<Categorie> cbCat;

    @FXML
    private FlowPane fpCreer;

    @FXML
    private GridPane gpBtn;

    @FXML
    private Button btnAnnuler;

    @FXML
    private Button btnCreer;

    @FXML
    private FlowPane fpAfficher;

    @FXML
    private Separator sep_afficher;

    @FXML
    private Label lblAfficher;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            DAOFactory dao = DAOFactory.getDAOFactory(ModeDAO.LISTE_MEMOIRE);
            this.cbCat.setItems(FXCollections.observableArrayList(dao.getCategorieDAO().findAll()));
            
    }
    
    @FXML
    void creerModele(ActionEvent event) {
    	Produit produit = new Produit();
    	String nom = this.tfNom.getText();
    	String description = this.taDesc.getText();
    	float tarif = Float.parseFloat(this.tfTarif.getText());
    	Categorie categorie = this.cbCat.getValue();
    	
    	produit.setNom(nom);
    	produit.setDescription(description);
    	produit.setTarif(tarif);
    	produit.setIdCategorie(categorie.getIdCategorie());
    	
    	this.lblAfficher.setText(produit.toString());
    	
    	JOptionPane.showMessageDialog(null, "Traitement réussi");
    }

    @FXML
    void fermerPage(ActionEvent event) {

    }

}