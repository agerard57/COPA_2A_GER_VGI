package dao.listememoire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MySql.Connexion;
import categorie.Categorie;
import clients.Client;
import dao.CategorieDAO;

public class ListeMemoireCategorieDAO implements CategorieDAO{

	private static ListeMemoireCategorieDAO instance;

	private ArrayList<Categorie> donnees;

	public static ListeMemoireCategorieDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireCategorieDAO();
		}
       
		Categorie cat = new Categorie(1, "titre", "visuel");
		instance.create(cat);
		return (instance);
	}

	public ListeMemoireCategorieDAO() {
		donnees = new ArrayList<Categorie>();
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public boolean create(Categorie object) {
		object.setIdCategorie(1);
		while (donnees.indexOf(object) > -1)
		{
			object.setIdCategorie(object.getIdCategorie() + 1);
		}
		donnees.add(object);
		
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean update(Categorie object) {

		if (donnees.indexOf(object) < 0)
			return (false);
		else
			donnees.set(donnees.indexOf(object), object);
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean delete(Categorie object) {

		if (donnees.indexOf(object) < 0)
			return (false);
		else
			donnees.remove(donnees.indexOf(object));
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	public ArrayList<Categorie> findAll() {
		return (donnees);
	}


	@Override
	public Categorie getById(int id) {
		if (donnees.indexOf(new Categorie(id)) < 0)
			return (null);
		else
			return (donnees.get(donnees.indexOf(new Categorie(id))));
	}
}
