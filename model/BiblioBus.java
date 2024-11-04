package model;

import dao.LivreDAO;
import dao.AuteurDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class BiblioBus {
    private String nomResponsable;
    private String adresseMairie;
    private ArrayList<Livre> listeLivres;
    private LivreDAO livreDAO;
    private AuteurDAO auteurDAO;

    public BiblioBus(String nomResponsable, String adresseMairie, ArrayList<Livre> listeLivres) {
        this.nomResponsable = nomResponsable;
        this.adresseMairie = adresseMairie;
        this.listeLivres = listeLivres;
        this.livreDAO = new LivreDAO();
        this.auteurDAO = new AuteurDAO();
    }

    // Méthode pour ajouter un auteur
    public void ajouterAuteur(Auteur auteur) {
        try {
			auteurDAO.ajouterAuteur(auteur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Méthode pour retirer un auteur
    public void retirerAuteur(String nom) {
        auteurDAO.supprimerAuteur(nom);
    }

    // Méthode pour ajouter un livre
    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
        try {
			livreDAO.ajouterLivre(livre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Méthode pour retirer un livre
    public void retirerLivre(String isbn) {
        for (int i = 0; i < listeLivres.size(); i++) {
            Livre book = listeLivres.get(i);
            if (book.getIsbn().equals(isbn)) {
                listeLivres.remove(i);
                livreDAO.supprimerLivre(book.getCode());
                return;
            }
        }
    }

    // Méthode pour rechercher un livre avec son code
    public Livre rechercherLivreParCode(String code) {
        return livreDAO.getLivreByCode(code);
    }

    // Méthode pour rechercher un livre avec son titre
    public ArrayList<Livre> rechercherLivreParTitre(String titre) {
        ArrayList<Livre> result = new ArrayList<>();
        for (int i = 0; i < listeLivres.size(); i++) {
            Livre book = listeLivres.get(i);
            if (book.getTitre().equals(titre)) {
                result.add(book);
            }
        }
        return result;
    }

    // Méthode pour rechercher un livre par son auteur
    public ArrayList<Livre> rechercherLivreParAuteur(String nomAuteur) {
        ArrayList<Livre> result = new ArrayList<>();
        for (int i = 0; i < listeLivres.size(); i++) {
            Livre book = listeLivres.get(i);
            if (book.getAuteur().getNom().equals(nomAuteur)) {
                result.add(book);
            }
        }
        return result;
    }

    // Méthode pour afficher les livres du BiblioBus
    public void afficherLivres() {
        for (int i = 0; i < listeLivres.size(); i++) {
            Livre book = listeLivres.get(i);
            System.out.println(book.toString());
        }
    }
}