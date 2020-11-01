package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clients.Client;
import dao.ClientDAO;
import mysql.Connexion;

public class MySQLClientDAO implements ClientDAO{
	
	private static MySQLClientDAO instance;

	public static MySQLClientDAO getInstance() {

		if (instance == null) {
			instance = new MySQLClientDAO();
		}

		return instance;
	}
	
	public MySQLClientDAO() {
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public boolean create(Client c) {
		Connexion connect = new Connexion();
		@SuppressWarnings("unused")
		int i = 0;
		try {
			System.out.println("dans le try debut");
			Connection connect1 = connect.creeConnexion();
			System.out.println("apres le connect");
			PreparedStatement requete = connect1.prepareStatement("INSERT INTO Client(nom, prenom, identifiant, mot_de_passe, adr_numero, adr_voie, adr_code_postal, adr_ville, adr_pays) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			System.out.println("apres prepared ");
			requete.setString(1,  c.getNom());
			requete.setString(2,  c.getPrenom());
			requete.setString(3,  c.getIdentifiant());
			requete.setString(4,  c.getMotDePasse());
			requete.setString(5,  c.getAdrNumero());
			requete.setString(6,  c.getAdrVoie());
			requete.setString(7,  c.getAdrCodePostal());
			requete.setString(8,  c.getAdrVille());
			requete.setString(9,  c.getAdrPays());

			System.out.println("avant execute");
			System.out.println(c);
			
			requete.executeUpdate();
			System.out.println("avant reuslset");
			ResultSet res = requete.getGeneratedKeys();

			if ( res.next())
				c.setIdClient(res.getInt(1));
			System.out.println(c);
			connect1.close();
			return true;
		}
		catch(SQLException sqle)
		{
			System.out.println("Erreur !");
		}
		return (false);



	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public boolean update(Client objet) {
		
		Connexion c = new Connexion();
		int i = 0;
		
		try {
			Connection c1 = c.creeConnexion();
			
			PreparedStatement requete = c1.prepareStatement("UPDATE Client SET nom = ?, prenom = ?, identifiant = ?, mot_de_passe = ?, adr_numero = ?, adr_voie = ?, adr_code_postal = ?, adr_ville = ?, adr_pays = ? WHERE id_client = ?");
			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, objet.getIdentifiant());
			requete.setString(4, objet.getMotDePasse());
			requete.setString(5, objet.getAdrNumero());
			requete.setString(6, objet.getAdrVoie());
			requete.setString(7, objet.getAdrCodePostal());
			requete.setString(8, objet.getAdrVille());
			requete.setString(9, objet.getAdrPays());
			requete.setInt(10, objet.getIdClient());
			i = requete.executeUpdate();
			
			c1.close();
		}
		catch (SQLException sqle) {
			System.out.println("Probleme update client");
		}
		
		return (i == 1);
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean delete(Client objet) {
		
		Connexion c = new Connexion();
		int i = 0;
		
		try {
			Connection c1 = c.creeConnexion();
			
			PreparedStatement requete = c1.prepareStatement("DELETE FROM Client WHERE id_client = ? ");
			requete.setInt(1, objet.getIdClient());
			i = requete.executeUpdate();
			
			c1.close();
		}
		catch (SQLException sqle) {
			System.out.println("Probleme delete client");
		}
		
		return (i == 1);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	public ArrayList<Client> findAll() {
		Connexion c = new Connexion();
		ArrayList<Client> liste = new ArrayList<Client>();

		try {
			Connection c1 = c.creeConnexion();
			
			Statement requete = c1.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Client");
			while (res.next()) {

				liste.add(new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10)));
			}
			
			c1.close();
			res.close();
		}
		catch (SQLException sqle) {
			System.out.println("Problemes select * Client");
		}
		
		return (liste);
	}

	@Override
	public Client getById(int id) {
		Connexion c = new Connexion();
		Client client = null;
		try {
			Connection c1 = c.creeConnexion();

			Statement requete = c1.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Client WHERE id_client = " + id);
			while (res.next()) {

				client = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10));
			}

			c1.close();
			res.close();
		}
		catch (SQLException sqle) {
			System.out.println("Problemes select * Client");
		}
		return client;
	}

	@Override
	public ArrayList<Client> getByNom(String nom) {
		Connexion c = new Connexion();
		ArrayList<Client> liste = new ArrayList<Client>();

		try {
			Connection c1 = c.creeConnexion();
			
			Statement requete = c1.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Client WHERE nom = " + nom);
			while (res.next()) {

				liste.add(new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10)));
			}
			
			c1.close();
			res.close();
		}
		catch (SQLException sqle) {
			System.out.println("Problemes select * Client");
		}
		
		return (liste);
	}

	@Override
	public ArrayList<Client> getByNomPrenom(String nom, String prenom) {
		Connexion c = new Connexion();
		ArrayList<Client> liste = new ArrayList<Client>();

		try {
			Connection c1 = c.creeConnexion();
			
			Statement requete = c1.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Client WHERE nom = " + nom + " AND prenom = " + prenom);
			while (res.next()) {

				liste.add(new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10)));
			}
			
			c1.close();
			res.close();
		}
		catch (SQLException sqle) {
			System.out.println("Problemes select * Client");
		}
		
		return (liste);
	}

}
