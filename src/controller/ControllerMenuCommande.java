package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import commandes.Commande;
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
import vue.VueAjouterCommande;

public class ControllerMenuCommande
{

	
	
 //-----------------------DECLARATION--------------------------

	
	
	private DAOFactory daof;
	
	
	
 //--------------------------ITEMS------------------------------
	
	
	@FXML
    private Label lblGestionCommandes;
    @FXML
    private Label lblIdCom;
    @FXML
    private Label lblIdCli;
    @FXML
    private Label lblTarif;
    @FXML
    private Label lblQte;
    @FXML
    private Label lblDate;
	
    
    @FXML
    private ImageView btnSuppr;
    @FXML
    private ImageView btnEdit;

    
    @FXML
    private TextField tfRech;

    
    @FXML
    private TableView<Commande> tvCom;

    
    @FXML
    private TableColumn<Commande, Integer> tcIdCom;
    @FXML
    private TableColumn<Commande, LocalDate> tcDate;
    @FXML
    private TableColumn<Commande, Integer> tcIdCli;

    
    
    //--------------------------ACTIONS-----------------------------
    

    
	@FXML
    @SuppressWarnings("unchecked")
    public void initialize() throws IOException 
    {
    	daof = ControllerSettings.getDaof();
    	
        this.tcIdCom.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("idCommande"));
        this.tcDate.setCellValueFactory(new PropertyValueFactory<Commande, LocalDate>("dateCommande"));
        this.tcIdCli.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("idClient"));

        this.tvCom.getColumns().setAll(tcIdCom, tcDate, tcIdCli);
        this.tvCom.getItems().setAll(daof.getCommandeDAO().findAll());     
    }
    
	
	
    @FXML
    void txtAjouter(MouseEvent event)
    {
    	lblGestionCommandes.setText("Ajouter une commande");
        lblGestionCommandes.setStyle("-fx-font-weight: bold;");
    }

    
    
    @FXML
    void txtMod(MouseEvent event) 
    {
    	lblGestionCommandes.setText("Modifier le client");
    }
    
    
    
    @FXML
    void txtRefr(MouseEvent event) 
    {
    	lblGestionCommandes.setText("Rafraichir la table");
    }    
    
    
    
    @FXML
    void txtBarRech(MouseEvent event) 
    {
    	lblGestionCommandes.setText("Rechercher par Client");
    }
    
    
    
    @FXML
    void txtRecher(MouseEvent event) 
    {
    	lblGestionCommandes.setText("Rechercher");
    }

    
    
    @FXML
    void txtSuppr(MouseEvent event) 
    {
    	lblGestionCommandes.setText("Supprimer une commande");
    }
    
    
    
    @FXML
    void txtCom(MouseEvent event) 
    {
    	lblGestionCommandes.setText("-- Gestion des commandes --");
    } 
    
    
    
    @FXML
    void pageAjoutCommande(MouseEvent event) throws IOException 
    {
		@SuppressWarnings("unused")
		VueAjouterCommande vac = new VueAjouterCommande();
    }

    
    
    @FXML
    void pageModifCommande(MouseEvent event) throws IOException 
    {
    	if (tvCom.getSelectionModel().getSelectedIndex() != -1) 
    	{
    	VueAjouterCommande vac = new VueAjouterCommande();
    	vac.getController().modifierClient((Commande) tvCom.getSelectionModel().getSelectedItem());
    	}
    }

    
    
    @FXML
    void seleCom(MouseEvent event) 
    {
    	if (tvCom.getSelectionModel().getSelectedIndex() != -1) 
    	{
    	    lblIdCom.setOpacity(1);
    	    lblIdCli.setOpacity(1);
//TODO 	    lblTarif.setOpacity(1);
//    	    lblQte.setOpacity(1);
    	    lblDate.setOpacity(1);
                                 
    		
        	btnSuppr.setDisable(false);
        	btnEdit.setDisable(false);
        	btnSuppr.setOpacity(1);
        	btnEdit.setOpacity(1);
    		
        	
        	Commande c = tvCom.getSelectionModel().getSelectedItem();
    		
    		
    		lblIdCom.setText(" " + Integer.toString(c.getIdCommande()));
    		lblIdCli.setText(" " + Integer.toString(c.getIdClient()));
//TODO		lblTarif.setText(" " + Integer.toString(c.getTarif));
//			lblQte.setText(" " + Integer.toString(c.getQte));
			lblDate.setText(" " + c.getDateCommande());
    	}
    }

    
    
    @FXML
    void pageSupprCommande(MouseEvent event) 
    {
    	if (tvCom.getSelectionModel().getSelectedIndex() != -1);
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Supprimer une commande");
    	alert.setHeaderText("Voulez-vous vraiment supprimer cete commande ?");
    	alert.setContentText("Ce choix est définitif.");
    	
    	Optional<ButtonType> resultat = alert.showAndWait();
    	
    	if (resultat.isPresent() && resultat.get() == ButtonType.OK) 
    	{
    		daof.getCommandeDAO().delete(tvCom.getSelectionModel().getSelectedItem());
    		refresh();
    		
    	}
    }
    
    
    
	public void reset() 
	{
		tfRech.setText("");
		
	    lblIdCom.setText("");
	    lblIdCli.setText("");
//TODO	lblTarif.setText("");
//		lblQte.setText("");
	    lblDate.setText("");
		
		
	    lblIdCom.setOpacity(0);
	    lblIdCli.setOpacity(0);
//TODO	lblTarif.setOpacity(0);
//		lblQte.setOpacity(0);
	    lblDate.setOpacity(0);

		
    	btnSuppr.setDisable(true);
    	btnEdit.setDisable(true);
    	btnSuppr.setOpacity(0.2);
    	btnEdit.setOpacity(0.2);
	}
	
	
	
    public void refresh() 
    {
    	reset();
    	
    	tvCom.getItems().clear();
    	tvCom.getItems().setAll(daof.getCommandeDAO().findAll());
    }

    
    
    @FXML
    void rechercher(MouseEvent event) 
    {
    	ArrayList<Commande> listeCommande = new ArrayList<Commande>();
        
    	DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
        	for (Commande commande : daof.getCommandeDAO().findAll()) 
        	{
        		if (commande.getDateCommande().equals(LocalDate.parse(tfRech.getText(), formatage)))
					listeCommande.add(commande);
			}
    		
        }
        catch(Exception e) 
        {
        	Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Recherche impossible !");
        	alert.setHeaderText("La date entrée n'est pas au bon format !");
        	alert.setContentText("Utilisez JJ/MM/AAAA");
        }
    	tvCom.getItems().clear();
    	tvCom.getItems().setAll(listeCommande);
    
    }
    
    

}