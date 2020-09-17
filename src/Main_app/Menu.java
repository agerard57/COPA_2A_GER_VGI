package Main_app;

import java.util.ArrayList;
import java.util.Scanner;

import clients.AjouterClient;
import clients.Client;
import clients.ClientSQL;
import clients.ModifierClient;

public class Menu {
	protected static int selection;


	public static void MenuAccueil() {
		do
		{
			System.out.println("Bienvenue dans la boutique des meilleurs pires pulls !");

			System.out.println("[1] Gestion des produits");
			System.out.println("[2] Gestion des catégories");
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
				Menu.MenuProduits();

				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Gestion des catégories||");
				Menu.MenuCategories();
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
				Menu.MenuModifierClient1();
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
		String boeufHeure = new String();
		Client client = new Client();

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ nom. ");
		}
		client.setNom(boeufHeure);
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
		System.out.println("Entrez le mot de passe: ");
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
		int index = -1;
		ArrayList<Client> listeClient = new ArrayList<Client>();
		ClientSQL clientBdD = new ClientSQL();
		System.out.println("Quel client voulez vous supprimer ? ");
		int c = 0;
		
		listeClient = clientBdD.findAll();
		while ( c < listeClient.size())
		{
			System.out.println(listeClient.get(c));
			c++;
		}

		//faire la saisie de l'index 
		clientBdD.delete(listeClient.get(listeClient.indexOf(new Client(index))));

	}


	public static void MenuModifierClient1() {
		System.out.println("Quel client voulez vous modifer ?(entrez le champ \" id_client \") ");
		//ClientSQL.ListeClient();
		Menu.MenuModifierClient2();
		
}

	public static void MenuModifierClient2() {
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
	
	public static void MenuProduits() {
		do
		{
			System.out.println("[1] Ajouter un produit");
			System.out.println("[2] Supprimer un produit");
			System.out.println("[3] Modifier un produit");
			System.out.println("[4] Retour");

			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//		LireConsole.close();

			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Ajouter un produit||");
				Menu.MenuAjouterProduit();
				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Supprimer un produit||");
				Menu.MenuSupprimerProduit();
				break;	

			case 3 :
				System.out.println("Vous avez choisi : ||Modifier un produit||");
				Menu.MenuModifierProduit1();
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


	private static void MenuAjouterProduit() {
	/*	Produit produit = new Produit();

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ nom. ");
		}
		produit.setNom(sc.nextLine());
		System.out.println("Entrez la description : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ description. ");
		}
		produit.setDescription(sc.nextLine());
		System.out.println("Entrez le tarif : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ tarif. ");
		}
		produit.setTarif(sc.nextLine());
		System.out.println("Entrez le visuel: ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ visuel. ");
		}
		produit.setVisuel(sc.nextLine());
		System.out.println("Entrez le nom de la catégorie: ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ catégorie. ");
		}
		produit.setCategorie(sc.nextLine());

		*/
			}


	private static void MenuSupprimerProduit() {
		System.out.println("Quel client voulez vous supprimer ? ");
		//ClientSQL.ListeClient();
		
	}

	private static void MenuModifierProduit1() {
		System.out.println("Quel client voulez vous modifer ?(entrez le champ \" id_client \" ");
		//ClientSQL.ListeClient();
		Menu.MenuModifierClient2();		
	}
	
	private static void MenuModifierProduit2() {
		int selection = 0;
		System.out.println("Quel champ modifier ?");

		do
		{
			System.out.println("[1] Le nom");
			System.out.println("[2] La description");
			System.out.println("[3] Le tarif");
			System.out.println("[4] Le visuel");
			System.out.println("[5] La catégorie");
			System.out.println("[6] Retour");

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
				System.out.println("Vous avez choisi : ||La description||");
				break;	
			case 3 :
				System.out.println("Vous avez choisi : ||Le tarif||");
				break;	
			case 4 :
				System.out.println("Vous avez choisi : ||Le visuel||");
				break;	
			case 5 :
				System.out.println("Vous avez choisi : ||La catégorie||");
				break;
			case 6 :
				System.out.println("Vous avez choisi : ||Retour||");
				Menu.MenuProduits();
				break;

			default :
				System.out.println ("La séléction est incorrecte !");
			}
			return;
		} while (selection != 6);
		
	}
	public static void MenuCategories() {
		do
		{
			System.out.println("[1] Ajouter une catégorie");
			System.out.println("[2] Supprimer une catégorie");
			System.out.println("[3] Modifier une catégorie");
			System.out.println("[4] Retour");

			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//		LireConsole.close();

			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Ajouter une catégorie||");
				Menu.MenuAjouterCategorie();
				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Supprimer une catégorie||");
				Menu.MenuSupprimerCategorie();
				break;	

			case 3 :
				System.out.println("Vous avez choisi : ||Modifier une catégorie||");
				Menu.MenuModifierCategorie1();
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
	private static void MenuAjouterCategorie() {
		/*Categorie categorie = new Categorie();

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le titre : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ titre. ");
		}
		categorie.setTitre(sc.nextLine());
		System.out.println("Entrez le visuel : ");
		while (sc.nextLine().trim().equals("")) {
			System.out.println("Veuillez saisir le champ visuel. ");
		}
		categorie.setVisuel(sc.nextLine());
		}*/
	}

	private static void MenuSupprimerCategorie() {
		System.out.println("Quelle catégorie voulez vous supprimer ? ");
		//ClientSQL.ListeClient();
				
	}

	private static void MenuModifierCategorie1() {
		System.out.println("Quel client voulez vous modifer ?(entrez le champ \" id_client \" ");
		//ClientSQL.ListeClient();
		Menu.MenuModifierClient2();				
	}
	
	private static void MenuModifierCategorie2() {
		int selection = 0;
		System.out.println("Quel champ modifier ?");

		do
		{
			System.out.println("[1] Le titre");
			System.out.println("[2] La visuel");
			System.out.println("[3] Retour");

			System.out.println("Utilisez le clavier numérique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//			LireConsole.close();

			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Le titre||");
				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Le visuel||");
				break;	
			case 3 :
				System.out.println("Vous avez choisi : ||Retour||");
				Menu.MenuProduits();
				break;

			default :
				System.out.println ("La séléction est incorrecte !");
			}
			return;
		} while (selection != 3);		
	}




}