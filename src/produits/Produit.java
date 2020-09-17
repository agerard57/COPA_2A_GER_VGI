package produits;

import produits.Produit;

public class Produit {
	protected int idProduit;
	protected String nom;
	protected String description;
	protected float tarif;
	protected String visuel;
	protected int idCategorie;



	
	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public static int getSelection() {
		return selection;
	}

	public static void setSelection(int selection) {
		Produit.selection = selection;
	}

	protected static int selection;



	
	





	public Produit() {
	}

	public Produit(int idProduit, String nom, String description, float tarif, String visuel, int idCategorie) {
		super();
		this.idProduit = idProduit;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.visuel = visuel;
		this.idCategorie = idCategorie;
	}

	public Produit(int id){
		idProduit = id;
	}


	@Override
	public boolean equals(Object o) {
		Produit c = (Produit) o ;
		if ( o == null )
			return (this == null);
		else 
			return this.idProduit == c.idProduit;
	}
	@Override
	public String toString() {
		return ("Produit n°" + idProduit + " - "+ nom + " | Description : " +description+ " | tarif : "+tarif+"€ | visuel : "+visuel+" | catégorie n°"+idCategorie);
	}
}

