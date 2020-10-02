package clients;

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

public class ClientSQL {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ClientSQL() {
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public boolean ajouterClient(Client c) {
		Connexion connect = new Connexion();
		int i = 0;
		try {
			Connection connect1 = connect.creeConnexion();
			PreparedStatement requete = connect1.prepareStatement("INSERT INTO Client(nom, prenom, identifiant, mot_de_passe, adr_numero, adr_voie, adr_code_postal, adr_ville, adr_pays) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1,  c.getNom());
			requete.setString(2,  c.getPrenom());
			requete.setString(3,  c.getIdentifiant());
			requete.setString(4,  c.getMotDePasse());
			requete.setString(5,  c.getAdrNumero());
			requete.setString(6,  c.getAdrVoie());
			requete.setString(7,  c.getAdrCodePostal());
			requete.setString(8,  c.getAdrVille());
			requete.setString(9,  c.getAdrPays());

			i = requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();

			if ( res.next())
				c.setIdClient(res.getInt(1));

			connect1.close();
		}
		catch(SQLException sqle)
		{
			System.out.println("Erreur !");
		}
		return (i == 1);



	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public boolean update(Client objet) {
		
		Connexion c = new Connexion();
		int i = 0;
		
		try {
			Connection c1 = c.creeConnexion();
			
			PreparedStatement requete = c1.prepareStatement("UPDATE Client SET nom = ?, prenom = ? WHERE id_client = ?");
			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setInt(3, objet.getIdClient());
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



}
