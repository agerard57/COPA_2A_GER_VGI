package Main_app;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
 
	public static void main(String[] args) {
		
			System.out.println("Bienvenue dans la boutique des meilleurs pires pulls !");
			
			int selection = 0;
			
			do
			{
				System.out.println("[1] Choix du produit");
				System.out.println("[2] Gestion de la commande");
				System.out.println("[3] Paramètres clients");
				System.out.println("[4] Quitter");	
				
			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
//			LireConsole.close();
				
				
				switch (selection)
				{
				
				case 1 :
					test.choix1();
					break;
				case 2 :
				    clearScreen();  
					test.choix2();;
					break;				
				case 3 :
					test.choix3();
					break;				
				case 4 :
					System.out.println("--------GERARD-GIANGRECO--TP1-CPOA--------");
					System.exit(0);
					break;
					
				default :
					System.out.println ("La séléction est incorrecte !");
					}
				
				
			} while (selection != 4);
			

			
}
	
	public static void clearScreen() {   
	    System.out.print("\033[H\033[2J");   
	    System.out.flush();   
	   } 
	}