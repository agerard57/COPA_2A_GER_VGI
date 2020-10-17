package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import categorie.Categorie;
import dao.CategorieDAO;
import mysql.Connexion;

public class MySQLCategorieDAO implements CategorieDAO{
	private static MySQLCategorieDAO instance;

	public static MySQLCategorieDAO getInstance() {

		if (instance == null) {
			instance = new MySQLCategorieDAO();
		}

		return instance;
	}

	public MySQLCategorieDAO() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public boolean create(Categorie c) {
		Connexion connect = new Connexion();
		int i = 0;
		try {
			Connection connect1 = connect.creeConnexion();
			PreparedStatement requete = connect1.prepareStatement("INSERT INTO Categorie(titre, visuel) VALUES ( ?, ?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1,  c.getTitre());
			requete.setString(2,  c.getVisuel());


			requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();

			if (res.next())
				c.setIdCategorie(res.getInt(1));

			connect1.close();
			return (true);
		}
		catch(SQLException sqle)
		{
			System.out.println("Erreur !");
		}
		return (false);



	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean update(Categorie objet) {

		Connexion c = new Connexion();
		int i = 0;

		try {
			Connection c1 = c.creeConnexion();

			PreparedStatement requete = c1.prepareStatement("UPDATE Categorie SET titre = ?, visuel = ? WHERE id_categorie = ?");
			requete.setString(1, objet.getTitre());
			requete.setString(2, objet.getVisuel());
			requete.setInt(3, objet.getIdCategorie());
			i = requete.executeUpdate();

			c1.close();
		}
		catch (SQLException sqle) {
			System.out.println("Probleme update categorie");
		}

		return (i == 1);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean delete(Categorie objet) {

		Connexion c = new Connexion();
		int i = 0;

		try {
			Connection c1 = c.creeConnexion();

			PreparedStatement requete = c1.prepareStatement("DELETE FROM Categorie WHERE id_categorie = ? ");
			requete.setInt(1, objet.getIdCategorie());
			i = requete.executeUpdate();

			c1.close();
		}
		catch (SQLException sqle) {
			System.out.println("Probleme delete categorie");
		}

		return (i == 1);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	public ArrayList<Categorie> findAll() {
		Connexion c = new Connexion();
		ArrayList<Categorie> liste = new ArrayList<Categorie>();

		try {
			Connection c1 = c.creeConnexion();

			Statement requete = c1.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Categorie");
			while (res.next()) {

				liste.add(new Categorie(res.getInt(1), res.getString(2), res.getString(3)));

			}

			c1.close();
			res.close();
		}
		catch (SQLException sqle) {
			System.out.println("Problemes select * Categorie");
		}

		return (liste);
	}

	@Override
	public Categorie getById(int id) {
		Connexion c = new Connexion();
		Categorie categorie = null;
		try {
			Connection c1 = c.creeConnexion();

			Statement requete = c1.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Categorie WHERE id_categorie = " + id);
			while (res.next()) {

				categorie = new Categorie(res.getInt(1), res.getString(2), res.getString(3));
			}

			c1.close();
			res.close();
		}
		catch (SQLException sqle) {
			System.out.println("Problemes select * Categorie");
		}
		return categorie;
	}
}
