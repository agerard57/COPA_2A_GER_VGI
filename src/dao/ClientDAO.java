package dao;

import java.util.ArrayList;

import clients.Client;

public interface ClientDAO extends DAO<Client> {

	public abstract ArrayList<Client> getByNom(String nom);
	public abstract ArrayList<Client> getByPrenom(String nom, String prenom);

}
