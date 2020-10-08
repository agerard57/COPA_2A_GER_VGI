package dao.factory;

import dao.CategorieDAO;
import dao.ClientDAO;
import dao.CommandeDAO;
import dao.LigneCommandeDAO;
import dao.ProduitDAO;
import dao.mysql.MySQLCategorieDAO;
import dao.mysql.MySQLClientDAO;
import dao.mysql.MySQLCommandeDAO;
import dao.mysql.MySQLProduitDAO;
import dao.mysql.MySQLigneCommandeDAO;

public class MySQLDAOFactory extends DAOFactory{

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return (MySQLClientDAO.getInstance());
	}

	@Override
	public CategorieDAO getCategorieDAO() {
		// TODO Auto-generated method stub
		return (MySQLCategorieDAO.getInstance());
	}

	@Override
	public ProduitDAO getProduitDAO() {
		// TODO Auto-generated method stub
		return (MySQLProduitDAO.getInstance());
	}

	@Override
	public CommandeDAO getCommandeDAO() {
		// TODO Auto-generated method stub
		return (MySQLCommandeDAO.getInstance());
	}

	@Override
	public LigneCommandeDAO getLigneCommandeDAO() {
		// TODO Auto-generated method stub
		return (MySQLigneCommandeDAO.getInstance());
	}

}
