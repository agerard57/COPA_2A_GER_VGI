package tests.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import dao.listememoire.ListeMemoireProduitDAO;
import dao.mysql.MySQLProduitDAO;
import produits.Produit;

public class MySQLProduitTest {
	@Test
	void testCreateProduit() {
		Produit produit = new Produit("nom", "description", 45, "visuel", 8);
		MySQLProduitDAO.getInstance().create(produit);
		MySQLProduitDAO.getInstance().delete(produit);
		assertEquals(produit, MySQLProduitDAO.getInstance().getById(produit.getIdProduit()));
	}
	@Test
	void testDeleteProduit() {
		Produit produit = new Produit("nom", "description", 36, "visuel", 9);
		MySQLProduitDAO.getInstance().create(produit);
		MySQLProduitDAO.getInstance().delete(produit);
		assertNull(MySQLProduitDAO.getInstance().getById(produit.getIdProduit()));
		}
	@Test
	void testUpdateProduit() {
		Produit produit = new Produit("nom", "description", 36, "visuel", 9);
		MySQLProduitDAO.getInstance().create(produit);
		produit.setDescription("description");
		produit.setNom("prenom");
		MySQLProduitDAO.getInstance().update(produit);
		MySQLProduitDAO.getInstance().delete(produit);
		assertEquals(produit, MySQLProduitDAO.getInstance().getById(produit.getIdProduit()));
	}
	
	@Test
	void testFindAll() {
		Produit produit = new Produit("nom", "description", 32, "visuel", 15);
		MySQLProduitDAO.getInstance().create(produit);
		MySQLProduitDAO.getInstance().delete(produit);
		assertNotNull(MySQLProduitDAO.getInstance().findAll());

	}
}
