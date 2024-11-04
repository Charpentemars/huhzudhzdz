package model;

public class Livre {
	private String code;
	private String titre;
	private Auteur auteur;
	private int anneePublication;
	private String isbn;
	private int nbPages;
	private String dateAchat;
	private int anneeEdition;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Auteur getAuteur() {
		return auteur;
	}
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	public int getAnneePublication() {
		return anneePublication;
	}
	public void setAnneePublication(int anneePublication) {
		this.anneePublication = anneePublication;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public String getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}
	public int getAnneeEdition() {
		return anneeEdition;
	}
	public void setAnneeEdition(int anneeEdition) {
		this.anneeEdition = anneeEdition;
	}
	public String toString() {
		return "Livre [code=" + code + ", titre=" + titre + ", auteur=" + auteur + ", anneePublication="
				+ anneePublication + ", isbn=" + isbn + ", nbPages=" + nbPages + ", dateAchat=" + dateAchat
				+ ", anneeEdition=" + anneeEdition + "]";
	}
	public Livre(String code, String titre, Auteur auteur, int anneePublication, String isbn, int nbPages, String dateAchat,
			int anneeEdition) {
		super();
		this.code = code;
		this.titre = titre;
		this.auteur = auteur;
		this.anneePublication = anneePublication;
		this.isbn = isbn;
		this.nbPages = nbPages;
		this.dateAchat = dateAchat;
		this.anneeEdition = anneeEdition;
	}
	
	
	
}
