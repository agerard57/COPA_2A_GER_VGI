package controller;

import java.io.IOException;

import clients.Client;
import dao.factory.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControllerAjouterClient
{

	
	
 //-----------------------DECLARATIONS--------------------------


	
	@SuppressWarnings("unused")
	private Stage vue;
	
	boolean ajout;
	
	private DAOFactory daof;
	
	private int id;
 
	

 //--------------------------ITEMS------------------------------


	
	 @FXML
	    private TextField tfIdClient;

	    @FXML
	    private TextField tfPrix;

	    @FXML
	    private TextField tfQte;

	    @FXML
	    private TextField tfDate;

	    @FXML
	    private Button btnAnnuler;

	    @FXML
	    private Button btnOk;

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
    	
    	String idClient = tfIdClient.getText();
    	String prix = tfPrix.getText();
    	String qte = tfQte.getText();
		String date = tfDate.getText();
    	
		Integer intIdCat = Integer.parseInt(idCat);
    	
		String errorMessage = new String();
    	
		boolean correct = true;

		if (idClient.trim().equals("")) 
		{
			correct = false;
			errorMessage = "- ID Client non saisi. - ";
			showError(tfIdClient);
		}
		
		if (prix.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- Prix unitaire non saisi. -";
			showError(tfPrix);
		}
		
		if (qte.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- Quantitée non saisi. -";
			showError(tfQte);
		}
		
		if (date.trim().equals("")) 
		{
			correct = false;
			errorMessage = errorMessage + "- Date non saisie. -";
			showError(tfDate);
		}
		
		if (correct) 
		{
			Client c = new Client(IdClient, prenom, email, mdp, rue, adr, code, ville, pays);
			
			if (ajout == true) 
			{
				daof.getClientDAO().create(c);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Creation du client");
		    	alert.setHeaderText("Le client a bien été crée !");
		    	alert.setContentText("Pensez à rafraîchir le tableau !");
		    	alert.showAndWait();
				Stage stage = (Stage) btnOk.getScene().getWindow();
				stage.close();
			}
			else 
			{
				c.setIdClient(id);
				daof.getClientDAO().update(c);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Modification du client");
		    	alert.setHeaderText("Le client a bien été modifié !");
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



    public void modifierClient(Client cli)
    {
    	ajout = false;
    	
    	id = cli.getIdClient();
		tfNom.setText(cli.getNom());
		tfPrenom.setText(cli.getPrenom());
		tfEmail.setText(cli.getIdentifiant());
		pfMdp.setText(cli.getMotDePasse());
		pfMdp2.setText(cli.getMotDePasse());
		tfRue.setText(cli.getAdrNumero());
		tfAdr.setText(cli.getAdrVoie());
		tfCode.setText(cli.getAdrCodePostal());
		tfVille.setText(cli.getAdrVille());
		tfPays.setText(cli.getAdrPays());
		
		lblAfficher.setText("-- Modification de " + cli.getNom() + " " + cli.getPrenom() + " ---");
    }
    
 
    
    private void resetColors() 
    {
		this.lblAfficher.setTextFill(Color.BLACK);
		
		this.tfNom.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfPrenom.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfEmail.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.pfMdp.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.pfMdp2.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfPays.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfVille.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfRue.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));		
		this.tfAdr.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));		
		this.tfCode.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));		
	}

    
    
	public void showError(Control o) 
	{
		o.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
	}
	
	
	
	public void setVue(Stage vueAjouterClient) 
	{
		this.vue = vueAjouterClient;
	}
 
	

}
