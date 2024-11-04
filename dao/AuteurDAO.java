package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Auteur;

public class AuteurDAO {
	
    // Méthode pour ajouter un auteur
    public void ajouterAuteur(Auteur auteur) throws SQLException {
        String query = "INSERT INTO auteurs (id, nom, prenom, dateDeNaissance) VALUES (?, ?, ?, ?)";
        try (Connection conn = MySQLConnection.getInstance();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, auteur.getId());
            stmt.setString(2, auteur.getNom());
            stmt.setString(3, auteur.getPrenom());
            stmt.setString(4, auteur.getDateDeNaissance());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour obtenir un auteur avec nom
    public Auteur getAuteurByNom(String nom) {
        Auteur auteur = null;
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "SELECT * FROM auteurs WHERE nom = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nom);
                try (ResultSet resultSetAuteurNom = statement.executeQuery()) {
                    if (resultSetAuteurNom.next()) {
                        auteur = new Auteur(resultSetAuteurNom.getInt("id"), resultSetAuteurNom.getString("nom"), resultSetAuteurNom.getString("prenom"), resultSetAuteurNom.getString("dateDeNaissance"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auteur;
    }
    
    // Méthode pour obtenir un auteur avec id
    public Auteur getAuteurById(int id) {
        Auteur auteur = null;
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "SELECT * FROM auteurs WHERE nom = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSetAuteurId = statement.executeQuery()) {
                    if (resultSetAuteurId.next()) {
                        auteur = new Auteur(resultSetAuteurId.getInt("id"), resultSetAuteurId.getString("nom"), resultSetAuteurId.getString("prenom"), resultSetAuteurId.getString("dateDeNaissance"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auteur;
    }

    // Méthode pour lister tous les auteurs
    public List<Auteur> getAllAuteurs() {
        List<Auteur> auteurs = new ArrayList<>();
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "SELECT * FROM auteurs";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSetAuteurAll = statement.executeQuery()) {
                while (resultSetAuteurAll.next()) {
                    auteurs.add(new Auteur(resultSetAuteurAll.getInt("id"), resultSetAuteurAll.getString("nom"), resultSetAuteurAll.getString("prenom"), resultSetAuteurAll.getString("dateDeNaissance")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auteurs;
    }

    // Méthode pour mettre à jour un auteur
    public void updateAuteur(Auteur auteur) {
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "UPDATE auteurs SET nom = ?, prenom = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, auteur.getNom());
                statement.setString(2, auteur.getPrenom());
                statement.setInt(3, auteur.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un auteur
    public void supprimerAuteur(String nom) {
        try (Connection connection = MySQLConnection.getInstance()) {
            String query = "DELETE FROM auteurs WHERE nom = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nom);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}