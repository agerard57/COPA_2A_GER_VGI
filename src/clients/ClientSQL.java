package clients;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.PreparableStatement;

import MySql.Connexion;

public class ClientSQL {

	public ClientSQL() {
	}
	public static void ListeClient() {

		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/gerard326u_CPOA2020";
		url += "?serverTimezone=Europe/Paris";
		String user = "gerard326u_appli";
		String password = "3630";

		String query = "SELECT * FROM Client";

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				int id_client = rs.getInt(1);
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				System.out.println("- " + id_client + " : " + nom + " " + prenom);
			}



		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(Connexion.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		System.out.println("Choisis !");
	}
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
			System.out.println("C KA C");
		}
		return (i == 1);



	}





}
