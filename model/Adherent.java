package model;

public class Adherent {
	private int numAdherent;
	private String nom;
	private String prenom;
	private String email;
	private String numTelephone;

	public Adherent(int numAdherent, String nom, String prenom, String email, String numTelephone) {
		super();
		this.numAdherent = numAdherent;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numTelephone = numTelephone;
	}

	public int getNumAdherent() {
		return numAdherent;
	}

	public void setNumAdherent(int numAdherent) {
		this.numAdherent = numAdherent;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	@Override
	public String toString() {
		return "Adherent [numAdherent=" + numAdherent + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", numTelephone=" + numTelephone + "]";
	}
	
	

}
