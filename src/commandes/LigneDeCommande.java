package commandes;

public class LigneDeCommande {

	protected int idCommande;
	protected int idProduit;
	protected int quantite;
	protected float tarifUnitaire;


	public int getIdCommande() {
		return idCommande;
	}


	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}


	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getTarifUnitaire() {
		return tarifUnitaire;
	}

	public void setTarifUnitaire(float tarifUnitaire) {
		this.tarifUnitaire = tarifUnitaire;
	}

	
	public LigneDeCommande(int idCommande, int idProduit, int quantite, float tarifUnitaire) {
		super();
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.quantite = quantite;
		this.tarifUnitaire = tarifUnitaire;
	}



	public LigneDeCommande() {
	}


	public LigneDeCommande(int idCommande, int idProduit) {
		super();
		this.idCommande = idCommande;
		this.idProduit = idProduit;
	}

	public LigneDeCommande(int idCommande) {
		super();
		this.idCommande = idCommande;
	}

	@Override
	public boolean equals(Object o) { 
		LigneDeCommande c = (LigneDeCommande) o ;
		if ( o == null )
			return (this == null);
		else 
			return this.idCommande == c.idCommande && this.idProduit == c.idProduit;
		
	}
	
	
	@Override
	public String toString() {
		return ("Le produit numero " + idCommande +" concerne le produit numero " + idProduit + " ayant �t� achet�  "+ quantite  + " fois au pris unitaire de  " + tarifUnitaire );
	}
}
