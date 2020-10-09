package clients;

public class Client {
	protected int idClient;
	protected String nom;
	protected String prenom;
	protected String identifiant;
	protected String motDePasse;
	protected String adrNumero;
	protected String adrVoie;
	protected String adrCodePostal;
	protected String adrVille;
	protected String adrPays;
	protected static int selection;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getAdrNumero() {
		return adrNumero;
	}

	public void setAdrNumero(String adrNumero) {
		this.adrNumero = adrNumero;
	}

	public String getAdrVoie() {
		return adrVoie;
	}

	public void setAdrVoie(String adrVoie) {
		this.adrVoie = adrVoie;
	}

	public String getAdrCodePostal() {
		return adrCodePostal;
	}

	public void setAdrCodePostal(String adrCodePostal) {
		this.adrCodePostal = adrCodePostal;
	}

	public String getAdrVille() {
		return adrVille;
	}

	public void setAdrVille(String adrVille) {
		this.adrVille = adrVille;
	}

	public String getAdrPays() {
		return adrPays;
	}

	public void setAdrPays(String adrPays) {
		this.adrPays = adrPays;
	}

	public static int getSelection() {
		return selection;
	}

	public static void setSelection(int selection) {
		Client.selection = selection;
	}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	


	public Client() {
	}

	public Client(int idClient, String nom, String prenom, String identifiant, String motDePasse, String adrNumero,
			String adrVoie, String adrCodePostal, String adrVille, String adrPays) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.adrNumero = adrNumero;
		this.adrVoie = adrVoie;
		this.adrCodePostal = adrCodePostal;
		this.adrVille = adrVille;
		this.adrPays = adrPays;
	}
	public Client(String nom, String prenom, String identifiant, String motDePasse, String adrNumero,
			String adrVoie, String adrCodePostal, String adrVille, String adrPays) {
		super();
		this.idClient = -1;
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.adrNumero = adrNumero;
		this.adrVoie = adrVoie;
		this.adrCodePostal = adrCodePostal;
		this.adrVille = adrVille;
		this.adrPays = adrPays;
	}
	
	
	

	public Client(int id){
		idClient = id;
	}


	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	
	
	@Override
	public boolean equals(Object o) { // si deux client ont le meme idclient, on dit de les considérer comme égaux
		Client c = (Client) o ;
		if ( o == null )
			return (this == null);
		else 
			return this.idClient == c.idClient;
	}
	@Override
	public String toString() {
		return ("Client n " + idClient + " - "+ nom + " " +prenom+ " | Identifiant : " + identifiant);
	}
}

