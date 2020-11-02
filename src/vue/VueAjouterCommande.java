package vue;


import java.net.URL;


import controller.ControllerAjouterCommande;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueAjouterCommande extends Stage
{
	private ControllerAjouterCommande controler;
	
	public VueAjouterCommande() 
	{
		try 
		{
			final URL fxmlURL=getClass().getResource("/ajouter_commande.fxml");
	        
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox part = (VBox)fxmlLoader.load();
			Scene scene = new Scene(part);
			this.setScene(scene);
			
			this.initModality(Modality.APPLICATION_MODAL);
			this.setTitle("Page commande");
			this.getIcons().add(new Image("file:medias/black/order.png"));
			
			controler = fxmlLoader.getController();
			controler.setVue(this);
			
			this.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ControllerAjouterCommande getController()
	{
		  return (controler);
	}
}
	
