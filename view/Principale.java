package view;

import java.util.ArrayList;

import model.Auteur;
import model.BiblioBus;
import model.Livre;

public class Principale {

	public static void main(String[] args) {
		ArrayList<Livre> listeLivres = new ArrayList<>();

		// Création d'auteurs
		Auteur auteur1 = new Auteur(1, "Dumas", "Alexandre", "1802-07-24");
		Auteur auteur2 = new Auteur(2, "Hugo", "Victor", "1802-02-26");

		// Création du bibliobus
		BiblioBus bibliobus = new BiblioBus("Marie Dupont", "10 rue de la Mairie", listeLivres);

		// Ajout des auteurs
		bibliobus.ajouterAuteur(auteur1);
		bibliobus.ajouterAuteur(auteur2);

		// Création de livres
		Livre livre1 = new Livre("001", "Les Trois Mousquetaires", auteur1, 1844, "1234567890123", 700, "2023-01-01", 2023);
		Livre livre2 = new Livre("002", "Le Comte de Monte-Cristo", auteur1, 1846, "1234567890456", 800, "2023-02-02", 2023);
		Livre livre3 = new Livre("003", "Les Misérables", auteur2, 1862, "1234567890789", 1200, "2023-03-03", 2023);

		// Ajout des livres au bibliobus
		bibliobus.ajouterLivre(livre1);
		bibliobus.ajouterLivre(livre2);
		bibliobus.ajouterLivre(livre3);

		// Affichage des livres du bibliobus
		System.out.println("Liste des livres dans le bibliobus :");
		bibliobus.afficherLivres();

		// Recherche par titre
		System.out.println("\nRecherche par titre (Les Trois Mousquetaires) :");
		System.out.println(bibliobus.rechercherLivreParTitre("Les Trois Mousquetaires"));

		// Recherche par code
		System.out.println("\nRecherche par code (001) :");
		/*System.out.println(bibliobus.rechercherLivreParCode("001"));*/

		// Recherche par auteur
		System.out.println("\nRecherche par auteur (Dumas) :");
		System.out.println(bibliobus.rechercherLivreParAuteur("Dumas"));

		// Retirer un livre par ISBN
		bibliobus.retirerLivre("1234567890123");
		System.out.println("\nAprès suppression du livre avec ISBN 1234567890123 :");
		bibliobus.afficherLivres();
	}
}