package dao.factory;

import dao.CategorieDAO;
import dao.ClientDAO;
import dao.CommandeDAO;
import dao.LigneCommandeDAO;
import dao.ProduitDAO;
import dao.listememoire.ListeMemoireCategorieDAO;
import dao.listememoire.ListeMemoireClientDAO;
import dao.listememoire.ListeMemoireCommandeDAO;
import dao.listememoire.ListeMemoireLigneCommandeDAO;
import dao.listememoire.ListeMemoireProduitDAO;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return (ListeMemoireClientDAO.getInstance());
	}

	@Override
	public CategorieDAO getCategorieDAO() {
		// TODO Auto-generated method stub
		return (ListeMemoireCategorieDAO.getInstance());
	}

	@Override
	public ProduitDAO getProduitDAO() {
		// TODO Auto-generated method stub
		return (ListeMemoireProduitDAO.getInstance());
	}

	@Override
	public CommandeDAO getCommandeDAO() {
		// TODO Auto-generated method stub
		return (ListeMemoireCommandeDAO.getInstance());
	}

	@Override
	public LigneCommandeDAO getLigneCommandeDAO() {
		// TODO Auto-generated method stub
		return (ListeMemoireLigneCommandeDAO.getInstance());
	}

	
}
