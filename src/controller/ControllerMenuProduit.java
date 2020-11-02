package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import dao.factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import produits.Produit;
import vue.VueAjouterProduit;

public class ControllerMenuProduit
{

	
	
 //-----------------------DECLARATION--------------------------

	
	
	private DAOFactory daof;
	
	
	
 //--------------------------ITEMS------------------------------
	
	
	
    @FXML
    private Label lblNom;
    @FXML
    private Label lblIdCat;
    @FXML
    private Label lblTarif;
    @FXML
    private Label lblFoisCommande;
    @FXML
    private Label lblVisu;
	@FXML
	private Label lblGestionProduits;

    
    @FXML
    private TextArea taDesc;
    
    
	@FXML
	private ImageView btnSuppr;
	@FXML
	private ImageView btnEdit;

	
	@FXML
	private TextField tfRech;


	@FXML
	private ImageView imgVisu;


    @FXML
    private TableView<Produit> tvPro;
    
    
    @FXML
    private TableColumn<Produit, String> tcNom;
    @FXML
    private TableColumn<Produit, Integer> tcIdCategorie;
    @FXML
    private TableColumn<Produit, Float> tcTarif;

    
    
    //--------------------------ACTIONS-----------------------------
    

    
	@FXML
    @SuppressWarnings("unchecked")
    public void initialize() throws IOException 
    {
    	daof = ControllerSettings.getDaof();
    	

        this.tcNom.setCellValueFactory(new PropertyValueFactory<Produit, String>("Nom"));
        this.tcIdCategorie.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("idCategorie"));
        this.tcTarif.setCellValueFactory(new PropertyValueFactory<Produit, Float>("Tarif"));

        this.tvPro.getColumns().setAll(tcNom,tcIdCategorie,tcTarif);
        this.tvPro.getItems().setAll(daof.getProduitDAO().findAll());     
    }
    
	
	
    @FXML
    void txtAjouter(MouseEvent event)
    {
    	lblGestionProduits.setText("Ajouter un produit");
        lblGestionProduits.setStyle("-fx-font-weight: bold;");
    }

    
    
    @FXML
    void txtMod(MouseEvent event) 
    {
    	lblGestionProduits.setText("Modifier le produit");
    }
    
    
    
    @FXML
    void txtRefr(MouseEvent event) 
    {
    	lblGestionProduits.setText("Rafraichir la table");
    }    
    
    
    
    @FXML
    void txtBarRech(MouseEvent event) 
    {
    	lblGestionProduits.setText("Rechercher par nom / categorie");
    }
    
    
    
    @FXML
    void txtRecher(MouseEvent event) 
    {
    	lblGestionProduits.setText("Rechercher");
    }

    
    
    @FXML
    void txtSuppr(MouseEvent event) 
    {
    	lblGestionProduits.setText("Supprimer un produit");
    }
    
    
    
    @FXML
    void txtPro(MouseEvent event) 
    {
    	lblGestionProduits.setText("-- Gestion des produits --");
    } 
    
    
    
    @FXML
    void pageAjoutProduit(MouseEvent event) throws IOException 
    {
    	@SuppressWarnings("unused")
		VueAjouterProduit vap = new VueAjouterProduit();
    }

    
    
    @FXML
    void pageModifProduit(MouseEvent event) throws IOException 
    {
    	if (tvPro.getSelectionModel().getSelectedIndex() != -1) 
    	{
    	VueAjouterProduit vap = new VueAjouterProduit();
    	vap.getController().modifierProduit((Produit) tvPro.getSelectionModel().getSelectedItem());
    	}
    }

    
    
    @FXML
    void selePro(MouseEvent event) 
    {
    	if (tvPro.getSelectionModel().getSelectedIndex() != -1) 
    	{
    		lblNom.setOpacity(1);
    		lblIdCat.setOpacity(1);
    		lblTarif.setOpacity(1);
//TODO		lblFoisCommande.setOpacity(1);
    		lblVisu.setOpacity(1);
    		
    		taDesc.setOpacity(1);
    		
    		imgVisu.setOpacity(1);
    		
    		
        	btnSuppr.setDisable(false);
        	btnEdit.setDisable(false);
        	btnSuppr.setOpacity(1);
        	btnEdit.setOpacity(1);
    		
        	
    		Produit p = tvPro.getSelectionModel().getSelectedItem();
    		
    		
    		lblNom.setText(p.getNom());
    		lblIdCat.setText(" " + Integer.toString(p.getIdCategorie()));
    		lblTarif.setText(" " + Float.toString(p.getTarif()) + " €");
    		//TODO lblFoisCommande.setText(p.getIdentifiant());
    		lblVisu.setText(p.getVisuel());
    		taDesc.setText(p.getDescription());
    		
    		Image image = new Image(p.getVisuel());
            imgVisu.setImage(image);
    	}
    }

    
    
    @FXML
    void pageSupprProduit(MouseEvent event) 
    {
    	if (tvPro.getSelectionModel().getSelectedIndex() != -1);
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Supprimer un produit");
    	alert.setHeaderText("Voulez-vous vraiment supprimer ce produit ?");
    	alert.setContentText("Ce choix est définitif.");
    	
    	Optional<ButtonType> resultat = alert.showAndWait();
    	
    	if (resultat.isPresent() && resultat.get() == ButtonType.OK) 
    	{
    		daof.getProduitDAO().delete(tvPro.getSelectionModel().getSelectedItem());
    		refresh();
    		
    	}
    }
    
    
    
	public void reset() 
	{
		tfRech.setText("");
		
		lblNom.setText("");
		lblIdCat.setText("");
		lblTarif.setText("");
		lblFoisCommande.setText("");
		lblVisu.setText("");
		taDesc.setText("");
		
		
		lblNom.setOpacity(0);
		lblIdCat.setOpacity(0);
		lblTarif.setOpacity(0);
		lblFoisCommande.setOpacity(0);
		lblVisu.setOpacity(0);
		
		taDesc.setOpacity(0);
		
		imgVisu.setOpacity(0);

		
    	btnSuppr.setDisable(true);
    	btnEdit.setDisable(true);
    	btnSuppr.setOpacity(0.2);
    	btnEdit.setOpacity(0.2);
	}
	
	
	
    public void refresh() 
    {
    	reset();
    	
    	tvPro.getItems().clear();
    	tvPro.getItems().setAll(daof.getProduitDAO().findAll());
    }

    
    
    @FXML
    void rechercher(MouseEvent event) 
    {
    	ArrayList<Produit> listeProduit = new ArrayList<Produit>();
    	
    	for (Produit produit : daof.getProduitDAO().findAll()) 
    	{
    			if (produit.getNom().toLowerCase().contains(tfRech.getText().toLowerCase().trim()))
				{
					listeProduit.add(produit);
				}

    	}
    	
    	tvPro.getItems().clear();
    	tvPro.getItems().setAll(listeProduit);
    
    }
    
    

}