package clients;

import java.util.Scanner;

import Main_app.Choix;

public class Client {
	protected String nom;
	protected String prenom;
	protected int identifiant;
	protected static int selection;

 public static void Menu() {
		System.out.println("hello");

		do
		{
			System.out.println("[1] Ajouter un client");
			System.out.println("[2] Supprimer un client");
			System.out.println("[3] Modifier un client");
			
		System.out.println("Utilisez le clavier numérique pour faire votre choix...");
		Scanner LireConsole = new Scanner(System.in);
		selection = LireConsole.nextInt();
//		LireConsole.close();
			
			switch (selection)
			{
			
			case 1 :
				Choix.choixMenuClient1();
				break;
				
			case 2 :
				Choix.choixMenuClient2();;
				break;	
				
			case 3 :
				Choix.choixMenuClient3();
				ModifierClient.MenuModifierClient();
				break;	
				
			default :
				System.out.println ("La séléction est incorrecte !");
				}
			return;
		} while (selection != 3);
 }



	public Client( String nom, String prenom, int identifiant) {
		super(); // appeler le constructeur de la classe dont tu hérites
		this.nom = nom;
		this.prenom = prenom;
	
}

	public static void Choixmenu() {
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	public int getIdentifiant() {
		return identifiant;
	}
	
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}




}

