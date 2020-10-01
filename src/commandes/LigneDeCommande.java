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





	@Override
	public String toString() {
		return ("Le produit numero " + idCommande +" concerne le produit numero " + idProduit + " ayant été acheté  "+ quantite  + " fois au pris unitaire de  " + tarifUnitaire );
	}
}
