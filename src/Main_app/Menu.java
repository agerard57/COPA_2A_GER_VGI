package Main_app;

import java.util.Scanner;

import clients.AjouterClient;
import clients.Client;
import clients.ModifierClient;

public class Menu {
	protected static int selection;


	public static void MenuAccueil() {
		do
		{
			System.out.println("Bienvenue dans la boutique des meilleurs pires pulls !");

			System.out.println("[1] Gestion des produits");
			System.out.println("[2] Gestion des commandes");
			System.out.println("[3] Gestion des clients");
			System.out.println("[4] Quitter");	

			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//	LireConsole.close();


			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Gestion des produits||");

				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Gestion des commandes||");
				break;	

			case 3 :
				System.out.println("Vous avez choisi : ||Gestion des clients||");
				Menu.MenuClient();
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


	public static void MenuClient() {

		do
		{
			System.out.println("[1] Ajouter un client");
			System.out.println("[2] Supprimer un client");
			System.out.println("[3] Modifier un client");
			System.out.println("[4] Retour");

			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//		LireConsole.close();

			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Ajouter un client||");
				Menu.MenuAjouterClient();
				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Supprimer un client||");
				Menu.MenuSupprimerClient();
				break;	

			case 3 :
				System.out.println("Vous avez choisi : ||Modifier un client||");
				Menu.MenuModifierClient();
				break;	
			case 4 :
				System.out.println("Vous avez choisi : ||Retour||");
				Menu.MenuAccueil();
				break;

			default :
				System.out.println ("La séléction est incorrecte !");
			}
			return;
		} while (selection != 4);
	}


	public static void MenuAjouterClient() {

		Client client = new Client();
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ nom. ");
		}
		client.setNom(sc.nextLine());
		System.out.println("Entrez le prénom : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ prénom. ");
		}
		client.setPrenom(sc.nextLine());
		System.out.println("Entrez l'identifiant : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ identifiant. ");
		}
		client.setIdentifiant(sc.nextLine());
		System.out.println("Entrezle mot de passe: ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ mot de passe. ");
		}
		client.setMotDePasse(sc.nextLine());
		System.out.println("Entrez le numéro de l'adresse : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ adresse. ");
		}
		client.setAdrNumero(sc.nextLine());
		System.out.println("Entrez le nom de la rue : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ rue. ");
		}
		client.setAdrVoie(sc.nextLine());
		System.out.println("Entrez le code postal : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ code postal. ");
		}
		client.setAdrCodePostal(sc.nextLine());
		System.out.println("Entrez la ville : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ ville. ");
		}
		client.setAdrVille(sc.nextLine());
		System.out.println("Entrez le pays : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ pays. ");
		}
		client.setAdrPays(sc.nextLine());
		
	}



	public static void MenuSupprimerClient() {
		System.out.println("Quel client voulez vous supprimer ? ");
	
	
	
	
	}

	public static void MenuModifierClient() {
		int selection = 0;
		System.out.println("Quel champ modifier ?");

		do
		{
			System.out.println("[1] Le nom");
			System.out.println("[2] Le prénom");
			System.out.println("[3] Retour");

			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//			LireConsole.close();

			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Le nom||");
				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Le prénom||");
				break;	
			case 3 :
				System.out.println("Vous avez choisi : ||Retour||");
				Menu.MenuClient();
				break;

			default :
				System.out.println ("La séléction est incorrecte !");
			}
			return;
		} while (selection != 3);
	}
}