package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Adherent;

public class AdherentDAO {
	// Méthode pour ajouter un adhérent
	public void ajouterAdherent(Adherent adherent) {
		String query = "INSERT INTO adherent (numAdherent, nom, prenom, email, numTelephone) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = MySQLConnection.getInstance(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, adherent.getNumAdherent());
			stmt.setString(2, adherent.getNom());
			stmt.setString(3, adherent.getPrenom());
			stmt.setString(4, adherent.getEmail());
			stmt.setString(5, adherent.getNumTelephone());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Méthode pour obtenir un adhérent par son id
	public Adherent getAdherentById(int id) {
		String query = "SELECT numAdherent, nom, prenom, email, numTelephone FROM adherent WHERE numAdherent = ?";
		Adherent adherent = null;
		try (Connection conn = MySQLConnection.getInstance(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int numAdherent = rs.getInt("numAdherent");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					String email = rs.getString("email");
					String numTelephone = rs.getString("numTelephone");

					adherent = new Adherent(numAdherent, nom, prenom, email, numTelephone);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adherent;
	}

	// Méthode pour rechercher un adhérent par son nom
	public Adherent getAdherentByNom(String nom) {
		Adherent adherent = null;

		String query = "SELECT * FROM adherent WHERE nom = ?";
		try (Connection conn = MySQLConnection.getInstance(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, nom);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					// Récupérer les données de l'adhérent depuis la base de données
					int numAdherent = rs.getInt("numAdherent"); // Ou autre nom de colonne pour l'ID
					String prenom = rs.getString("prenom");
					String email = rs.getString("email");
					String numTelephone = rs.getString("numTelephone");

					// Créer l'objet Adherent avec les données récupérées
					adherent = new Adherent(numAdherent, nom, prenom, email, numTelephone);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Vous pouvez gérer l'erreur plus proprement selon les besoins
		}
		return adherent;
	}

	// Méthode pour obtenirs tous les adhérents
	public List<Adherent> getAllAdherent() {
		String query = "SELECT numAdherent, nom, prenom, email, numTelephone FROM adherent";
		List<Adherent> adherents = new ArrayList<>();
		try (Connection conn = MySQLConnection.getInstance();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int numAdherent = rs.getInt("numAdherent");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String numTelephone = rs.getString("numTelephone");

				Adherent adherent = new Adherent(numAdherent, nom, prenom, email, numTelephone);
				adherents.add(adherent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adherents;
	}

	// Méthode pour mettre à jour un adhérent
	public void updateAdherent(int id, Adherent updatedAdherent) {
		String query = "UPDATE adherent SET nom = ?, prenom = ?, email = ?, numTelephone = ? WHERE numAdherent = ?";
		try (Connection conn = MySQLConnection.getInstance(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, updatedAdherent.getNom());
			stmt.setString(2, updatedAdherent.getPrenom());
			stmt.setString(3, updatedAdherent.getEmail());
			stmt.setString(4, updatedAdherent.getNumTelephone());
			stmt.setInt(5, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Méthode pour supprimer un adhérent
	public void supprimerAdherent(int id) {
		String query = "DELETE FROM adherent WHERE numAdherent = ?";
		try (Connection conn = MySQLConnection.getInstance(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
