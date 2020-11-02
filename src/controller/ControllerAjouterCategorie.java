package controller;

import java.io.File;
import java.io.IOException;

import categorie.Categorie;
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

public class ControllerAjouterCategorie
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
    private TextField tfTitre;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfVisu;

    
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
    	
    	String titre = tfTitre.getText();
    	String idCat = tfId.getText();
		String visuel = tfVisu.getText();
    	

		Integer intIdCat = Integer.parseInt(idCat);
    	
		String errorMessage = new String();
    	
		boolean correct = true;

		if (titre.trim().equals("")) 
		{
			correct = false;
			errorMessage = "- Titre non saisi. - ";
			showError(tfTitre);
		}
		
		if (idCat.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- ID Catégorie non choisie. -";
			showError(tfId);
		}
		
		if (visuel.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- Visuel nan saisi. -";
			showError(tfVisu);
		}
		if (correct) 
		{
			Categorie c = new Categorie(intIdCat, titre, visuel);
			
			if (ajout == true) 
			{
				daof.getCategorieDAO().create(c);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Creation de categorie");
		    	alert.setHeaderText("La catégorie a bien été créée !");
		    	alert.setContentText("Pensez à rafraîchir le tableau !");
		    	alert.showAndWait();
				Stage stage = (Stage) btnOk.getScene().getWindow();
				stage.close();
			}
			else 
			{
				c.setIdCategorie(id);
				daof.getCategorieDAO().update(c);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Modification de la categorie");
		    	alert.setHeaderText("La catégorie a bien été modifiée !");
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



    public void modifierCategorie(Categorie pro)
    {
    	ajout = false;
    	
		String strIdent = Integer.toString(pro.getIdCategorie());
    	
		id = pro.getIdCategorie();
		tfTitre.setText(pro.getTitre());

		tfId.setText(strIdent);
		tfVisu.setText(pro.getVisuel());
		
		Image image = new Image(pro.getVisuel());
        imgPrevisu.setImage(image);
		
		lblAfficher.setText("-- Modification de " + pro.getTitre() + " ---");
    }
    
 
    
    private void resetColors() 
    {
		this.lblAfficher.setTextFill(Color.BLACK);
		
		this.tfTitre.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfId.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfVisu.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));	
	}

    
    
	public void showError(Control o) 
	{
		o.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
	}
	
	
	
	public void setVue(Stage vueAjouterCategorie) 
	{
		this.vue = vueAjouterCategorie;
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

    	 if (!s.contains("\\categorie\\")) 
    	 {
    		 lblAfficher.setText("Prendre une image du fichier \"categorie\"");
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

