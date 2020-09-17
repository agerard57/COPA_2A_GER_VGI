package MySql;

import java.sql.*;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {

    
	public Connection creeConnexion() {
		String url =
				"jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/gerard326u_CPOA2020";
		url += "?serverTimezone=Europe/Paris";
		String login = "gerard326u_appli";
		String pwd = "3630";
		Connection maConnexion = null;
		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}
	
}