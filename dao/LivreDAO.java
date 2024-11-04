package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Auteur;
import model.Livre;

public class LivreDAO {

    // Méthode pour ajouter un livre
    public void ajouterLivre(Livre livre) throws SQLException {
        String query = "INSERT INTO livres (code, titre, auteur_id, anneePublication, isbn, nbPages, dateAchat, anneeEdition) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = MySQLConnection.getInstance();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, livre.getCode());
            stmt.setString(2, livre.getTitre());
            stmt.setInt(3, livre.getAuteur().getId());
            stmt.setInt(4, livre.getAnneePublication());
            stmt.setString(5, livre.getIsbn());
            stmt.setInt(6, livre.getNbPages());
            stmt.setString(7, livre.getDateAchat());
            stmt.setInt(8, livre.getAnneeEdition());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer un livre par son code
    public Livre getLivreByCode(String code) {
        Livre livre = null;
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "SELECT * FROM livres WHERE code = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
            	System.out.println(code);
                statement.setString(1, code);
                try (ResultSet resultSetLivreCode = statement.executeQuery()) {
                    if (resultSetLivreCode.next()) {
                    	String resultCode = resultSetLivreCode.getString("code");
                    	String resultTitre = resultSetLivreCode.getString("titre");
                    	int anneePublication = resultSetLivreCode.getInt("anneePublication");
                    	String ISBN = resultSetLivreCode.getString("isbn");
                    	int nbPages = resultSetLivreCode.getInt("nbPages");
                    	String dateAchat = resultSetLivreCode.getString("dateAchat");
                    	int anneeEdition = resultSetLivreCode.getInt("anneeEdition");
                    	
                        AuteurDAO auteurDAO = new AuteurDAO();
                        Auteur auteur = auteurDAO.getAuteurById(resultSetLivreCode.getInt("auteur_id"));
                        livre = new Livre(
                            resultCode,
                            resultTitre,
                            auteur,
                            anneePublication,
                            ISBN,
                            nbPages,
                            dateAchat,
                            anneeEdition
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livre;
    }

    // Méthode pour lister tous les livres
    public List<Livre> getAllLivres() {
        List<Livre> livres = new ArrayList<>();
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "SELECT * FROM livres";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSetLivresAll = statement.executeQuery()) {
                while (resultSetLivresAll.next()) {
                    AuteurDAO auteurDAO = new AuteurDAO();
                    Auteur auteur = auteurDAO.getAuteurById(resultSetLivresAll.getInt("auteur_id"));
                    livres.add(new Livre(
                        resultSetLivresAll.getString("code"),
                        resultSetLivresAll.getString("titre"),
                        auteur,
                        resultSetLivresAll.getInt("anneePublication"),
                        resultSetLivresAll.getString("isbn"),
                        resultSetLivresAll.getInt("nbPages"),
                        resultSetLivresAll.getString("dateAchat"),
                        resultSetLivresAll.getInt("anneeEdition")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livres;
    }

    // Méthode pour mettre à jour un livre
    public void updateLivre(Livre livre) {
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "UPDATE livres SET titre = ?, auteur_id = ?, anneePublication = ?, isbn = ?, nbPages = ?, dateAchat = ?, anneeEdition = ? WHERE code = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, livre.getTitre());
                statement.setInt(2, livre.getAuteur().getId());
                statement.setInt(3, livre.getAnneePublication());
                statement.setString(4, livre.getIsbn());
                statement.setInt(5, livre.getNbPages());
                statement.setString(6, livre.getDateAchat());
                statement.setInt(7, livre.getAnneeEdition());
                statement.setString(8, livre.getCode());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un livre
    public void supprimerLivre(String code) {
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "DELETE FROM livres WHERE code = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, code);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}