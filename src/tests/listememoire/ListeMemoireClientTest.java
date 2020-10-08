package tests.listememoire;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import clients.Client;
import dao.ClientDAO;
import dao.factory.DAOFactory;
import dao.listememoire.ListeMemoireClientDAO;
import enumz.ModeDAO;

class ListeMemoireClientTest {
	
	@Test
	void testCreateClient() {
		Client client = new Client(" nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		ListeMemoireClientDAO.getInstance().create(client);
		assertEquals(client, ListeMemoireClientDAO.getInstance().getById(client.getIdClient()));
	}
	@Test
	void testDeleteClient() {
		Client client = new Client(" nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		ListeMemoireClientDAO.getInstance().create(client);
		ListeMemoireClientDAO.getInstance().delete(client);
		assertNull(ListeMemoireClientDAO.getInstance().getById(client.getIdClient()));
		}
	@Test
	void testUpdateClient() {
		Client client = new Client(" nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		ListeMemoireClientDAO.getInstance().create(client);
		client.setPrenom("nom");
		client.setNom("prenom");
		ListeMemoireClientDAO.getInstance().update(client);
		assertEquals(client, ListeMemoireClientDAO.getInstance().getById(client.getIdClient()));
	}
	
	@Test
	void testFindAll() {
		Client client = new Client(" nom", " prenom", " identifiant", " motDePasse", " adrNumero", " adrVoie", " adrCodePostal", " adrVille", " adrPays");
		ListeMemoireClientDAO.getInstance().create(client);
		assertNotNull(ListeMemoireClientDAO.getInstance().findAll());

	}
}
