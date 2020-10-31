package controller;

import java.io.IOException;
import java.util.Optional;

import clients.Client;
import dao.factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vue.VueAjouterClient;

public class ControllerMenuClient {

	private DAOFactory daof;

    @FXML
    private Label lblGestionClients;

    @FXML
    private AnchorPane barreGestion;

    @FXML
    private ImageView btnAjout;

    @FXML
    private ImageView btnSuppr;

    @FXML
    private ImageView btnEdit;

    @FXML
    private ImageView btnRech;

    @FXML
    private Label lblNom;

    @FXML
    private Label lblPrenom;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblID;

    @FXML
    private Label lblAdr1;

    @FXML
    private Label lblAdr2;
    
    @FXML
    private Label lblAdr3;
    
    @FXML
    private TableView<Client> tvCli;

    @FXML
    private TableColumn<Client, ?> tcIdtt;

    @FXML
    private TableColumn<Client, String> tcNom;

    @FXML
    private TableColumn<Client, String> tcPrenom;

    @FXML
    private TableColumn<Client, String> tcEmail;

    @FXML
    private TableColumn<Client, String> tcAdrVille;

    @FXML
    void txtAjouter(MouseEvent event) {
    	lblGestionClients.setText("Ajouter un client");
        lblGestionClients.setStyle("-fx-font-weight: bold;");

    }

    @FXML
    void txtMod(MouseEvent event) {
    	lblGestionClients.setText("Modifier le client");
    }

    @FXML
    void txtRecher(MouseEvent event) {
    	lblGestionClients.setText("Rechercher");
    }

    @FXML
    void txtSuppr(MouseEvent event) {
    	lblGestionClients.setText("Supprimer un client");
    }
    
    @FXML
    void pageAjoutClient(MouseEvent event) throws IOException {
    	
    	VueAjouterClient vac = new VueAjouterClient();
    	
    }

    @FXML
    void pageModifClient(MouseEvent event) throws IOException {
    	if (tvCli.getSelectionModel().getSelectedIndex() != -1) {
    	VueAjouterClient vac = new VueAjouterClient();
    	vac.getController().modifierClient((Client) tvCli.getSelectionModel().getSelectedItem());
}
    	}

    @FXML
    void seleCli(MouseEvent event) {
    	if (tvCli.getSelectionModel().getSelectedIndex() != -1) {
    		lblNom.setOpacity(1);
    		lblPrenom.setOpacity(1);
    		lblID.setOpacity(1);
    		lblEmail.setOpacity(1);
    		lblAdr1.setOpacity(1);
    		lblAdr2.setOpacity(1);
    		lblAdr3.setOpacity(1);

        	btnSuppr.setDisable(false);
        	btnEdit.setDisable(false);
        	btnSuppr.setOpacity(1);
        	btnEdit.setOpacity(1);
    		
    		Client c = tvCli.getSelectionModel().getSelectedItem();
    		
    		lblNom.setText(c.getNom());
    		lblPrenom.setText(c.getPrenom());
    		lblID.setText(" " + Integer.toString(c.getIdClient()));
    		lblEmail.setText(c.getIdentifiant());
    		lblAdr1.setText(c.getAdrNumero() + " " + c.getAdrVoie());
    		lblAdr2.setText(c.getAdrCodePostal() + " " + c.getAdrVille());
    		lblAdr3.setText(c.getAdrPays());

    	}
    }

    @FXML
    void pageSupprClient(MouseEvent event) {
    	if (tvCli.getSelectionModel().getSelectedIndex() != -1);
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Supprimer un client");
    	alert.setHeaderText("Voulez-vous vraiment supprimer ce client ?");
    	alert.setContentText("Ce choix est définitif.");
    	
    	Optional<ButtonType> resultat = alert.showAndWait();
    	if (resultat.isPresent() && resultat.get() == ButtonType.OK) {
    		daof.getClientDAO().delete(tvCli.getSelectionModel().getSelectedItem());
    		refresh();
    		
    	}
    }
    
	public void reset() {
		lblNom.setText("");
		lblPrenom.setText("");
		lblID.setText("");
		lblEmail.setText("");
		lblAdr1.setText("");
		lblAdr2.setText("");
		lblAdr3.setText("");
	}
	
    public void refresh() {
    	reset();
    	tvCli.getItems().clear();
    	tvCli.getItems().setAll(daof.getClientDAO().findAll());
    }
    @FXML
    void rechercher(MouseEvent event) {

    }
    
    @SuppressWarnings("unchecked")
	@FXML
    public void initialize() throws IOException {
    	
    	daof = ControllerSettings.getDaof();
    	
        this.tcNom.setCellValueFactory(new PropertyValueFactory<Client, String>("Nom"));

        this.tcPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("Prenom"));

        this.tcAdrVille.setCellValueFactory(new PropertyValueFactory<Client, String>("AdrVille"));
       

        this.tvCli.getColumns().setAll(tcNom,tcPrenom,tcAdrVille);
        this.tvCli.getItems().setAll(daof.getClientDAO().findAll());
        
            }
}

    



    
