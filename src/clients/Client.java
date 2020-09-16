package clients;

import java.util.Scanner;

import Main_app.Choix;

public class Client {
	protected int idClient;
	protected String nom;
	protected String prenom;
	protected String identifiant;
	protected String motDePasse;
	protected String adrNumero;
	protected String adrVoie;
	protected String adrCodePostal;
	protected String adrVille;
	protected String adrPays;
	
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getAdrNumero() {
		return adrNumero;
	}

	public void setAdrNumero(String adrNumero) {
		this.adrNumero = adrNumero;
	}

	public String getAdrVoie() {
		return adrVoie;
	}

	public void setAdrVoie(String adrVoie) {
		this.adrVoie = adrVoie;
	}

	public String getAdrCodePostal() {
		return adrCodePostal;
	}

	public void setAdrCodePostal(String adrCodePostal) {
		this.adrCodePostal = adrCodePostal;
	}

	public String getAdrVille() {
		return adrVille;
	}

	public void setAdrVille(String adrVille) {
		this.adrVille = adrVille;
	}

	public String getAdrPays() {
		return adrPays;
	}

	public void setAdrPays(String adrPays) {
		this.adrPays = adrPays;
	}

	public static int getSelection() {
		return selection;
	}

	public static void setSelection(int selection) {
		Client.selection = selection;
	}



	
	
	
	
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

public Client() {
}


	public Client( String nom, String prenom, int identifiant) {
		super(); // appeler le constructeur de la classe dont tu hérites
		this.nom = nom;
		this.prenom = prenom;
	
}

	public static void Choixmenu() {
	}



@Override
public boolean equals(Object o) {
	Client c = (Client) o ;
	if ( o == null )
		return false;
	else 
		return this.identifiant == c.identifiant;
}

}

