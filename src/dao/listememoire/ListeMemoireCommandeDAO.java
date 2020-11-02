package dao.listememoire;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import commandes.Commande;
import dao.CommandeDAO;

public class ListeMemoireCommandeDAO implements CommandeDAO{

	private static ListeMemoireCommandeDAO instance;

	private ArrayList<Commande> donnees;

	public static ListeMemoireCommandeDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireCommandeDAO();
		}

		return (instance);
	}
	
	private ListeMemoireCommandeDAO() {
		donnees = new ArrayList<Commande>();
		LocalDate ldate1 = LocalDate.of(2016,Month.MARCH,29);
	    LocalDate ldate2 = LocalDate.of(2017,Month.MARCH,29);
	    LocalDate ldate3 = LocalDate.of(2018,Month.MARCH,29);
	    LocalDate ldate4 = LocalDate.of(2019,Month.MARCH,29);
	    
	    donnees.add(new Commande(24, ldate1, 1));
	    donnees.add(new Commande(26, ldate2, 3));
	    donnees.add(new Commande(27, ldate3, 2));
	    donnees.add(new Commande(28, ldate4, 5));
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public boolean create(Commande object) {
		object.setIdCommande(1);
		while (donnees.indexOf(object) > -1)
		{
			object.setIdCommande(object.getIdCommande() + 1);
		}
		donnees.add(object);
		
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean update(Commande object) {

		if (donnees.indexOf(object) < 0)
			return (false);
		else
			donnees.set(donnees.indexOf(object), object);
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean delete(Commande object) {
		if (donnees.indexOf(object) < 0)
			return (false);
		else
			donnees.remove(donnees.indexOf(object));
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	public ArrayList<Commande> findAll() {
		return (donnees);

	}


	@Override
	public Commande getById(int id) {
		if (donnees.indexOf(new Commande(id)) < 0)
			return (null);
		else
			return (donnees.get(donnees.indexOf(new Commande(id))));
	}

}
