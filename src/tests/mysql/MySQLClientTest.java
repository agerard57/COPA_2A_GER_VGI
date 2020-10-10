package tests.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import clients.Client;
import dao.listememoire.ListeMemoireClientDAO;
import dao.mysql.MySQLClientDAO;

public class MySQLClientTest {

	@Test
	void testCreateClient() {
		Client client = new Client("nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		MySQLClientDAO.getInstance().create(client);
		assertEquals(client, MySQLClientDAO.getInstance().getById(client.getIdClient()));
		MySQLClientDAO.getInstance().delete(client);
	}
		@Test
		void testDeleteClient() {
		Client client = new Client("nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		MySQLClientDAO.getInstance().create(client);
		MySQLClientDAO.getInstance().delete(client);
		assertNull(MySQLClientDAO.getInstance().getById(client.getIdClient()));
		}
	@Test
	void testUpdateClient() {
		Client client = new Client("nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		MySQLClientDAO.getInstance().create(client);
		client.setPrenom("nom");
		client.setNom("prenom");
		MySQLClientDAO.getInstance().update(client);
 		assertEquals(client, MySQLClientDAO.getInstance().getById(client.getIdClient()));
		MySQLClientDAO.getInstance().delete(client);

	}

	@Test
	void testFindAll() {
		Client client = new Client(" nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		MySQLClientDAO.getInstance().create(client);
		assertNotNull(MySQLClientDAO.getInstance().findAll());
		MySQLClientDAO.getInstance().delete(client);

	}
	@Test
	void testGetByNom() {
		Client client = new Client(" nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		MySQLClientDAO.getInstance().create(client);
		assertNotNull(MySQLClientDAO.getInstance().findAll());
		MySQLClientDAO.getInstance().delete(client);
	}
	@Test
	void testGetByNomPrenom() {
		Client client = new Client(" nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		MySQLClientDAO.getInstance().create(client);
		assertNotNull(MySQLClientDAO.getInstance().findAll());
		MySQLClientDAO.getInstance().delete(client);
	}


}
