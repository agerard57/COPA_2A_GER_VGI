package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import dao.factory.DAOFactory;
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
import javafx.collections.FXCollections;


public class ControllerAjouterProduit {

    @FXML
    private VBox vb_add_produit;

    @FXML
    private GridPane gp_saisie_produit;

    @FXML
    private Label lbl_nom;

    @FXML
    private TextField tf_nom;

    @FXML
    private Label lbl_desc;

    @FXML
    private Label lbl_tarif;

    @FXML
    private Label lbl_cat;

    @FXML
    private TextArea ta_desc;

    @FXML
    private TextField tf_tarif;

    @FXML
    private Label lbl_euros;

    @FXML
    private ChoiceBox<?> cb_cat;

    @FXML
    private FlowPane fp_creer;

    @FXML
    private GridPane gp_btn;

    @FXML
    private Button btn_annuler;

    @FXML
    private Button btn_creer;

    @FXML
    private FlowPane fp_afficher;

    @FXML
    private Separator sep_afficher;

    @FXML
    private Label lbl_afficher;

    @FXML
    void ajouter_ajout(ActionEvent event) {
    	
JOptionPane.showMessageDialog(null, "Traitement réussi");
    }


    
    @FXML
    void annuler_ajout(ActionEvent event) {

    }
    
    public void initialize(URL location, ResourceBundle resources) {

    	//TODO Faire fonctionner cette carabistouille, MAJ readme + git 
    	
        DAOFactory dao = DAOFactory.getDAOFactory(dao.factory.ListeMemoireDAOFactory);
        this.cb_cat.setItems(FXCollections.observableArrayList(dao.getCategorieDAO().findAll()));
    }
}