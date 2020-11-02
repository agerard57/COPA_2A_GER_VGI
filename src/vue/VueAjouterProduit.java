package vue;


import java.net.URL;


import controller.ControllerAjouterProduit;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueAjouterProduit extends Stage
{
	private ControllerAjouterProduit controler;
	
	public VueAjouterProduit() 
	{
		try 
		{
			final URL fxmlURL=getClass().getResource("/ajouter_produit.fxml");
	        
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox part = (VBox)fxmlLoader.load();
			Scene scene = new Scene(part);
			this.setScene(scene);
			
			this.initModality(Modality.APPLICATION_MODAL);
			this.setTitle("Page produits");
			this.getIcons().add(new Image("file:medias/black/pullover.png"));
			
			controler = fxmlLoader.getController();
			controler.setVue(this);
			
			this.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ControllerAjouterProduit getController()
	{
		  return (controler);
	}
}
	