package commandes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Commande {
	protected int idCommande;
	protected LocalDate dateCommande;
	protected int idClient;
	protected ArrayList<LigneDeCommande> listeLigneDeCommande;
	
	
	
	public Commande(int idCommande,LocalDate dateCommande, int idClient, ArrayList<LigneDeCommande> listeLigneDeCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.idClient = idClient;
		this.listeLigneDeCommande = listeLigneDeCommande;
	}
	
	
	public Commande() {
		idCommande = -1;
		dateCommande = LocalDate.now();
		idClient = -1;
		listeLigneDeCommande = new ArrayList<LigneDeCommande>();
	}
	
	
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	
	public LocalDate getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	public ArrayList<LigneDeCommande> getListeLigneDeCommande() {
		return listeLigneDeCommande;
	}
	public void setListeLigneDeCommande(ArrayList<LigneDeCommande> listeLigneDeCommande) {
		this.listeLigneDeCommande = listeLigneDeCommande;
	}
	
	
	
	
	@Override
	public String toString() {
		return ("Le produit numero " + idCommande +" a ete commandé le  " + dateCommande + " par  "+ idClient );
	}
}