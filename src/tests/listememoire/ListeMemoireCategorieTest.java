package tests.listememoire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import categorie.Categorie;
import clients.Client;
import dao.listememoire.ListeMemoireCategorieDAO;
import dao.listememoire.ListeMemoireClientDAO;

public class ListeMemoireCategorieTest {


	@Test
	void testCreateCategorie() {
		Categorie categorie = new Categorie("titre", "visuel");
		ListeMemoireCategorieDAO.getInstance().create(categorie);
		assertEquals(categorie, ListeMemoireCategorieDAO.getInstance().getById(categorie.getIdCategorie()));
	}
	@Test
	void testDeleteCategorie() {
		Categorie categorie = new Categorie("titre", "visuel");
		ListeMemoireCategorieDAO.getInstance().create(categorie);
		ListeMemoireCategorieDAO.getInstance().delete(categorie);
		assertNull(ListeMemoireCategorieDAO.getInstance().getById(categorie.getIdCategorie()));
		}
	@Test
	void testUpdateCategorie() {
		Categorie categorie = new Categorie("titre", "visuel");
		ListeMemoireCategorieDAO.getInstance().create(categorie);
		categorie.setVisuel("visuel");
		ListeMemoireCategorieDAO.getInstance().update(categorie);
		assertEquals(categorie, ListeMemoireCategorieDAO.getInstance().getById(categorie.getIdCategorie()));
	}
	
	@Test
	void testFindAll() {
		Categorie categorie = new Categorie("titre", "visuel");
		ListeMemoireCategorieDAO.getInstance().create(categorie);
		assertNotNull(ListeMemoireCategorieDAO.getInstance().findAll());

	}
}
