package tests.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import commandes.LigneDeCommande;
import dao.listememoire.ListeMemoireLigneCommandeDAO;
import dao.mysql.MySQLigneCommandeDAO;

public class MySQLLigneCommandeTest {
	@Test
	void testCreateLigneCommande() {
		LigneDeCommande ligneDeCommande = new LigneDeCommande(16,14,14,15);
		MySQLigneCommandeDAO.getInstance().create(ligneDeCommande);
		assertEquals(ligneDeCommande, MySQLigneCommandeDAO.getInstance().getById(ligneDeCommande.getIdCommande(), ligneDeCommande.getIdProduit()));
		MySQLigneCommandeDAO.getInstance().delete(ligneDeCommande);
	}
	@Test
	void testDeleteLigneCommande() {
		LigneDeCommande ligneDeCommande = new LigneDeCommande(17,14,14,15);
		MySQLigneCommandeDAO.getInstance().create(ligneDeCommande);
		MySQLigneCommandeDAO.getInstance().delete(ligneDeCommande);
		assertNull(MySQLigneCommandeDAO.getInstance().getById(ligneDeCommande.getIdCommande(), ligneDeCommande.getIdProduit()));
		}
	@Test
	void testUpdateLigneCommande() {
		LigneDeCommande ligneDeCommande = new LigneDeCommande(18,14,14,15);
		MySQLigneCommandeDAO.getInstance().create(ligneDeCommande);
		ligneDeCommande.setIdProduit(25);
		ligneDeCommande.setQuantite(25);
		ligneDeCommande.setTarifUnitaire(25);
		MySQLigneCommandeDAO.getInstance().update(ligneDeCommande);
		assertEquals(ligneDeCommande, MySQLigneCommandeDAO.getInstance().getById(ligneDeCommande.getIdCommande(), ligneDeCommande.getIdProduit()));
		MySQLigneCommandeDAO.getInstance().delete(ligneDeCommande);
	}
	
	@Test
	void testFindAll() {
		LigneDeCommande ligneDeCommande = new LigneDeCommande(19,14,14,15);
		MySQLigneCommandeDAO.getInstance().create(ligneDeCommande);
		MySQLigneCommandeDAO.getInstance().delete(ligneDeCommande);
		assertNotNull(MySQLigneCommandeDAO.getInstance().findAll());

	}
}
