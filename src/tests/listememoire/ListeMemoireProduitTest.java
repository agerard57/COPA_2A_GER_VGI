package tests.listememoire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import clients.Client;
import dao.listememoire.ListeMemoireClientDAO;
import dao.listememoire.ListeMemoireProduitDAO;
import produits.Produit;

public class ListeMemoireProduitTest {

	@Test
	void testCreateProduit() {
		Produit produit = new Produit("nom", "description", 45, "visuel", 8);
		ListeMemoireProduitDAO.getInstance().create(produit);
		assertEquals(produit, ListeMemoireProduitDAO.getInstance().getById(produit.getIdProduit()));
	}
	@Test
	void testDeleteProduit() {
		Produit produit = new Produit("nom", "description", 36, "visuel", 9);
		ListeMemoireProduitDAO.getInstance().create(produit);
		ListeMemoireProduitDAO.getInstance().delete(produit);
		assertNull(ListeMemoireProduitDAO.getInstance().getById(produit.getIdProduit()));
		}
	@Test
	void testUpdateProduit() {
		Produit produit = new Produit("nom", "description", 36, "visuel", 9);
		ListeMemoireProduitDAO.getInstance().create(produit);
		produit.setDescription("description");
		produit.setNom("prenom");
		ListeMemoireProduitDAO.getInstance().update(produit);
		assertEquals(produit, ListeMemoireProduitDAO.getInstance().getById(produit.getIdProduit()));
	}
	
	@Test
	void testFindAll() {
		Produit produit = new Produit("nom", "description", 32, "visuel", 15);
		ListeMemoireProduitDAO.getInstance().create(produit);
		assertNotNull(ListeMemoireProduitDAO.getInstance().findAll());

	}
}
