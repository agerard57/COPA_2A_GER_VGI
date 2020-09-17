package produits;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.PreparableStatement;

import MySql.Connexion;

public class ProduitSQL {

	public ProduitSQL() {
	}

	public boolean ajouterProduit(Produit p) {
		Connexion connect = new Connexion();
		int i = 0;
		try {
			Connection connect1 = connect.creeConnexion();
			PreparedStatement requete = connect1.prepareStatement("INSERT INTO Produit(nom, description, tarif, visuel, id_categorie) VALUES ( ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1,  p.getNom());
			requete.setString(2,  p.getDescr());
			requete.setString(3,  p.getTarif());
			requete.setString(4,  p.getVisuel());
			requete.setString(5,  p.getCat());


			i = requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();

			if ( res.next())
				p.setIdProduit(res.getInt(1));

			connect1.close();
		}
		catch(SQLException sqle)
		{
			System.out.println("Erreur !");
		}
		return (i == 1);



	}
public boolean delete(Produit objet) {
		
		Connexion c = new Connexion();
		int i = 0;
		
		try {
			Connection c1 = c.creeConnexion();
			
			PreparedStatement requete = c1.prepareStatement("DELETE FROM Produit WHERE id_produit = ? ");
			requete.setInt(1, objet.getIdProduit());
			i = requete.executeUpdate();
			
			c1.close();
		}
		catch (SQLException sqle) {
			System.out.println("Probleme delete produit");
		}
		
		return (i == 1);
	}


	public ArrayList<Produit> findAll() {
		Connexion c = new Connexion();
		ArrayList<Produit> liste = new ArrayList<Produit>();

		try {
			Connection c1 = c.creeConnexion();
			
			Statement requete = c1.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Produit");
			while (res.next()) {

				liste.add(new Produit(res.getInt(1), res.getString(2), res.getString(3), res.getFloat(4), res.getString(5), res.getInt(6)));

			}
			
			c1.close();
		}
		catch (SQLException sqle) {
			System.out.println("Problemes select * produit");
		}
		
		return (liste);
	}



}
