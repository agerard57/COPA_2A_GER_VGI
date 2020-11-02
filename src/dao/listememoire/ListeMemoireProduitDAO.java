package dao.listememoire;

import java.util.ArrayList;

import dao.ProduitDAO;
import produits.Produit;


public class ListeMemoireProduitDAO implements ProduitDAO{

	
	private static ListeMemoireProduitDAO instance;

	private ArrayList<Produit> donnees;

	public static ListeMemoireProduitDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireProduitDAO();
		}

		return (instance);
	}

	private ListeMemoireProduitDAO() {
		
		donnees = new ArrayList<Produit>();
		
		donnees.add(new Produit(1,"Sonic","Pull Sonic de noel",(float) 20.0,"/visuels/produit/pull1.png", 1));
		donnees.add(new Produit(2,"Star Wars","Pull \"je suis ton pere\"",(float) 30.0,"/visuels/produit/pull2.png", 1));
	   	donnees.add(new Produit(3,"Classique","Le grand classique", (float) 15.0,"/visuels/produit/pull3.png", 1));
	   	donnees.add(new Produit(4,"Les chaussettes nez ","Chaussettes avec des rennes et leur nez",(float) 14.0,"/visuels/produit/socks1.png", 2));
	   	donnees.add(new Produit(5,"Le bonnet festif ","Bonnet du papi Noël endiablant les fêtes de fin d'année ! ",(float) 8.0,"/visuels/produit/bonnet1.png", 3));
	}
	

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	public boolean create(Produit object) {
		object.setIdProduit(1);
		while (donnees.indexOf(object) > -1)
		{
			object.setIdProduit(object.getIdProduit() + 1);
		}
		donnees.add(object);
		
		return (true);
	}
	
	
public boolean update(Produit object) {
		
	if (donnees.indexOf(object) < 0)
		return (false);
	else
		donnees.set(donnees.indexOf(object), object);
	return (true);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
public boolean delete(Produit object) {
		
	if (donnees.indexOf(object) < 0)
		return (false);
	else
		donnees.remove(donnees.indexOf(object));
	return (true);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	public ArrayList<Produit> findAll() {
		return (donnees);
	}


@Override
public Produit getById(int id) {
	if (donnees.indexOf(new Produit(id)) < 0)
		return (null);
	else
		return (donnees.get(donnees.indexOf(new Produit(id))));
}


}
