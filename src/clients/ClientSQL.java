package clients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

import MySql.Connexion;

public class ClientSQL {

	public ClientSQL() {
	}

	public boolean ajouter(Client c) {
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
