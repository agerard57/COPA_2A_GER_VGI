package controller;

import java.io.IOException;
import java.time.LocalDate;

import commandes.Commande;
import dao.factory.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControllerAjouterCommande
{

	
	
 //-----------------------DECLARATIONS--------------------------


	
	@SuppressWarnings("unused")
	private Stage vue;
	
	boolean ajout;
	
	private DAOFactory daof;
	
	private int id;
 
	

 //--------------------------ITEMS------------------------------



    @FXML
    private Label lblAfficher;
    
    

    @FXML
    private TextField tfIdCom;
    @FXML
    private TextField tfIdProd;
    @FXML
    private TextField tfIdCli;
    @FXML
    private TextField tfTarif;
    @FXML
    private TextField tfQte;
   
    
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnOk;

	

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
    	
    	LocalDate localDate = LocalDate.now();
    	
   
    	String idCom = tfIdCom.getText();
    	String idProd = tfIdProd.getText();
    	String idCli = tfIdCli.getText();
//TODO  String tarif = tfTarif.getText();
//    	String qte = tfQte.getText();

    	
		Integer intIdCom = Integer.parseInt(idCom);
		Integer intIdCli = Integer.parseInt(idCli);
//TODO	Integer intIdProd = Integer.parseInt(idProd);
//		Float floatTarif = Float.parseFloat(tarif);

		
		String errorMessage = new String();
    	
		boolean correct = true;

		if (idCom.trim().equals("")) 
		{
			correct = false;
			errorMessage = "- ID Commande non saisi. - ";
			showError(tfIdCom);
		}
		
		if (idProd.trim().equals("")) 
		{
			correct = false;
			errorMessage = "- ID Produit non saisi. - ";
			showError(tfIdProd);
		}
		
		if (idCli.trim().equals("")) 
		{
			correct = false;
			errorMessage = "- ID Client non saisi. - ";
			showError(tfIdCli);
		}
		
//TODO	if (tarif.trim().equals("")) 
//		{
//			correct = false;
//			errorMessage = errorMessage + "- Tarif unitaire non saisie. -";
//			showError(tfTarif);
//		}
//		if (qte.trim().equals("")) 
//		{
//			correct = false;
//			errorMessage = errorMessage + "- Quantité non saisie. -";
//			showError(tfQte);
//		}

		
		if (correct) 
		{
			Commande c = new Commande(intIdCom, localDate, intIdCli);
			
			if (ajout == true) 
			{
				daof.getCommandeDAO().create(c);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Creation de la commande");
		    	alert.setHeaderText("La commande a bien été crée !");
		    	alert.setContentText("Pensez à rafraîchir le tableau !");
		    	alert.showAndWait();
				Stage stage = (Stage) btnOk.getScene().getWindow();
				stage.close();
			}
			else 
			{
				c.setIdCommande(id);
				daof.getCommandeDAO().update(c);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Modification de la commande");
		    	alert.setHeaderText("La commande a bien été modifié !");
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



    public void modifierClient(Commande com)
    {
    	ajout = false;
    	
		String strIdComm = Integer.toString(com.getIdCommande());
		String strIdClie = Integer.toString(com.getIdClient());
//TODO	String strIdProdu = Integer.toString(lc.getIdProduit());
//		String strFTar = Float.toString(lc.getTarif());
//		String strQtte = Integer.toString(lc.getIdCommande());

		
    	id = com.getIdCommande();
    	
    	tfIdCom.setText(strIdComm);
		tfIdCli.setText(strIdClie);
//TODO	tfIdProd.setText(strIdProdu);
//		tfTarif.setText(strFTar);
//		tfQte.setText(strQtte);
//		tfDate.setText(dteCmd);

		
		lblAfficher.setText("-- Modification de la commande n" + com.getIdCommande() + " ---");
    }
    
 
    
    private void resetColors() 
    {
		this.lblAfficher.setTextFill(Color.BLACK);
		
		this.tfIdCom.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfIdProd.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
		this.tfIdCli.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
//TODO	this.tfTarif.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
//		this.tfQte.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
//		this.tfDate.setBorder(new Border(new BorderStroke(Color.web("#25221e"), BorderStrokeStyle.SOLID, null, null)));
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
