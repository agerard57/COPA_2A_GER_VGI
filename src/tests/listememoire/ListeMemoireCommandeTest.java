package tests.listememoire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import commandes.Commande;
import commandes.LigneDeCommande;
import dao.listememoire.ListeMemoireCommandeDAO;

public class ListeMemoireCommandeTest {
	ArrayList<LigneDeCommande> listeLigneDeCommande = new ArrayList<LigneDeCommande>();
	LocalDate ldate1 = LocalDate.of(2016,Month.MARCH,29);
	LocalDate ldate2 = LocalDate.of(2017,Month.MARCH,29);
	LocalDate ldate3 = LocalDate.of(2018,Month.MARCH,29);
	LocalDate ldate4 = LocalDate.of(2019,Month.MARCH,29);

	@Test
	void testCreateCommande() {
		Commande commande = new Commande( ldate2 ,8,listeLigneDeCommande);
		ListeMemoireCommandeDAO.getInstance().create(commande);
		assertEquals(commande, ListeMemoireCommandeDAO.getInstance().getById(commande.getIdCommande()));
	}
	@Test
	void testDeleteCommande() {
		Commande commande = new Commande(ldate1,8,listeLigneDeCommande);
		ListeMemoireCommandeDAO.getInstance().create(commande);
		ListeMemoireCommandeDAO.getInstance().delete(commande);
		assertNull(ListeMemoireCommandeDAO.getInstance().getById(commande.getIdCommande()));
		}
	@Test
	void testUpdateCommande() {
		Commande commande = new Commande(ldate3,8,listeLigneDeCommande);
		ListeMemoireCommandeDAO.getInstance().create(commande);
		commande.setIdClient(14);
		ListeMemoireCommandeDAO.getInstance().update(commande);
		assertEquals(commande, ListeMemoireCommandeDAO.getInstance().getById(commande.getIdCommande()));
	}
	
	@Test
	void testFindAll() {
		Commande commande = new Commande(ldate4,8,listeLigneDeCommande);
		ListeMemoireCommandeDAO.getInstance().create(commande);
		assertNotNull(ListeMemoireCommandeDAO.getInstance().findAll());

	}
}
