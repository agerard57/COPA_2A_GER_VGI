package dao;

import java.util.ArrayList;

import commandes.LigneDeCommande;

public interface LigneCommandeDAO {


	public abstract boolean create(LigneDeCommande object);
	public abstract boolean update(LigneDeCommande object);
	public abstract boolean delete(LigneDeCommande object);
	
	public abstract ArrayList<LigneDeCommande> findAll();
	public abstract LigneDeCommande getById(int idCommande, int idProduit);
	
}
