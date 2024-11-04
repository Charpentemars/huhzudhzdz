package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AuteurDAO;
import dao.LivreDAO;
import model.Auteur;
import model.Livre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionAuteurs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfNom;
	private JTextField txtfPrenom;
	private JTextField txtfDateNaissance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAuteurs frame = new GestionAuteurs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionAuteurs() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAuteursTitle = new JLabel("Gestion des Auteurs");
		lblAuteursTitle.setFont(new Font("Lucida Grande", Font.BOLD, 21));
		lblAuteursTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuteursTitle.setBounds(6, 6, 302, 30);
		contentPane.add(lblAuteursTitle);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = txtfNom.getText();

					// Vérifier si le champ 'nom' est vide
					if (nom.isEmpty()) {
						throw new Exception("Le nom est nécessaire pour la suppresion.");
					}

					AuteurDAO auteurDAO = new AuteurDAO();
					Auteur auteur = auteurDAO.getAuteurByNom(nom); // Recherche de l'auteur

					// Vérifier si l'auteur a été trouvé
					if (auteur != null) {
						auteurDAO.supprimerAuteur(nom);
						txtfNom.setText("");
						txtfPrenom.setText("");
						txtfDateNaissance.setText("");
						JOptionPane.showMessageDialog(null, "Auteur supprimé avec succès.");
					} else {
						JOptionPane.showMessageDialog(null, "Aucun auteur trouvé avec ce nom.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Erreur lors de la suppresion de l'auteur : " + ex.getMessage());
				}
			}
		});
		btnSupprimer.setBounds(188, 237, 117, 29);
		contentPane.add(btnSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = txtfNom.getText();
					String prenom = txtfPrenom.getText();
					String dateDeNaissance = txtfDateNaissance.getText();

					// Vérifier si un ou plusieurs champs sont vide
					if (nom.isEmpty() || prenom.isEmpty() || dateDeNaissance.isEmpty()) {
						throw new Exception("Tous les champs doivent être remplis.");
					}

					// Vérification du format de la date (YYYY-MM-DD)
					if (!dateDeNaissance.matches("\\d{4}-\\d{2}-\\d{2}")) {
						throw new Exception("La date de naissance doit être au format YYYY-MM-DD.");
					}

					AuteurDAO auteurDAO = new AuteurDAO();
					Auteur auteur = auteurDAO.getAuteurByNom(nom); // Recherche de l'auteur

					// Vérifier si l'auteur a été trouvé
					if (auteur != null) {
						Auteur editedAuteur = new Auteur(auteur.getId(), nom, prenom, dateDeNaissance);
						auteurDAO.updateAuteur(editedAuteur);

						JOptionPane.showMessageDialog(null, "Auteur modifié avec succès.");
					} else {
						JOptionPane.showMessageDialog(null, "Aucun auteur trouvé avec ce nom.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Erreur lors de la modification de l'auteur : " + ex.getMessage());
				}
			}
		});
		btnModifier.setBounds(188, 196, 117, 29);
		contentPane.add(btnModifier);
		// Pour le modifier, l'utilisateur fais d'abord une recherche, on stock l'id et
		// ensuite il peut modifier les champs et cliquer sur modifier

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = txtfNom.getText();
					String prenom = txtfPrenom.getText();
					String dateDeNaissance = txtfDateNaissance.getText();

					// Vérifier si un ou plusieurs champs sont vide
					if (nom.isEmpty() || prenom.isEmpty() || dateDeNaissance.isEmpty()) {
						throw new Exception("Tous les champs doivent être remplis.");
					}

					// Vérification du format de la date (YYYY-MM-DD)
					if (!dateDeNaissance.matches("\\d{4}-\\d{2}-\\d{2}")) {
						throw new Exception("La date de naissance doit être au format YYYY-MM-DD.");
					}

					Auteur auteur = new Auteur(0, nom, prenom, dateDeNaissance);
					AuteurDAO auteurDAO = new AuteurDAO();
					auteurDAO.ajouterAuteur(auteur);

					JOptionPane.showMessageDialog(null, "Auteur ajouté avec succès!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'auteur: " + ex.getMessage());
				}
			}
		});

		btnAjouter.setBounds(6, 196, 117, 29);
		contentPane.add(btnAjouter);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = txtfNom.getText();

					// Vérifier si le champ 'nom' est vide
					if (nom.isEmpty()) {
						throw new Exception("Le nom est nécessaire pour la recherche.");
					}

					AuteurDAO auteurDAO = new AuteurDAO();
					Auteur auteur = auteurDAO.getAuteurByNom(nom); // Recherche de l'auteur

					// Vérifier si l'auteur a été trouvé
					if (auteur != null) {
						txtfPrenom.setText(auteur.getPrenom());
						txtfDateNaissance.setText(auteur.getDateDeNaissance());

						JOptionPane.showMessageDialog(null, "Auteur trouvé avec succès.");
					} else {
						JOptionPane.showMessageDialog(null, "Aucun Auteur trouvé avec ce nom.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erreur lors de la recherche de l'auteur : " + ex.getMessage());
				}
			}
		});
		btnRechercher.setBounds(6, 237, 117, 29);
		contentPane.add(btnRechercher);

		txtfNom = new JTextField();
		txtfNom.setBounds(51, 78, 254, 26);
		contentPane.add(txtfNom);
		txtfNom.setColumns(10);

		txtfPrenom = new JTextField();
		txtfPrenom.setColumns(10);
		txtfPrenom.setBounds(66, 116, 239, 26);
		contentPane.add(txtfPrenom);

		txtfDateNaissance = new JTextField();
		txtfDateNaissance.setColumns(10);
		txtfDateNaissance.setBounds(114, 155, 191, 26);
		contentPane.add(txtfDateNaissance);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(6, 83, 61, 16);
		contentPane.add(lblNom);

		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(6, 121, 61, 16);
		contentPane.add(lblPrenom);

		JLabel lblDateNaissance = new JLabel("Date naissance :");
		lblDateNaissance.setBounds(6, 160, 117, 16);
		contentPane.add(lblDateNaissance);
	}
}
