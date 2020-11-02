package vue;


import java.net.URL;

import controller.ControllerAjouterCategorie;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueAjouterCategorie extends Stage
{
	private ControllerAjouterCategorie controler;
	
	public VueAjouterCategorie() 
	{
		try 
		{
			final URL fxmlURL=getClass().getResource("/ajouter_categorie.fxml");
	        
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox part = (VBox)fxmlLoader.load();
			Scene scene = new Scene(part);
			this.setScene(scene);
			
			this.initModality(Modality.APPLICATION_MODAL);
			this.setTitle("Page categorie");
			this.getIcons().add(new Image("file:medias/black/cat.png"));
			
			controler = fxmlLoader.getController();
			controler.setVue(this);
			
			this.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ControllerAjouterCategorie getController()
	{
		  return (controler);
	}
}
	
