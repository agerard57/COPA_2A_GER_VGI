package dao.factory;

import dao.CategorieDAO;
import dao.ClientDAO;
import dao.CommandeDAO;
import dao.LigneCommandeDAO;
import dao.ProduitDAO;
import enumz.ModeDAO;

public abstract class DAOFactory 
{
	public static DAOFactory getDAOFactory(ModeDAO mode) 
	{
		DAOFactory daof = null;

		switch (mode) {
		case MYSQL: 
			daof = new MySQLDAOFactory();
			break;
		case LISTE_MEMOIRE: 
			daof = new ListeMemoireDAOFactory();
			break;
		}
		return (daof);
	}

	public abstract ClientDAO getClientDAO();
	public abstract CategorieDAO getCategorieDAO();
	public abstract ProduitDAO getProduitDAO();
	public abstract CommandeDAO getCommandeDAO();
	public abstract LigneCommandeDAO getLigneCommandeDAO();
}
