package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdherentDAO;
import dao.AuteurDAO;
import dao.LivreDAO;
import model.Adherent;
import model.Auteur;
import model.Livre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionAdherents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtF_Nom;
	private JTextField txtF_Prenom;
	private JTextField txtF_Email;
	private JTextField txtF_NumTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAdherents frame = new GestionAdherents();
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
	public GestionAdherents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Gestion des Adhérents");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNumAdhérent = new JLabel("Numéro Adhérent :");
		lblNumAdhérent.setBounds(6, 55, 130, 16);
		contentPane.add(lblNumAdhérent);

		JLabel lblAffichageNumAdherent = new JLabel("");
		lblAffichageNumAdherent.setBounds(135, 55, 61, 16);
		contentPane.add(lblAffichageNumAdherent);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(6, 83, 61, 16);
		contentPane.add(lblNom);

		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(6, 121, 61, 16);
		contentPane.add(lblPrenom);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(6, 160, 48, 16);
		contentPane.add(lblEmail);

		JLabel lblNumTelephone = new JLabel("Numéro de Téléphone :");
		lblNumTelephone.setBounds(6, 188, 146, 16);
		contentPane.add(lblNumTelephone);

		txtF_Nom = new JTextField();
		txtF_Nom.setBounds(48, 78, 130, 26);
		contentPane.add(txtF_Nom);
		txtF_Nom.setColumns(10);

		txtF_Prenom = new JTextField();
		txtF_Prenom.setColumns(10);
		txtF_Prenom.setBounds(69, 116, 130, 26);
		contentPane.add(txtF_Prenom);

		txtF_Email = new JTextField();
		txtF_Email.setColumns(10);
		txtF_Email.setBounds(58, 155, 130, 26);
		contentPane.add(txtF_Email);

		txtF_NumTel = new JTextField();
		txtF_NumTel.setColumns(10);
		txtF_NumTel.setBounds(164, 183, 130, 26);
		contentPane.add(txtF_NumTel);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = txtF_Nom.getText();
					String prenom = txtF_Prenom.getText();
					String email = txtF_Email.getText();
					String numTelephone = txtF_NumTel.getText();

					// Vérifier si un ou plusieurs champs sont vide
					if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || numTelephone.isEmpty()) {
						throw new Exception("Tous les champs doivent être remplis.");
					}

					Adherent adherent = new Adherent(0, nom, prenom, email, numTelephone);
					AdherentDAO adherentDAO = new AdherentDAO();
					adherentDAO.ajouterAdherent(adherent);

					JOptionPane.showMessageDialog(null, "Adhérent ajouté avec succès!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'adhérent: " + ex.getMessage());
				}
			}
		});
		btnAjouter.setBounds(6, 237, 117, 29);
		contentPane.add(btnAjouter);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String numAdherent = lblAffichageNumAdherent.getText();
					String nom = txtF_Nom.getText();
					String prenom = txtF_Prenom.getText();
					String email = txtF_Email.getText();
					String numTelephone = txtF_NumTel.getText();

					if (numAdherent.isEmpty()) {
						throw new Exception("Vous devez d'abord rechercher un adhérent avant de le modifier.");
					}
					
					// Vérifier si les champs sont vides
					if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || numTelephone.isEmpty()) {
						throw new Exception("Tous les champs doivent être remplis.");
					}

					AdherentDAO adherentDAO = new AdherentDAO();
					Adherent adherent = adherentDAO.getAdherentById(Integer.parseInt(numAdherent)); // Recherche de l'adhérent

					// Vérifier si l'auteur a été trouvé
					if (adherent != null) {
						Adherent updatedAdherent = new Adherent(Integer.parseInt(numAdherent), nom, prenom, email, numTelephone);
						adherentDAO.updateAdherent(Integer.parseInt(numAdherent), updatedAdherent);

						JOptionPane.showMessageDialog(null, "Adhérent mis à jour avec succès.");
					} else {
						JOptionPane.showMessageDialog(null, "Aucun Adhérent trouvé avec ce numéro d'adhérent.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erreur lors de la modification de l'adhérent : " + ex.getMessage());
				}
			}
		});
		btnModifier.setBounds(135, 237, 117, 29);
		contentPane.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String numAdherent = lblAffichageNumAdherent.getText();
		            
					if (numAdherent.isEmpty()) {
						throw new Exception("Vous devez d'abord rechercher un adhérent avant de le modifier.");
					}
					
					AdherentDAO adherentDAO = new AdherentDAO();
					Adherent adherent = adherentDAO.getAdherentById(Integer.parseInt(numAdherent)); // Recherche de l'adhérent
		            
		            // Vérifier si l'auteur a été trouvé
					if (adherent != null) {
						adherentDAO.supprimerAdherent(Integer.parseInt(numAdherent));
						lblAffichageNumAdherent.setText("");
						txtF_Nom.setText("");
						txtF_Prenom.setText("");
						txtF_Email.setText("");
						txtF_NumTel.setText("");

						JOptionPane.showMessageDialog(null, "Adhérent supprimé avec succès.");
	                    
		            } else {
		                JOptionPane.showMessageDialog(null, "Aucun adhérent trouvé avec ce numéro d'adhérent.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Erreur lors de la suppresion de l'adhérent : " + ex.getMessage());
		        }
			}
		});
		btnSupprimer.setBounds(264, 237, 117, 29);
		contentPane.add(btnSupprimer);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = txtF_Nom.getText();

					// Vérifier si le champ 'nom' est vide
					if (nom.isEmpty()) {
						throw new Exception("Le nom est nécessaire pour la recherche.");
					}

					AdherentDAO adherentDAO = new AdherentDAO();
					Adherent adherent = adherentDAO.getAdherentByNom(nom); // Recherche de l'adhérent

					// Vérifier si l'auteur a été trouvé
					if (adherent != null) {
						txtF_Prenom.setText(adherent.getPrenom());
						txtF_Email.setText(adherent.getEmail());
						txtF_NumTel.setText(adherent.getNumTelephone());
						lblAffichageNumAdherent.setText(Integer.toString(adherent.getNumAdherent()));

						JOptionPane.showMessageDialog(null, "Auteur trouvé avec succès.");
					} else {
						JOptionPane.showMessageDialog(null, "Aucun Auteur trouvé avec ce nom.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erreur lors de la recherche de l'auteur : " + ex.getMessage());
				}
			}
		});
		btnRechercher.setBounds(393, 237, 117, 29);
		contentPane.add(btnRechercher);

	}
}
