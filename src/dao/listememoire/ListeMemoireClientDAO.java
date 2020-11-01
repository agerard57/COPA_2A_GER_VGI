package dao.listememoire;

import java.util.ArrayList;

import clients.Client;
import dao.ClientDAO;

public class ListeMemoireClientDAO implements ClientDAO {
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static ListeMemoireClientDAO instance;

	private ArrayList<Client> donnees;

	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return (instance);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private ListeMemoireClientDAO() {
		donnees = new ArrayList<Client>();
        donnees.add(new Client(1,"GERARD","Alexandre","se57@hm.fr","aaa", "aaa", "aaa", "aaa", "Metz", "aaa"));
        donnees.add(new Client(2,"RYAN","Andrew","bio75@mi.com","cds", "aaa", "aaa", "aaa", "Rapture", "aaa"));
        donnees.add(new Client(3,"REZNOV","Victor","lib12@fre.ru", "cc", "aaa", "aaa", "aaa", "Tentling", "aaa"));
	}
	
	
	
	public boolean create(Client object) {
		object.setIdClient(1);
		while (donnees.indexOf(object) > -1)
		{
			object.setIdClient(object.getIdClient() + 1);
		}
		donnees.add(object);
		
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean update(Client object) {

		if (donnees.indexOf(object) < 0)
			return (false);
		else
			donnees.set(donnees.indexOf(object), object);
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean delete(Client object) {

		if (donnees.indexOf(object) < 0)
			return (false);
		else
			donnees.remove(donnees.indexOf(object));
		return (true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	public ArrayList<Client> findAll() {
		return (donnees);
	}

	@Override
	public Client getById(int id) {
		if (donnees.indexOf(new Client(id)) < 0)
			return (null);
		else
			return (donnees.get(donnees.indexOf(new Client(id))));
	}


	@Override
	public ArrayList<Client> getByNom(String nom) {
		ArrayList<Client> listeClient = new ArrayList<Client>();
		int c = 0;
		
		while (c < donnees.size())
		{
			if (donnees.get(c).getNom().equalsIgnoreCase(nom))
				listeClient.add(donnees.get(c));
			c++;
		}
		return (listeClient);
	}


	@Override
	public ArrayList<Client> getByNomPrenom(String nom, String prenom) {
		ArrayList<Client> listeClient = new ArrayList<Client>();
		int c = 0;
		
		while (c < donnees.size())
		{
			if (donnees.get(c).getNom().equalsIgnoreCase(nom) && donnees.get(c).getPrenom().equalsIgnoreCase(prenom))
				listeClient.add(donnees.get(c));
			c++;
		}
		return (listeClient);
	}



}
