package Main_app;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(this.getClass().getResource("/menu.fxml"));
		
		stage.setScene(new Scene (root));
		stage.show();
}
	
	public static void Main(String[] args){
		launch(Main.class, args);
		Menu.MenuAccueil();


	}
}