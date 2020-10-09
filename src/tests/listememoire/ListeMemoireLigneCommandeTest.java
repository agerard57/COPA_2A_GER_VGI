package tests.listememoire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import clients.Client;
import commandes.LigneDeCommande;
import dao.listememoire.ListeMemoireClientDAO;
import dao.listememoire.ListeMemoireLigneCommandeDAO;

public class ListeMemoireLigneCommandeTest {

	@Test
	void testCreateLigneCommande() {
		LigneDeCommande ligneDeCommande = new LigneDeCommande(14,14,15);
		ListeMemoireLigneCommandeDAO.getInstance().create(ligneDeCommande);
		assertEquals(ligneDeCommande, ListeMemoireLigneCommandeDAO.getInstance().getById(ligneDeCommande.getIdCommande()));
	}
	@Test
	void testDeleteLigneCommande() {
		LigneDeCommande ligneDeCommande = new LigneDeCommande(14,14,15);
		ListeMemoireLigneCommandeDAO.getInstance().create(ligneDeCommande);
		ListeMemoireLigneCommandeDAO.getInstance().delete(ligneDeCommande);
		assertNull(ListeMemoireLigneCommandeDAO.getInstance().getById(ligneDeCommande.getIdCommande()));
		}
	@Test
	void testUpdateLigneCommande() {
		LigneDeCommande ligneDeCommande = new LigneDeCommande(14,14,15);
		ListeMemoireLigneCommandeDAO.getInstance().create(ligneDeCommande);
		ligneDeCommande.setIdProduit(25);
		ligneDeCommande.setQuantite(25);
		ligneDeCommande.setTarifUnitaire(25);
		ListeMemoireLigneCommandeDAO.getInstance().update(ligneDeCommande);
		assertEquals(ligneDeCommande, ListeMemoireLigneCommandeDAO.getInstance().getById(ligneDeCommande.getIdCommande()));
	}
	
	@Test
	void testFindAll() {
		LigneDeCommande ligneDeCommande = new LigneDeCommande(14,14,15);
		ListeMemoireLigneCommandeDAO.getInstance().create(ligneDeCommande);
		assertNotNull(ListeMemoireLigneCommandeDAO.getInstance().findAll());

	}
}
