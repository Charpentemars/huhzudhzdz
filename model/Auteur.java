package model;

public class Auteur {
	private int id;
	private String nom;
	private String prenom;
	private String dateDeNaissance;
	
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
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + "]";
	}
	public Auteur(int id, String nom, String prenom, String dateDeNaissance) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
	}
	
	

	
}
