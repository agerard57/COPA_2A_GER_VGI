package controller;

import java.io.File;
import java.io.IOException;

import dao.factory.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import produits.Produit;

public class ControllerAjouterProduit
{

	
	
 //-----------------------DECLARATIONS--------------------------


	
	private Stage vue;
	
	boolean ajout;
	
	private DAOFactory daof;
	
	private int id;
 
	

 //--------------------------ITEMS------------------------------


	
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnImport;
    
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfVisu;
    @FXML
    private TextField tfTarif;
    @FXML
    private TextField tfCat;


    @FXML
    private TextArea taDesc;
    

    @FXML
    private ImageView imgPrevisu;

    
    @FXML
    private Label lblAfficher;



 //--------------------------ACTIONS-----------------------------

	
	@FXML
	public void initialize() throws IOException
	{
		ajout = true;
		daof = ControllerSettings.getDaof();
	}
	
	
	
    @FXML
    void fermerPage(ActionEvent event)
    {
		Stage stage = (Stage) btnAnnuler.getScene().getWindow();
		stage.close();
    }
	
    
    
    @FXML
    void creerModele(ActionEvent event) 
    {
    	resetColors();
    	
    	String nom = tfNom.getText();
    	String cat = tfCat.getText();
    	String desc = taDesc.getText();
		String tarif = tfTarif.getText();
		String visuel = tfVisu.getText();
    	
		Float fTarif = Float.parseFloat(tarif);
		Integer intCat = Integer.parseInt(cat);
    	
		String errorMessage = new String();
    	
		boolean correct = true;

		if (nom.trim().equals("")) 
		{
			correct = false;
			errorMessage = "- Nom non saisi. - ";
			showError(tfNom);
		}
		
		if (cat.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- Catégorie non choisie. -";
			showError(tfCat);
		}
		
		if (desc.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- Description non saisie. -";
			showError(taDesc);
		}
		
		if (tarif.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- Tarif non saisi. -";
			showError(tfTarif);
		}
		
		if (visuel.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- Visuel nan saisi. -";
			showError(tfVisu);
		}
		if (correct) 
		{
			Produit p = new Produit(nom, desc, fTarif, visuel, intCat);
			
			if (ajout == true) 
			{
				daof.getProduitDAO().create(p);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Creation du produit");
		    	alert.setHeaderText("Le produit a bien été crée !");
		    	alert.setContentText("Pensez à rafraîchir le tableau !");
		    	alert.showAndWait();
				Stage stage = (Stage) btnOk.getScene().getWindow();
				stage.close();
			}
			else 
			{
				p.setIdProduit(id);
				daof.getProduitDAO().update(p);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Modification du produit");
		    	alert.setHeaderText("Le produit a bien été modifié !");
		    	alert.setContentText("Pensez à rafraîchir le tableau !");
		    	alert.showAndWait();
				Stage stage = (Stage) btnOk.getScene().getWindow();
				stage.close();
			}
		}
		else 
		{
			this.lblAfficher.setText(errorMessage);
			this.lblAfficher.setTextFill(Color.RED);
		}
		
	}



    public void modifierProduit(Produit pro)
    {
    	ajout = false;
    	
		String strCateg = Integer.toString(pro.getIdCategorie());
		String strTar = Float.toString(pro.getTarif());
    	
		id = pro.getIdProduit();
		tfNom.setText(pro.getNom());

		tfCat.setText(strCateg);
		taDesc.setText(pro.getDescription());
		tfTarif.setText(strTar);
		tfVisu.setText(pro.getVisuel());
		
		Image image = new Image(pro.getVisuel());
        imgPrevisu.setImage(image);
		
		lblAfficher.setText("-- Modification de " + pro.getNom() + " ---");
    }
    
 
    
    private void resetColors() 
    {
		this.lblAfficher.setTextFill(Color.BLACK);
		
		this.tfNom.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfCat.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.taDesc.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfTarif.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfVisu.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));	
	}

    
    
	public void showError(Control o) 
	{
		o.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
	}
	
	
	
	public void setVue(Stage vueAjouterProduit) 
	{
		this.vue = vueAjouterProduit;
	}
 


    @FXML
    void importImage(MouseEvent event) throws IOException 
    {
    	 FileChooser fileChooser = new FileChooser();
    	 
    	 fileChooser.setTitle("Importer une image");
    	 fileChooser.getExtensionFilters().addAll(
    	 new ExtensionFilter("Fichiers images", "*.png", "*.jpg"),
    	 new ExtensionFilter("Tous les fichiers", "*.*"));
    	 
    	 File selectedFile = fileChooser.showOpenDialog(this.vue);
    	 
    	 String s = selectedFile.getPath();

    	 if (!s.contains("\\produit\\")) 
    	 {
    		 lblAfficher.setText("Prendre une image du fichier \"produit\"");
    	 }
    	 else 
    	 {
        	String s1 = s.substring(s.indexOf("\\visuels\\"));
        	tfVisu.setText(s1.trim());
        	 
     		Image image = new Image(tfVisu.getText());
            imgPrevisu.setImage(image);
    	 }
    }
}

