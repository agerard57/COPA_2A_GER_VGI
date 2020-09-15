package MySql;

import java.sql.*;

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