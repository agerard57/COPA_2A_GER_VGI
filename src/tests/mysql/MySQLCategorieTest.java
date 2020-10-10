package tests.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import categorie.Categorie;
import dao.listememoire.ListeMemoireCategorieDAO;
import dao.mysql.MySQLCategorieDAO;

public class MySQLCategorieTest {
	@Test
	void testCreateCategorie() {
		Categorie categorie = new Categorie("titre", "visuel");
		MySQLCategorieDAO.getInstance().create(categorie);
		assertEquals(categorie, MySQLCategorieDAO.getInstance().getById(categorie.getIdCategorie()));
		MySQLCategorieDAO.getInstance().delete(categorie);
	}
	@Test
	void testDeleteCategorie() {
		Categorie categorie = new Categorie("titre", "visuel");
		MySQLCategorieDAO.getInstance().create(categorie);
		MySQLCategorieDAO.getInstance().delete(categorie);
		assertNull(MySQLCategorieDAO.getInstance().getById(categorie.getIdCategorie()));
		}
	@Test
	void testUpdateCategorie() {
		Categorie categorie = new Categorie("titre", "visuel");
		MySQLCategorieDAO.getInstance().create(categorie);
		categorie.setVisuel("visuel");
		MySQLCategorieDAO.getInstance().update(categorie);
		assertEquals(categorie, MySQLCategorieDAO.getInstance().getById(categorie.getIdCategorie()));
		MySQLCategorieDAO.getInstance().delete(categorie);
	}
	
	@Test
	void testFindAll() {
		Categorie categorie = new Categorie("titre", "visuel");
		MySQLCategorieDAO.getInstance().create(categorie);
		MySQLCategorieDAO.getInstance().delete(categorie);
		assertNotNull(MySQLCategorieDAO.getInstance().findAll());

	}
}
