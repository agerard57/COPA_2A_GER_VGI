package Main_app;

import java.util.Scanner;

import clients.Client;

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
				System.out.println("[1] Gestion des produits");
				System.out.println("[2] Gestion des commandes");
				System.out.println("[3] Gestion des clients");
				System.out.println("[4] Quitter");	
				
			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
//			LireConsole.close();
				
				switch (selection)
				{
				
				case 1 :
					Choix.choixAccueil1();
					break;
					
				case 2 :
					Choix.choixAccueil2();;
					break;	
					
				case 3 :
					Choix.choixAccueil3();
					Client.Menu();
					break;	
					
				case 4 :
					System.out.println("--------GERARD-GIANGRECO--TP1-CPOA--------");
					System.exit(0);
					break;
					
				default :
					System.out.println ("La séléction est incorrecte !");
					}
				return;
			} while (selection != 4);
			
		
			
}
	}