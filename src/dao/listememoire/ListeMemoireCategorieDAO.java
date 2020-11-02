package dao.listememoire;

import java.util.ArrayList;

import categorie.Categorie;
import dao.CategorieDAO;

public class ListeMemoireCategorieDAO implements CategorieDAO{

	private static ListeMemoireCategorieDAO instance;

	private ArrayList<Categorie> donnees;

	public static ListeMemoireCategorieDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireCategorieDAO();
		}
       
		return (instance);
	}

	public ListeMemoireCategorieDAO() {
		donnees = new ArrayList<Categorie>();
		donnees.add(new Categorie(1, "Pulls", "/visuels/categorie/lespulls.png"));
		donnees.add(new Categorie(2, "Bonnets", "/visuels/categorie/lesbonnets.png"));
		donnees.add(new Categorie(3, "Chaussettes", "/visuels/categorie/leschaussettes.png"));

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public boolean create(Categorie object) {
		object.setIdCategorie(1);
		while (donnees.indexOf(object) > -1)
		{
			object.setIdCategorie(object.getIdCategorie() + 1);
		}
		donnees.add(object);
		
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean update(Categorie object) {

		if (donnees.indexOf(object) < 0)
			return (false);
		else
			donnees.set(donnees.indexOf(object), object);
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean delete(Categorie object) {

		if (donnees.indexOf(object) < 0)
			return (false);
		else
			donnees.remove(donnees.indexOf(object));
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	public ArrayList<Categorie> findAll() {
		return (donnees);
	}


	@Override
	public Categorie getById(int id) {
		if (donnees.indexOf(new Categorie(id)) < 0)
			return (null);
		else
			return (donnees.get(donnees.indexOf(new Categorie(id))));
	}
}
