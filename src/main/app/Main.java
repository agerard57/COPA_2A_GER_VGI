package main.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	
    private double xOffset = 0;
    private double yOffset = 0;
    
	 @Override
	    public void start(final Stage primaryStage) throws IOException {
	        primaryStage.initStyle(StageStyle.UNDECORATED);
			Parent root = FXMLLoader.load(this.getClass().getResource("/menu.fxml"));


	        root.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	            }
	        });

	        Scene scene = new Scene(root, 640, 400);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
		

	
	public static void main(String[] args){
		launch(Main.class, args);
		Menu.MenuAccueil();


	}
}