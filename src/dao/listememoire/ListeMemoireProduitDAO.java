package dao.listememoire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clients.Client;
import dao.ProduitDAO;
import mysql.Connexion;
import produits.Produit;
import java.util.List;


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
		
//		this.donnees.add(new Abonnement(2, 3, LocalDate.of(2019, 12, 12), LocalDate.of(2020, 12, 11)));
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
