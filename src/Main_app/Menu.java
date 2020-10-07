package Main_app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import categorie.Categorie;
import categorie.CategorieSQL;
import clients.Client;
import clients.ClientSQL;
import commandes.Commande;
import commandes.CommandeSQL;
import commandes.LigneDeCommande;
import commandes.LigneDeCommandeSQL;
import produits.Produit;
import produits.ProduitSQL;

public class Menu {
	protected static int selection;
	protected static ClientSQL clientBdD;
	protected static ProduitSQL produitBdD;


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("resource")


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void MenuAccueil() {
		do
		{
			System.out.println("Bienvenue dans la boutique des meilleurs pires pulls !");

			System.out.println("[1] Gestion des produits");
			System.out.println("[2] Gestion des categories");
			System.out.println("[3] Gestion des clients");
			System.out.println("[4] Quitter");	

			System.out.println("Utilisez le clavier numerique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//	LireConsole.close();


			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Gestion des produits||");
				Menu.MenuProduits(); //si on choisit "1", il va afficher le menu produit. Il fait ca pour tout le monde dans la'arborescence

				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Gestion des categories||");
				Menu.MenuCategories();
				break;	

			case 3 :
				System.out.println("Vous avez choisi : ||Gestion des clients||");
				Menu.MenuClient();
				break;	
				
			case 4 :
				System.out.println("Vous avez choisi : ||Gestion des commandes||");

			case 5 :
				System.out.println("--------GERARD-GIANGRECO--TP1-CPOA--------");
				System.exit(0);
				break;

			default :
				System.out.println ("La selection est incorrecte !");
			}
		} while (selection != 5);

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}


	public static void MenuClient() {
		ArrayList<Client> listeClient = new ArrayList<Client>();
		ClientSQL clientBdD = new ClientSQL();

		do
		{
			System.out.println("[1] Ajouter un client");
			System.out.println("[2] Supprimer un client");
			System.out.println("[3] Modifier un client");
			System.out.println("[4] Visualiser les clients");
			System.out.println("[5] Retour");

			System.out.println("Utilisez le clavier num�erique pour faire votre choix...");
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
				System.out.println("Vous avez choisi : ||Visualiser les cat�gories||");
				int c = 0;
				selection = 0;
				listeClient = clientBdD.findAll();
				while ( c < listeClient.size())
				{
					System.out.println(listeClient.get(c++));
				}
				Menu.MenuCategories();
				break;

			case 5 :
				System.out.println("Vous avez choisi : ||Retour||");
				Menu.MenuAccueil();
				break;

			default :
				System.out.println ("La selection est incorrecte !");
			}
		} while (selection != 5);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static void MenuAjouterClient() {
		String boeufHeure = new String();
		Client client = new Client();
		clientBdD = new ClientSQL();

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom : "); // on demande de saisir le nom puis on regarde si la selection est vide ou non. Si non, on l'affecte au nom d'un nouveau client
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ nom. ");
		}
		client.setNom(boeufHeure);
		System.out.println("Entrez le pr�nom : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ pr�nom. ");
		}
		client.setPrenom(boeufHeure);
		System.out.println("Entrez l'identifiant : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ identifiant. ");
		}
		client.setIdentifiant(boeufHeure);
		System.out.println("Entrez le mot de passe: ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ mot de passe. ");
		}
		client.setMotDePasse(boeufHeure);
		System.out.println("Entrez le numero de l'adresse : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ adresse. ");
		}
		client.setAdrNumero(boeufHeure);
		System.out.println("Entrez le nom de la rue : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ rue. ");
		}
		client.setAdrVoie(boeufHeure);
		System.out.println("Entrez le code postal : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ code postal. ");
		}
		client.setAdrCodePostal(boeufHeure);
		System.out.println("Entrez la ville : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ ville. ");
		}
		client.setAdrVille(boeufHeure);
		System.out.println("Entrez le pays : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ pays. ");
		}
		client.setAdrPays(boeufHeure);

		clientBdD.ajouterClient(client);
		Menu.MenuClient();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void MenuSupprimerClient() {
		ArrayList<Client> listeClient = new ArrayList<Client>();
		ClientSQL clientBdD = new ClientSQL();
		Scanner LireConsole = new Scanner(System.in);
		String boeufHeure;
		int selection;

		System.out.println("Quel client voulez vous supprimer ? ");
		int c = 0;
		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr
		listeClient = clientBdD.findAll();
		while ( c < listeClient.size())
		{
			System.out.println(listeClient.get(c++));
		}


		while (!LireConsole.hasNextInt())
		{
			System.out.println("Veuillez entrer l'ID du client.");
			boeufHeure = LireConsole.nextLine();
		}
		selection = LireConsole.nextInt();

		clientBdD.delete(listeClient.get(listeClient.indexOf(new Client(selection))));
		System.out.println("ID du client supprim� : " + selection);
		Menu.MenuClient();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static void MenuModifierClient() {
		int index = -1;
		ClientSQL clientBdD = new ClientSQL();
		Client client = new Client();
		Scanner sc = new Scanner(System.in);
		Scanner nouveauScannerDeTest = new Scanner(System.in);

		String boeufHeure = new String();
		ArrayList<Client> listeClient = new ArrayList<Client>();
		String selectionChangement;
		int selection = 0;
		int c = 0;

		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr
		listeClient = clientBdD.findAll();
		while ( c < listeClient.size())
		{
			System.out.println(listeClient.get(c++));
		}
		System.out.println("Quel client voulez vous modifier ? (entrez le champ \" id_client \") ");
		

		while (!sc.hasNextInt())
		{
			System.out.println("Veuillez entrer l'ID du client.");
			sc.nextLine();
		}
		
		selection = sc.nextInt(); 
		
		client = listeClient.get(listeClient.indexOf(new Client(selection)));
		// afficher la liste de clients et lui demander d'entrer un ID + message erreur


		//ClientSQL.ListeClient();
		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr

		System.out.println("Quel champ modifier ?");

		System.out.println(client);

		do
		{
			System.out.println("[1] Le nom");
			System.out.println("[2] Le prenom");
			System.out.println("[3] Retour");

			System.out.println("Utilisez le clavier numerique pour faire votre choix...");

			selection = sc.nextInt();
			selectionChangement = sc.nextLine();
			//LireConsole.close();
			switch(selection) {
			case 1:{

				System.out.println("Vous avez choisi : ||Le nom||");
				System.out.println("Entrez le nom : ");// on demande de saisir le nom puis on regarde si la selection est vide ou non. Si non, on l'affecte au nom d'un nouveau client
				System.out.println("1 : " + boeufHeure  + " : 1 " + selection + " : 2 " + selectionChangement + " : 3" );
				while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {
					System.out.println("2 : " +boeufHeure  + " : 1 " + selection + " : 2 " + selectionChangement + " : 3 " );

					System.out.println("Veuillez saisir le champ nom. ");
				}
				System.out.println("3 : " + boeufHeure  + " : 1 " + selection + " : 2 " + selectionChangement + " : 3" );

				client.setNom(boeufHeure);
				System.out.println(client);
				break;
			}


			case 2: {
				System.out.println("Vous avez choisi : ||Le prenom||");
				System.out.println("Entrez le pr�nom : ");
				while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {
					System.out.println("Veuillez saisir le champ pr�nom. ");
				}
				client.setPrenom(boeufHeure);
				break;

			}	
			case 3: {
				System.out.println("Vous avez choisi : ||Retour||");
				clientBdD.update(client);
				Menu.MenuClient();
				break;

			}
			default:  
				System.out.println ("La s�l�ction est incorrecte !");
				break;


			}
			System.out.println("fin while : " + client);
		}while (selection != 3);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static void MenuProduits() {
		ArrayList<Categorie> listeCategorie = new ArrayList<Categorie>();
		CategorieSQL categorieBdD = new CategorieSQL();
		do
		{
			System.out.println("[1] Ajouter un produit");
			System.out.println("[2] Supprimer un produit");
			System.out.println("[3] Modifier un produit");
			System.out.println("[4] Visualiser les produits");
			System.out.println("[5] Retour");

			System.out.println("Utilisez le clavier numerique pour faire votre choix...");
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
				Menu.MenuModifierProduit();
				break;	
			case 4 :
				System.out.println("Vous avez choisi : ||Visualiser les cat�gories||");
				int c = 0;
				selection = 0;
				listeCategorie = categorieBdD.findAll();
				while ( c < listeCategorie.size())
				{
					System.out.println(listeCategorie.get(c++));
				}
				Menu.MenuCategories();
				break;

			case 5 :
				System.out.println("Vous avez choisi : ||Retour||");
				Menu.MenuAccueil();
				break;

			default :
				System.out.println ("La selection est incorrecte !");
			}
		} while (selection != 5);

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void MenuAjouterProduit() {
		String boeufHeure = new String();
		Float boeufHeurefloat = null;
		int boeufHeureInt = 0;
		Produit produit = new Produit();
		ProduitSQL produitBdD = new ProduitSQL();
		Scanner sc = new Scanner(System.in);


		System.out.println("Entrez le nom : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ nom. ");
		}
		produit.setNom(boeufHeure);

		System.out.println("Entrez la description : ");
		while ((boeufHeure = sc.nextLine()).trim().equals(" ")) {
			System.out.println("Veuillez saisir la description. ");
		}
		produit.setDescription(boeufHeure);


		System.out.println("Entrez le visuel : ");
		while ((boeufHeure = sc.nextLine()).trim().equals(" ")) {
			System.out.println("Veuillez saisir le champ du visuel. ");
		}
		produit.setVisuel(boeufHeure);

		System.out.println("Entrez le tarif : ");
		while (!sc.hasNextFloat()) {
			System.out.println("Veuillez saisir le tarif. ");
			boeufHeure = sc.nextLine();
		}
		produit.setTarif(sc.nextFloat());

		System.out.println("Entrez le numero de la categorie : ");
		while (!sc.hasNextInt()) {
			System.out.println("Veuillez saisir le numero de la categorie. ");
			boeufHeure = sc.nextLine();
		}
		produit.setIdCategorie(sc.nextInt());

		produitBdD.ajouterProduit(produit);
		Menu.MenuProduits();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	private static void MenuSupprimerProduit() {
		ArrayList<Produit> listeProduit = new ArrayList<Produit>();
		ProduitSQL produitBdD = new ProduitSQL();
		Scanner LireConsole = new Scanner(System.in);
		String boeufHeure;
		int selection;

		System.out.println("Quel produit voulez vous supprimer ? ");
		int c = 0;
		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr
		listeProduit = produitBdD.findAll();
		while ( c < listeProduit.size())
		{
			System.out.println(listeProduit.get(c++));
		}


		while (!LireConsole.hasNextInt())
		{
			System.out.println("Veuillez entrer l'ID du produit.");
			boeufHeure = LireConsole.nextLine();
		}
		selection = LireConsole.nextInt();

		produitBdD.delete(listeProduit.get(listeProduit.indexOf(new Produit(selection))));
		System.out.println("ID du produit supprim� : " + selection);
		Menu.MenuProduits();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static void MenuModifierProduit() {
		int index = -1;
		ProduitSQL produitBdD = new ProduitSQL();
		Produit produit = new Produit();
		Scanner sc = new Scanner(System.in);
		Scanner nouveauScannerDeTest = new Scanner(System.in);

		String boeufHeure = new String();
		ArrayList<Produit> listeProduit = new ArrayList<Produit>();
		String selectionChangement;
		int selection = 0;
		int c = 0;

		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr
		listeProduit = produitBdD.findAll();
		while ( c < listeProduit.size())
		{
			System.out.println(listeProduit.get(c++));
		}
		System.out.println("Quel produit voulez vous modifier ? (entrez le champ \" id_produit \") ");
		

		while (!sc.hasNextInt())
		{
			System.out.println("Veuillez entrer l'ID du produit.");
			sc.nextLine();
		}
		
		selection = sc.nextInt(); 
		
		produit = listeProduit.get(listeProduit.indexOf(new Produit(selection)));
		// afficher la liste de clients et lui demander d'entrer un ID + message erreur


		//ClientSQL.ListeClient();
		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr

		System.out.println("Quel champ modifier ?");

		System.out.println(produit);

		do
		{
			
			System.out.println("[1] Le nom");
			System.out.println("[2] La description");
			System.out.println("[3] Le tarif");
			System.out.println("[4] Le visuel");
			System.out.println("[5] Retour");

			System.out.println("Utilisez le clavier numerique pour faire votre choix...");

			selection = sc.nextInt();
			selectionChangement = sc.nextLine();
			//LireConsole.close();
			switch(selection) {
			case 1:{

				System.out.println("Vous avez choisi : ||Le nom||");
				System.out.println("Entrez le nom : ");// on demande de saisir le nom puis on regarde si la selection est vide ou non. Si non, on l'affecte au nom d'un nouveau client
				while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {

					System.out.println("Veuillez saisir le champ nom. ");
				}

				produit.setNom(boeufHeure);
				break;
			}


			case 2: {
				System.out.println("Vous avez choisi : ||La description||");
				System.out.println("Entrez la description : ");
				while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {
					System.out.println("Veuillez saisir le champ description. ");
				}
				produit.setDescription(boeufHeure);
				break;

			}	
			case 3:{

				System.out.println("Vous avez choisi : ||Le tarif||");
				System.out.println("Entrez le tarif : ");// on demande de saisir le nom puis on regarde si la selection est vide ou non. Si non, on l'affecte au nom d'un nouveau client
				while (!sc.hasNextFloat()) {
					System.out.println("Veuillez saisir le tarif. ");
					boeufHeure = sc.nextLine();
				}
				
				produit.setTarif(sc.nextFloat());
				break;
			}
			case 4:{

				System.out.println("Vous avez choisi : ||Le visuel||");
				System.out.println("Entrez le visuel : ");// on demande de saisir le nom puis on regarde si la selection est vide ou non. Si non, on l'affecte au nom d'un nouveau client
				while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {

					System.out.println("Veuillez saisir le champ visuel. ");
				}

				produit.setVisuel(boeufHeure);
				break;
			}
			case 5: {
				System.out.println("Vous avez choisi : ||Retour||");
				produitBdD.update(produit);
				Menu.MenuProduits();
				break;

			}
			default:  
				System.out.println ("La s�l�ction est incorrecte !");
				break;


			}
		}while (selection != 5);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("resource")
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static void MenuCategories() {
		ArrayList<Categorie> listeCategories = new ArrayList<Categorie>();
		CategorieSQL categorieBdD = new CategorieSQL();
		do
		{
			System.out.println("[1] Ajouter une categorie");
			System.out.println("[2] Supprimer une categorie");
			System.out.println("[3] Modifier une categorie");
			System.out.println("[4] Visualiser les categories");
			System.out.println("[5] Retour");

			System.out.println("Utilisez le clavier numerique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//		LireConsole.close();

			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Ajouter une categorie||");
				Menu.MenuAjouterCategorie();
				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Supprimer une categorie||");
				Menu.MenuSupprimerCategorie();
				break;	

			case 3 :
				System.out.println("Vous avez choisi : ||Modifier une categorie||");
				Menu.MenuModifierCategorie();
				break;	
			case 4 :
				System.out.println("Vous avez choisi : ||Visualiser les cat�gories||");
				int c = 0;
				selection = 0;
				listeCategories = categorieBdD.findAll();
				while ( c < listeCategories.size())
				{
					System.out.println(listeCategories.get(c++));
				}
				Menu.MenuCategories();
				break;

			case 5 :
				System.out.println("Vous avez choisi : ||Retour||");
				Menu.MenuAccueil();
				break;

			default :
				System.out.println ("La selection est incorrecte !");
			}
		} while (selection != 5);

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	private static void MenuAjouterCategorie() {
		Categorie categorie = new Categorie();
		CategorieSQL categorieBdD = new CategorieSQL();
		String boeufHeure = new String();

		Scanner sc = new Scanner(System.in);


		System.out.println("Entrez le titre : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ titre. ");
		}
		categorie.setTitre(boeufHeure);


		System.out.println("Entrez le visuel : ");
		while ((boeufHeure = sc.nextLine()).trim().equals("")) {
			System.out.println("Veuillez saisir le champ visuel. ");
		}
		categorie.setVisuel(boeufHeure);

		categorieBdD.ajouterCategorie(categorie);
		Menu.MenuProduits();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	private static void MenuSupprimerCategorie() {
		ArrayList<Categorie> listeCategorie = new ArrayList<Categorie>();
		CategorieSQL categorieBdD = new CategorieSQL();
		Scanner LireConsole = new Scanner(System.in);
		String boeufHeure;
		int selection;

		System.out.println("Quel categorie voulez vous supprimer ? ");
		int c = 0;
		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr
		listeCategorie = categorieBdD.findAll();
		while ( c < listeCategorie.size())
		{
			System.out.println(listeCategorie.get(c++));
		}


		while (!LireConsole.hasNextInt())
		{
			System.out.println("Veuillez entrer l'ID de la categorie.");
			boeufHeure = LireConsole.nextLine();
		}
		selection = LireConsole.nextInt();

		categorieBdD.delete(listeCategorie.get(listeCategorie.indexOf(new Categorie(selection))));
		System.out.println("ID de la categorie supprim�e : " + selection);
		Menu.MenuCategories();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	private static void MenuModifierCategorie() {
			int index = -1;
			CategorieSQL categorieBdD = new CategorieSQL();
			Categorie categorie = new Categorie();
			Scanner sc = new Scanner(System.in);
			Scanner nouveauScannerDeTest = new Scanner(System.in);

			String boeufHeure = new String();
			ArrayList<Categorie> listeCategorie = new ArrayList<Categorie>();
			String selectionChangement;
			int selection = 0;
			int c = 0;

			//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr
			listeCategorie = categorieBdD.findAll();
			while ( c < listeCategorie.size())
			{
				System.out.println(listeCategorie.get(c++));
			}
			System.out.println("Quelle categorie voulez vous modifier ? (entrez le champ \" id_categorie \") ");
			

			while (!sc.hasNextInt())
			{
				System.out.println("Veuillez entrer l'ID de la categorie.");
				sc.nextLine();
			}
			
			selection = sc.nextInt(); 
			
			categorie = listeCategorie.get(listeCategorie.indexOf(new Categorie(selection)));
			// afficher la liste de clients et lui demander d'entrer un ID + message erreur


			//ClientSQL.ListeClient();
			//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr

			System.out.println("Quel champ modifier ?");

			System.out.println(categorie);

			do
			{
				System.out.println("[1] Le titre");
				System.out.println("[2] Le visuel");
				System.out.println("[3] Retour");

				System.out.println("Utilisez le clavier numerique pour faire votre choix...");

				selection = sc.nextInt();
				selectionChangement = sc.nextLine();
				//LireConsole.close();
				switch(selection) {
				case 1:{

					System.out.println("Vous avez choisi : ||Le titre||");
					System.out.println("Entrez le titre : ");// on demande de saisir le nom puis on regarde si la selection est vide ou non. Si non, on l'affecte au nom d'un nouveau client
					while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {

						System.out.println("Veuillez saisir le champ titre. ");
					}

					categorie.setTitre(boeufHeure);
					break;
				}


				case 2: {
					System.out.println("Vous avez choisi : ||Le visuel||");
					System.out.println("Entrez le visuel : ");
					while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {
						System.out.println("Veuillez saisir le champ visuel. ");
					}
					categorie.setVisuel(boeufHeure);
					break;

				}	
				case 3: {
					System.out.println("Vous avez choisi : ||Retour||");
					categorieBdD.update(categorie);
					Menu.MenuCategories();
					break;

				}
				default:  
					System.out.println ("La s�l�ction est incorrecte !");
					break;


				}
			}while (selection != 3);
		}

public static void MenuCommande() {
		ArrayList<Commande> listeCommande = new ArrayList<Commande>();
		CommandeSQL commandeBdD = new CommandeSQL();
		
		do
		{
			System.out.println("[1] Ajouter une commande");
			System.out.println("[2] Supprimer une commande");
			System.out.println("[3] Modifier une commande");
			System.out.println("[4] Visualiser les commandes");
			System.out.println("[5] Retour");

			System.out.println("Utilisez le clavier num�erique pour faire votre choix...");
			Scanner LireConsole = new Scanner(System.in);
			selection = LireConsole.nextInt();
			//		LireConsole.close();

			switch (selection)
			{

			case 1 :
				System.out.println("Vous avez choisi : ||Ajouter une commande||");
				Menu.MenuAjouterCommande();
				break;

			case 2 :
				System.out.println("Vous avez choisi : ||Supprimer une commande||");
				Menu.MenuSupprimerCommande();
				break;	

			case 3 :
				System.out.println("Vous avez choisi : ||Modifier une commande||");
				Menu.MenuModifierCommande();
				break;	
				
			case 4 :
				System.out.println("Vous avez choisi : ||Visualiser les commandes||");
				int c = 0;
				selection = 0;
				listeCommande = commandeBdD.findAll();
				while ( c < listeCommande.size())
				{
					System.out.println(listeCommande.get(c++));
				}

				Menu.MenuCommande();
				break;
				
			case 5 :
				System.out.println("Vous avez choisi : ||Retour||");
				Menu.MenuAccueil();
				break;

			default :
				System.out.println ("La selection est incorrecte !");
			}
		} while (selection != 5);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		public static void MenuAjouterCommande() {
		String boeufHeure = new String();
		ArrayList<Commande> listeCommande = new ArrayList<Commande>();
		Commande commande = new Commande();
		CommandeSQL commandeBdD = new CommandeSQL();
		Scanner LireConsole = new Scanner(System.in);
		ArrayList<Client> listeClient = new ArrayList<Client>();
		ClientSQL clientBdD = new ClientSQL();
		int c = 0;
		Scanner sc = new Scanner(System.in);
		
		
		
				listeClient = clientBdD.findAll();
				while ( c < listeClient.size())
				{
					System.out.println(listeClient.get(c++));
				}
				System.out.println("Pour quel client voulez vous ajouter une commande ? (entrez le champ \" id_produit \") ");

				while (!sc.hasNextInt())
				{
					System.out.println("Veuillez entrer l'ID du client.");
					sc.nextLine();
				}
				
				selection = sc.nextInt(); 
		commande.setIdClient(selection);
		commande.setDateCommande(LocalDate.now());
		
		commandeBdD.ajouterCommande(commande);
		Menu.MenuCommande();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void MenuSupprimerCommande() {
		ArrayList<Commande> listeCommande = new ArrayList<Commande>();
		CommandeSQL commandeBdD = new CommandeSQL();
		Scanner LireConsole = new Scanner(System.in);
		String boeufHeure;
		int selection;

		System.out.println("Quelle commande voulez vous supprimer ? ");
		int c = 0;
		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr
		listeCommande = commandeBdD.findAll();
		while ( c < listeCommande.size())
		{
			System.out.println(listeCommande.get(c++));
		}


		while (!LireConsole.hasNextInt())
		{
			System.out.println("Veuillez entrer l'ID de la commande.");
			boeufHeure = LireConsole.nextLine();
		}
		selection = LireConsole.nextInt();

		//commandeBdD.delete(listeCommande.get(listeCommande.indexOf(new Commande(selection))));
		System.out.println("ID de la commande supprim� : " + selection);
		Menu.MenuCommande();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static void MenuModifierCommande() {
		int index = -1;
		Commande commande = new Commande();
		CommandeSQL commandeBdD = new CommandeSQL();
		LigneDeCommandeSQL ligneDeCommandeBdD = new LigneDeCommandeSQL();

		Scanner sc = new Scanner(System.in);
		Scanner nouveauScannerDeTest = new Scanner(System.in);
		Scanner LireConsole = new Scanner(System.in);
		ArrayList<Produit> listeProduit = new ArrayList<Produit>();
		ProduitSQL produitBdD = new ProduitSQL();
		String boeufHeure = new String();
		LigneDeCommande ligneDeCommande = new LigneDeCommande();
		ArrayList<LigneDeCommande> listeLigneDeCommande = new ArrayList<LigneDeCommande>();

		ArrayList<Commande> listeCommande = new ArrayList<Commande>();
		String selectionChangement;
		int selection = 0;
		int c = 0;

		//pour supprimer un client, on les affiche tous et on selectionne un id qui permettra de le supr
		listeCommande = commandeBdD.findAll();
		while ( c < listeCommande.size())
		{
			System.out.println(listeCommande.get(c++));
		}
		System.out.println("Quelle commande voulez vous modifier ? (entrez le champ \" id_commande \") ");
		

		while (!sc.hasNextInt())
		{
			System.out.println("Veuillez entrer l'ID de la commande.");
			sc.nextLine();
		}
		
		selection = sc.nextInt(); 
		
		//commande = listeCommande.get(listeCommande.indexOf(new Commande(selection)));

		System.out.println("Que faut il modifier ?");

		do
		{
			System.out.println("[1] Ajouter une ligne de commande");
			System.out.println("[2] modifier une ligne de commande");
			System.out.println("[3] supprimer une ligne de commande");
			System.out.println("[4] Retour");

			System.out.println("Utilisez le clavier numerique pour faire votre choix...");

			selection = sc.nextInt();
			selectionChangement = sc.nextLine();
			//LireConsole.close();
			switch(selection) {
			case 1:{

				System.out.println("Vous avez choisi : ||Ajouter une ligne de commande||");
				System.out.println("Entrez l'ID du produit: ");
				listeProduit = produitBdD.findAll();
				while ( c < listeProduit.size())
				{
					System.out.println(listeProduit.get(c++));
				}


				while (!LireConsole.hasNextInt())
				{
					System.out.println("Veuillez entrer l'ID du produit.");
					boeufHeure = LireConsole.nextLine();
				}
				selection = LireConsole.nextInt();
			
				ligneDeCommande.setIdProduit(selection);
			//	ligneDeCommande.setTarifUnitaire(selection.IndexOf(tarifUnitaire));
				System.out.println("Entrez une quantite: ");

				while (!LireConsole.hasNextInt())
				{
					System.out.println("Veuillez entrer une quantite.");
					boeufHeure = LireConsole.nextLine();
				}
				selection = LireConsole.nextInt();
			
				ligneDeCommande.setQuantite(selection);
				
				System.out.println(ligneDeCommande);
				break;
			}


			case 2: {
				System.out.println("Vous avez choisi : ||modifier une ligne de commande||");
				while ( c < listeLigneDeCommande.size())
				{
					System.out.println(listeLigneDeCommande.get(c++));
				}
				System.out.println("Quelle commande voulez vous supprimer ? (entrez le champ \" id_categorie \") ");
				

				while (!sc.hasNextInt())
				{
					System.out.println("Veuillez entrer l'ID de la ligne de commande.");
					sc.nextLine();
				}
				
				selection = sc.nextInt(); 
				
				System.out.println("Entrez le pr�nom : ");
				while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {
					System.out.println("Veuillez saisir le champ pr�nom. ");
				}
				break;

			}	
			case 3: {
				System.out.println("Vous avez choisi : ||supprimer une ligne de commande||");
				System.out.println("Entrez le pr�nom : ");
				while ((boeufHeure = nouveauScannerDeTest.nextLine()).trim().equals("")) {
					System.out.println("Veuillez saisir le champ pr�nom. ");
					while ( c < listeLigneDeCommande.size())
					{
						System.out.println(listeLigneDeCommande.get(c++));
					}
					System.out.println("Quelle commande voulez vous supprimer ? (entrez le champ \" id_categorie \") ");
					

					while (!sc.hasNextInt())
					{
						System.out.println("Veuillez entrer l'ID de la ligne de commande.");
						sc.nextLine();
					}
					
					selection = sc.nextInt(); 
					//ligneDeCommandeBdD.delete(ligneDeCommandeBdD.get(ligneDeCommandeBdD.indexOf(new LigneDeCommande(selection))));
					System.out.println("ID de la categorie supprim�e : " + selection);
				}
				break;

			}	
			case 4: {
				System.out.println("Vous avez choisi : ||Retour||");
				commandeBdD.update(commande);
				ligneDeCommandeBdD.update(ligneDeCommande);
				Menu.MenuCommande();
				break;

			}
			default:  
				System.out.println ("La s�l�ction est incorrecte !");
				break;


			}
		}while (selection != 4);
	}

}