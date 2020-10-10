package tests.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import commandes.Commande;
import commandes.LigneDeCommande;
import dao.listememoire.ListeMemoireCommandeDAO;
import dao.mysql.MySQLCommandeDAO;

public class MySQLCommandeTest {
	ArrayList<LigneDeCommande> listeLigneDeCommande = new ArrayList<LigneDeCommande>();
	LocalDate ldate1 = LocalDate.of(2016,Month.MARCH,29);
	LocalDate ldate2 = LocalDate.of(2017,Month.MARCH,29);
	LocalDate ldate3 = LocalDate.of(2018,Month.MARCH,29);
	LocalDate ldate4 = LocalDate.of(2019,Month.MARCH,29);

	@Test
	void testCreateCommande() {
		Commande commande = new Commande(56, ldate2 ,8);
		MySQLCommandeDAO.getInstance().create(commande);
		assertEquals(commande, MySQLCommandeDAO.getInstance().getById(commande.getIdCommande()));
		MySQLCommandeDAO.getInstance().delete(commande);
	}
	@Test
	void testDeleteCommande() {
		Commande commande = new Commande(513, ldate1,8);
		MySQLCommandeDAO.getInstance().create(commande);
		MySQLCommandeDAO.getInstance().delete(commande);
		assertNull(MySQLCommandeDAO.getInstance().getById(commande.getIdCommande()));
		}
	@Test
	void testUpdateCommande() {
		Commande commande = new Commande(5123, ldate3,8);
		MySQLCommandeDAO.getInstance().create(commande);
		commande.setIdClient(14);
		MySQLCommandeDAO.getInstance().update(commande);
		assertEquals(commande, MySQLCommandeDAO.getInstance().getById(commande.getIdCommande()));
		MySQLCommandeDAO.getInstance().delete(commande);
	}
	
	@Test
	void testFindAll() {
		Commande commande = new Commande(56412, ldate4,8);
		MySQLCommandeDAO.getInstance().create(commande);
		MySQLCommandeDAO.getInstance().delete(commande);
		assertNotNull(MySQLCommandeDAO.getInstance().findAll());

	}
}
