package categorie;

import produits.Produit;

public class Categorie {
	protected int idCategorie;
	protected String titre;
	protected String visuel;
	
	
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	public Categorie(int idCategorie, String titre, String visuel) {
		super();
		this.idCategorie = idCategorie;
		this.titre = titre;
		this.visuel = visuel;
	}
	
	public Categorie() {
	}
	
	public Categorie(int id){
		idCategorie = id;
	}
	
	@Override
	public boolean equals(Object o) {
		Categorie c = (Categorie) o ;
		if ( o == null )
			return (this == null);
		else 
			return this.idCategorie == c.getIdCategorie();
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@Override
	public String toString() {
		return ("Categorie n�" + idCategorie + " - "+ titre + " | Visuel : " + visuel );
	}
}

