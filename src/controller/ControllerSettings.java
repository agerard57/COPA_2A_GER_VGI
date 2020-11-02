package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import dao.factory.DAOFactory;
import enumz.ModeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerSettings 
{
	
	
	
 //-----------------------DECLARATION--------------------------
	
	
	
	private static DAOFactory daof;
	
	
	
 //--------------------------ITEMS------------------------------
	
	

    @FXML
    private ToggleGroup tgMode;
    @FXML
    private ToggleGroup tgTheme;

    
    @FXML
    private Button btnFermer;

    
    
 //--------------------------ACTIONS-----------------------------
    
    
    
    @FXML
    void fermerPage(ActionEvent event) 
    {
		Stage stage = (Stage) btnFermer.getScene().getWindow();
		stage.close();
    }
    

    
 //--------------------------MODE-------------------------------
    
    
    
    @FXML
    void modeBaseDeDonnees(ActionEvent event) 
    {
    	setDaof(DAOFactory.getDAOFactory(ModeDAO.MYSQL));
    }

    
    
    @FXML
    void modeListeMemoire(ActionEvent event) 
    {
    	setDaof(DAOFactory.getDAOFactory(ModeDAO.LISTE_MEMOIRE)); 
    }


    
	public static DAOFactory getDaof() 
	{
		return daof;
	}


	
	public static void setDaof(DAOFactory daof) 
	{
		ControllerSettings.daof = daof;
	}
	
	
	
 //--------------------------THEME------------------------------
    
    
    
    //TODO
    
    
    
    
 //--------------------------ABOUT------------------------------ 
    
    
    
    @FXML
    void pageGit(MouseEvent event) 
    {
    	try 
    	{
    	    Desktop.getDesktop().browse(new URL("https://github.com/agerard57/GERARD_GIANGRECO_CPOA_TD1_2020").toURI());
    	}
    	catch (IOException e) 
    	{
    	    e.printStackTrace();
    	}
    	catch (URISyntaxException e) 
    	{
    	    e.printStackTrace();
    	}

    }

   

    @FXML
    void pageTrello(MouseEvent event) 
    {
    	try 
    	{
    	    Desktop.getDesktop().browse(new URL("https://trello.com/b/DcAjprl2/cpoa2020gerardgiangreco").toURI());
    	}
    	catch (IOException e) 
    	{
    	    e.printStackTrace();
    	}
    	catch (URISyntaxException e) 
    	{
    	    e.printStackTrace();
    	}

    }
    
    
    
}

