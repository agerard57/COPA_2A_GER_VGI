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
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vue.VueAjouterClient;

public class ControllerAjouterClient {
	
	boolean ajout;
	
	@SuppressWarnings("unused")
	private Stage vue;
	
	private DAOFactory daof;
	
	private int id;

		
    
	   @FXML
	    private Label lblNom;

	    @FXML
	    private TextField tfNom;

	    @FXML
	    private Label lblEmail;

	    @FXML
	    private TextField tfPrenom;

	    @FXML
	    private Label lblPrenom;

	    @FXML
	    private TextField tfEmail;

	    @FXML
	    private Label lblMdp;

	    @FXML
	    private Label lblMdp2;

	    @FXML
	    private PasswordField pfMdp;

	    @FXML
	    private PasswordField pfMdp2;

	    @FXML
	    private Label lblRue;

	    @FXML
	    private TextField tfRue;

	    @FXML
	    private Label lblAdr;

	    @FXML
	    private TextField tfAdr;

	    @FXML
	    private Label lblCode;

	    @FXML
	    private Label lblPays;

	    @FXML
	    private TextField tfCode;

	    @FXML
	    private Label lblVille;

	    @FXML
	    private TextField tfVille;

	    @FXML
	    private TextField tfPays;

	    @FXML
	    private FlowPane fpCreer;

	    @FXML
	    private Button btnAnnuler;

	    @FXML
	    private Button btnOk;

	    @FXML
	    private Label lblAfficher;


    public void modifierClient(Client cli){
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
    
    @FXML
    void creerModele(ActionEvent event) {
    	
    	resetColors();
    	
    	String nom = tfNom.getText();
    	String prenom = tfPrenom.getText();
    	String email = tfEmail.getText();
		String mdp = pfMdp.getText();
		String mdp2 = pfMdp2.getText();
    	String rue = tfRue.getText();
    	String ville = tfVille.getText();
    	String adr = tfAdr.getText();
    	String code = tfCode.getText();
    	String pays = tfPays.getText();
    	
    	String errorMessage = new String();
    	
		boolean correct = true;

		if (nom.trim().equals("")) {
			correct = false;
			errorMessage = "- Nom non saisi. - ";
			showError(tfNom);
		}
		
		if (prenom.trim().equals("")) {
			correct = false;
			errorMessage = errorMessage + "- Prénom non saisi. -";
			showError(tfPrenom);
		}
		
		if (email.trim().equals("")) {
			correct = false;
			errorMessage = errorMessage + "- Email non saisi. -";
			showError(tfEmail);
		}
		
		if (mdp.trim().equals("")) {
			correct = false;
			errorMessage = errorMessage + "- Mot de passe non saisi. -";
			showError(pfMdp);
		}
		
		if (!mdp.equals(mdp2)) {
			correct = false;
			errorMessage = errorMessage + "- Les mot de passe sont différents ! -";
			showError(pfMdp);
			showError(pfMdp2);
		}
		
		if (rue.trim().equals("")) {
			correct = false;
			errorMessage = errorMessage + "- N° de rue non saisie. -";
			showError(tfRue);
		}
		
		if (adr.trim().equals("")) {
			correct = false;
			errorMessage = errorMessage + "- Nom de voie non saisie. -";
			showError(tfAdr);
		}
		
		if (code.trim().equals("")) {
			correct = false;
			errorMessage = errorMessage + "- Code postal non saisi. -";
			showError(tfCode);
		}
		
		if (ville.trim().equals("")) {
			correct = false;
			errorMessage = errorMessage + "- Ville non saisie. -";
			showError(tfVille);
		}
		
		if (pays.trim().equals("")) {
			correct = false;
			errorMessage = errorMessage + "- Pays non saisi. -";
			showError(tfPays);
		}
		
		if (correct) {
			Client c = new Client(nom, prenom, email, mdp, rue, adr, code, ville, pays);
			if (ajout == true) {
				daof.getClientDAO().create(c);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Creation du client");
		    	alert.setHeaderText("Le client à bien été crée !");
		    	alert.setContentText("Pensez à rafraîchir le tableau !");
		    	alert.showAndWait();
				Stage stage = (Stage) btnOk.getScene().getWindow();
				stage.close();
			}
			else {
				c.setIdClient(id);
				daof.getClientDAO().update(c);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Modification du client");
		    	alert.setHeaderText("Le client à bien été modifié !");
		    	alert.setContentText("Pensez à rafraîchir le tableau !");
		    	alert.showAndWait();
				Stage stage = (Stage) btnOk.getScene().getWindow();
				stage.close();
			}
		}
		else {
			this.lblAfficher.setText(errorMessage);
			this.lblAfficher.setTextFill(Color.RED);
		}
	}

    private void resetColors() {
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

	public void showError(Control o) {
		o.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
	}
	
	
    @FXML
    void fermerPage(ActionEvent event) {
		Stage stage = (Stage) btnAnnuler.getScene().getWindow();
		stage.close();
    }
	


	public void setVue(Stage vueAjouterClient) {
		this.vue = vueAjouterClient;
	}
    
	public void initialize() throws IOException{
    	ajout = true;
    	daof = ControllerSettings.getDaof();
    }
}
