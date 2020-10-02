package dao.listememoire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MySql.Connexion;
import commandes.Commande;
import commandes.LigneDeCommande;
import dao.CommandeDAO;

public class ListeMemoireCommandeDAO implements CommandeDAO{

	private static ListeMemoireClientDAO instance;

	private List<Commande> donnees;

	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return (instance);
	}
	
	public ListeMemoireCommandeDAO() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public boolean create(Commande commande) {
		Connexion connect = new Connexion();
		int i = 0;
		try {
			Connection connect1 = connect.creeConnexion();
			PreparedStatement requete = connect1.prepareStatement("INSERT INTO Commande(date_commande, id_client) VALUES ( ?, ?)", Statement.RETURN_GENERATED_KEYS);
			requete.setDate(1,  java.sql.Date.valueOf(commande.getDateCommande()));
			requete.setInt(2,  commande.getIdClient());


			i = requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();

			if ( res.next())
				commande.setIdCommande(res.getInt(1));

			connect1.close();
		}
		catch(SQLException sqle)
		{
			System.out.println("Erreur ajouter commande ");
		}
		return (i == 1);



	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean update(Commande commande) {

		Connexion c = new Connexion();
		int i = 0;

		try {
			Connection c1 = c.creeConnexion();

			PreparedStatement requete = c1.prepareStatement("UPDATE Commande SET date_commande = ?, id_client = ? WHERE id_commande = ?");
			requete.setDate(1,  java.sql.Date.valueOf(commande.getDateCommande()));
			requete.setInt(2, commande.getIdClient());
			requete.setInt(3, commande.getIdCommande());
			i = requete.executeUpdate();

			c1.close();
		}
		catch (SQLException sqle) {
			System.out.println("Probleme update commande");
		}

		return (i == 1);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean delete(Commande commande) {

		Connexion c = new Connexion();
		int i = 0;

		try {
			Connection c1 = c.creeConnexion();

			PreparedStatement requete = c1.prepareStatement("DELETE FROM Commande WHERE id_commande = ? ");
			requete.setInt(1, commande.getIdCommande());
			i = requete.executeUpdate();

			c1.close();
		}
		catch (SQLException sqle) {
			System.out.println("Probleme delete commande");
		}

		return (i == 1);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	public ArrayList<Commande> findAll() {
		Connexion c = new Connexion();
		ArrayList<Commande> liste = new ArrayList<Commande>();
		ArrayList<LigneDeCommande> listeLigne = new ArrayList<LigneDeCommande>();
		
		try {
			Connection c1 = c.creeConnexion();

			Statement requete = c1.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Commande");
			while (res.next()) {
				
				
				
				Statement requete2 = c1.createStatement();
				ResultSet res2 = requete2.executeQuery("SELECT * FROM Ligne_commande WHERE id_commande = " + res.getInt(1));
				listeLigne = new ArrayList<LigneDeCommande>();
				while (res2.next()) {
					listeLigne.add(new LigneDeCommande(res2.getInt(1),res2.getInt(2), res2.getInt(3), res2.getFloat(4)));
				}

				res2.close();
				
				
				
				liste.add(new Commande(res.getInt(1), res.getDate(2).toLocalDate(), res.getInt(3), listeLigne));

			}

			c1.close();
			res.close();
		}
		catch (SQLException sqle) {
			System.out.println("Problemes select * Commande");
		}

		return (liste);
	}


	@Override
	public ArrayList<Commande> getByNom(int id) {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

}
