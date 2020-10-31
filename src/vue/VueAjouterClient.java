package vue;


import java.net.URL;


import controller.ControllerAjouterClient;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueAjouterClient extends Stage{

	private ControllerAjouterClient controler;
	
	public VueAjouterClient() {
		try {
			final URL fxmlURL=getClass().getResource("/ajouter_client.fxml");
	        
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox part = (VBox)fxmlLoader.load();
			Scene scene = new Scene(part);
			this.setScene(scene);
			
			this.initModality(Modality.APPLICATION_MODAL);
			this.setTitle("Ajout d'un client");
			this.getIcons().add(new Image("file:medias/black/client.png"));
			
			controler = fxmlLoader.getController();
			controler.setVue(this);
			
			this.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ControllerAjouterClient getController() {
		  return (controler);
		}
}
	
