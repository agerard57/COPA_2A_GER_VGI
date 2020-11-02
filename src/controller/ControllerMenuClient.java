package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import clients.Client;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import vue.VueAjouterClient;

public class ControllerMenuClient
{

	
	
 //-----------------------DECLARATION--------------------------

	
	
	private DAOFactory daof;
	
	
	
 //--------------------------ITEMS------------------------------
	
	
	
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
    private Label lblGestionClients;

    
    @FXML
    private ImageView btnSuppr;
    @FXML
    private ImageView btnEdit;
    
    
    @FXML
    private TextField tfRech;
    
    
    @FXML
    private TableView<Client> tvCli;

    
    @FXML
    private TableColumn<Client, String> tcNom;
    @FXML
    private TableColumn<Client, String> tcPrenom;
    @FXML
    private TableColumn<Client, String> tcAdrVille;

    
    
    //--------------------------ACTIONS-----------------------------
    

    
	@FXML
    @SuppressWarnings("unchecked")
    public void initialize() throws IOException 
    {
    	daof = ControllerSettings.getDaof();
    	
        this.tcNom.setCellValueFactory(new PropertyValueFactory<Client, String>("Nom"));
        this.tcPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("Prenom"));
        this.tcAdrVille.setCellValueFactory(new PropertyValueFactory<Client, String>("AdrVille"));

        this.tvCli.getColumns().setAll(tcNom,tcPrenom,tcAdrVille);
        this.tvCli.getItems().setAll(daof.getClientDAO().findAll());     
    }
    
	
	
    @FXML
    void txtAjouter(MouseEvent event)
    {
    	lblGestionClients.setText("Ajouter un client");
        lblGestionClients.setStyle("-fx-font-weight: bold;");
    }

    
    
    @FXML
    void txtMod(MouseEvent event) 
    {
    	lblGestionClients.setText("Modifier le client");
    }
    
    
    
    @FXML
    void txtRefr(MouseEvent event) 
    {
    	lblGestionClients.setText("Rafraichir la table");
    }    
    
    
    
    @FXML
    void txtBarRech(MouseEvent event) 
    {
    	lblGestionClients.setText("Rechercher par nom / nom , prenom");
    }
    
    
    
    @FXML
    void txtRecher(MouseEvent event) 
    {
    	lblGestionClients.setText("Rechercher");
    }

    
    
    @FXML
    void txtSuppr(MouseEvent event) 
    {
    	lblGestionClients.setText("Supprimer un client");
    }
    
    
    
    @FXML
    void txtCli(MouseEvent event) 
    {
    	lblGestionClients.setText("-- Gestion des clients --");
    } 
    
    
    
    @FXML
    void pageAjoutClient(MouseEvent event) throws IOException 
    {
		@SuppressWarnings("unused")
		VueAjouterClient vac = new VueAjouterClient();
    }

    
    
    @FXML
    void pageModifClient(MouseEvent event) throws IOException 
    {
    	if (tvCli.getSelectionModel().getSelectedIndex() != -1) 
    	{
    	VueAjouterClient vac = new VueAjouterClient();
    	vac.getController().modifierClient((Client) tvCli.getSelectionModel().getSelectedItem());
    	}
    }

    
    
    @FXML
    void seleCli(MouseEvent event) 
    {
    	if (tvCli.getSelectionModel().getSelectedIndex() != -1) 
    	{
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
    void pageSupprClient(MouseEvent event) 
    {
    	if (tvCli.getSelectionModel().getSelectedIndex() != -1);
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Supprimer un client");
    	alert.setHeaderText("Voulez-vous vraiment supprimer ce client ?");
    	alert.setContentText("Ce choix est définitif.");
    	
    	Optional<ButtonType> resultat = alert.showAndWait();
    	
    	if (resultat.isPresent() && resultat.get() == ButtonType.OK) 
    	{
    		daof.getClientDAO().delete(tvCli.getSelectionModel().getSelectedItem());
    		refresh();
    		
    	}
    }
    
    
    
	public void reset() 
	{
		tfRech.setText("");
		
		
		lblNom.setText("");
		lblPrenom.setText("");
		lblID.setText("");
		lblEmail.setText("");
		lblAdr1.setText("");
		lblAdr2.setText("");
		lblAdr3.setText("");
		
		
		lblNom.setOpacity(0);
		lblPrenom.setOpacity(0);
		lblID.setOpacity(0);
		lblEmail.setOpacity(0);
		lblAdr1.setOpacity(0);
		lblAdr2.setOpacity(0);
		lblAdr3.setOpacity(0);

		
    	btnSuppr.setDisable(true);
    	btnEdit.setDisable(true);
    	btnSuppr.setOpacity(0.2);
    	btnEdit.setOpacity(0.2);
	}
	
	
	
    public void refresh() 
    {
    	reset();
    	
    	tvCli.getItems().clear();
    	tvCli.getItems().setAll(daof.getClientDAO().findAll());
    }

    
    
    @FXML
    void rechercher(MouseEvent event) 
    {
    	ArrayList<Client> listeClient = new ArrayList<Client>();
    	
    	String[] res;
    	
    	boolean	type = tfRech.getText().contains(",");
    	
    	for (Client client : daof.getClientDAO().findAll()) 
    	{
    		if (!type) // Recherche Nom
    		{
    			if (client.getNom().toLowerCase().contains(tfRech.getText().toLowerCase().trim()))
				{
					listeClient.add(client);
				}
    		}
    		else  // Recherche Nom , Prenom 
    		{
    			res = tfRech.getText().split(",");
    			if (client.getNom().toLowerCase().contains(res[0].toLowerCase().trim()) && client.getPrenom().toLowerCase().contains(res[1].toLowerCase().trim()))
				{
					listeClient.add(client);
				}
    		}  		
    	}
    	
    	tvCli.getItems().clear();
    	tvCli.getItems().setAll(listeClient);
    
    }
    
    

}