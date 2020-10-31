package controller;

import java.io.IOException;

import com.sun.javafx.scene.control.LabeledText;

import clients.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ControllerMenuClient {

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

    private ObservableList<Client> getClients(){
        ObservableList<Client> clients = FXCollections.observableArrayList();
        clients.add(new Client(1,"GERARD","Alexandre","se57@hm.fr",null, null, null, null, "Metz", null));
        clients.add(new Client(2,"RYAN","Andrew","bio75@mi.com",null, null, null, null, "Rapture", null));
        clients.add(new Client(3,"REZNOV","Victor","lib12@fre.ru", null, null, null, null, "Tentling", null));
        return clients;
        }

    @FXML
    private TableView<Client> tvCli;

    @FXML
    private TableColumn<Client, Integer> tcID;

    @FXML
    private TableColumn<Client, ?> tcIdtt;

    @FXML
    private TableColumn<Client, String> tcNom;

    @FXML
    private TableColumn<Client, String> tcPrenom;

    @FXML
    private TableColumn<Client, String> tcEmail;

    @FXML
    private TableColumn<Client, String> tcVille;

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
    public void initialize() throws IOException{
    	loadTV();
    }

	@SuppressWarnings("unchecked")
	private void loadTV() {
	        tcID.setCellValueFactory(new PropertyValueFactory<>("ID"));

	        tcNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));

	        tcPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));

	        tcVille.setCellValueFactory(new PropertyValueFactory<>("Ville"));

	        tvCli.setItems(getClients());
	        tvCli.getColumns().addAll(tcID,tcNom,tcPrenom,tcVille);
	}
 }
    
