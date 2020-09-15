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
				
				
				switch (selection)
				{
				
				case 1 :
					test.choix1();
					break;
				case 2 :
					test.choix2();;
					break;				
				case 3 :
					test.choix3();
					break;				
				case 4 :
					System.out.println("----------------");
					System.exit(0);
					break;
					
				default :
					System.out.println ("La séléction est incorrecte !");
					}
				
				
			} while (selection != 4);
			

			
}}