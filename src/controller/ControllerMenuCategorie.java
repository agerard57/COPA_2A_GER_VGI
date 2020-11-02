package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import categorie.Categorie;
import dao.factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import vue.VueAjouterCategorie;

public class ControllerMenuCategorie
{

	
	
 //-----------------------DECLARATION--------------------------

	
	
	private DAOFactory daof;
	
	
	
 //--------------------------ITEMS------------------------------
	
	
	
    @FXML
    private Label lblTitre;
    @FXML
    private Label lblId;
    @FXML
    private Label lblVisu;
	@FXML
	private Label lblGestionCategories;
    
    
	@FXML
	private ImageView btnSuppr;
	@FXML
	private ImageView btnEdit;

	
	@FXML
	private TextField tfRech;


	@FXML
	private ImageView imgVisu;


    @FXML
    private TableView<Categorie> tvCat;
    
    
    @FXML
    private TableColumn<Categorie, String> tcTitre;

    
    
    //--------------------------ACTIONS-----------------------------
    

    
	@FXML
    @SuppressWarnings("unchecked")
    public void initialize() throws IOException 
    {
    	daof = ControllerSettings.getDaof();
    	

        this.tcTitre.setCellValueFactory(new PropertyValueFactory<Categorie, String>("Titre"));


        this.tvCat.getColumns().setAll(tcTitre);
        this.tvCat.getItems().setAll(daof.getCategorieDAO().findAll());     
    }
    
	
	
    @FXML
    void txtAjouter(MouseEvent event)
    {
    	lblGestionCategories.setText("Ajouter une Catégorie");
        lblGestionCategories.setStyle("-fx-font-weight: bold;");
    }

    
    
    @FXML
    void txtMod(MouseEvent event) 
    {
    	lblGestionCategories.setText("Modifier la Catégorie");
    }
    
    
    
    @FXML
    void txtRefr(MouseEvent event) 
    {
    	lblGestionCategories.setText("Rafraichir la table");
    }    
    
    
    
    @FXML
    void txtBarRech(MouseEvent event) 
    {
    	lblGestionCategories.setText("Rechercher par titre");
    }
    
    
    
    @FXML
    void txtRecher(MouseEvent event) 
    {
    	lblGestionCategories.setText("Rechercher");
    }

    
    
    @FXML
    void txtSuppr(MouseEvent event) 
    {
    	lblGestionCategories.setText("Supprimer une Catégorie");
    }
    
    
    
    @FXML
    void txtCat(MouseEvent event) 
    {
    	lblGestionCategories.setText("-- Gestion des Catégories --");
    } 
    
    
    
    @FXML
    void pageAjoutCategorie(MouseEvent event) throws IOException 
    {
    	@SuppressWarnings("unused")
		VueAjouterCategorie vac = new VueAjouterCategorie();
    }

    
    
    @FXML
    void pageModifCategorie(MouseEvent event) throws IOException 
    {
    	if (tvCat.getSelectionModel().getSelectedIndex() != -1) 
    	{
    	VueAjouterCategorie vac = new VueAjouterCategorie();
    	vac.getController().modifierCategorie((Categorie) tvCat.getSelectionModel().getSelectedItem());
    	}
    }

    
    
    @FXML
    void seleCat(MouseEvent event) 
    {
    	if (tvCat.getSelectionModel().getSelectedIndex() != -1) 
    	{
    		lblTitre.setOpacity(1);
    		lblId.setOpacity(1);
    		lblVisu.setOpacity(1);

    		
    		imgVisu.setOpacity(1);
    		
    		
        	btnSuppr.setDisable(false);
        	btnEdit.setDisable(false);
        	btnSuppr.setOpacity(1);
        	btnEdit.setOpacity(1);
    		
        	
    		Categorie c = tvCat.getSelectionModel().getSelectedItem();
    		
    		
    		lblTitre.setText(c.getTitre());
    		lblId.setText(" " + Integer.toString(c.getIdCategorie()));
    		lblVisu.setText(c.getVisuel());
    		
    		Image image = new Image(c.getVisuel());
            imgVisu.setImage(image);
    	}
    }

    
    
    @FXML
    void pageSupprCategorie(MouseEvent event) 
    {
    	if (tvCat.getSelectionModel().getSelectedIndex() != -1);
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Supprimer une Catégorie");
    	alert.setHeaderText("Voulez-vous vraiment supprimer cette Catégorie ?");
    	alert.setContentText("Ce choix est définitif.");
    	
    	Optional<ButtonType> resultat = alert.showAndWait();
    	
    	if (resultat.isPresent() && resultat.get() == ButtonType.OK) 
    	{
    		daof.getCategorieDAO().delete(tvCat.getSelectionModel().getSelectedItem());
    		refresh();
    		
    	}
    }
    
    
    
	public void reset() 
	{
		tfRech.setText("");
		
		lblTitre.setText("");
		lblId.setText("");
		lblVisu.setText("");
		
		
		lblTitre.setOpacity(0);
		lblId.setOpacity(0);
		lblVisu.setOpacity(0);
		
		
		imgVisu.setOpacity(0);

		
    	btnSuppr.setDisable(true);
    	btnEdit.setDisable(true);
    	btnSuppr.setOpacity(0.2);
    	btnEdit.setOpacity(0.2);
	}
	
	
	
    public void refresh() 
    {
    	reset();
    	
    	tvCat.getItems().clear();
    	tvCat.getItems().setAll(daof.getCategorieDAO().findAll());
    }

    
    
    @FXML
    void rechercher(MouseEvent event) 
    {
    	ArrayList<Categorie> listeCategorie = new ArrayList<Categorie>();
    	
    	for (Categorie Categorie : daof.getCategorieDAO().findAll()) 
    	{
    			if (Categorie.getTitre().toLowerCase().contains(tfRech.getText().toLowerCase().trim()))
				{
					listeCategorie.add(Categorie);
				}

    	}
    	
    	tvCat.getItems().clear();
    	tvCat.getItems().setAll(listeCategorie);
    
    }
    
    

}