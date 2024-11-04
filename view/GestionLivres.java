package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LivreDAO;
import model.Auteur;
import model.Livre;
import dao.AuteurDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GestionLivres extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfCode;
	private JTextField txtfTitre;
	private JTextField txtfPublication;
	private JTextField txtfISBN;
	private JTextField txtfNbPages;
	private JTextField txtfDateAchat;
	private JTextField txtfEdition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionLivres frame = new GestionLivres();
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
	public GestionLivres() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivresTitle = new JLabel("Gestion des Livres");
		lblLivresTitle.setBounds(6, 10, 438, 26);
		lblLivresTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivresTitle.setFont(new Font("Lucida Grande", Font.BOLD, 21));
		contentPane.add(lblLivresTitle);
		
		JLabel lblCode = new JLabel("Code :");
		lblCode.setBounds(6, 48, 61, 16);
		contentPane.add(lblCode);
		
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setBounds(6, 76, 61, 16);
		contentPane.add(lblTitre);
		
		JLabel lblAuteur = new JLabel("Auteur :");
		lblAuteur.setBounds(6, 104, 61, 16);
		contentPane.add(lblAuteur);
		
		JLabel lblPublication = new JLabel("Année Publication :");
		lblPublication.setBounds(6, 132, 125, 16);
		contentPane.add(lblPublication);
		
		JLabel lblISBN = new JLabel("ISBN : ");
		lblISBN.setBounds(6, 160, 61, 16);
		contentPane.add(lblISBN);
		
		JLabel lblNbPages = new JLabel("Nb Pages :");
		lblNbPages.setBounds(6, 188, 66, 16);
		contentPane.add(lblNbPages);
		
		JLabel lblDateAchat = new JLabel("Date Achat :");
		lblDateAchat.setBounds(6, 216, 78, 16);
		contentPane.add(lblDateAchat);
		
		JLabel lblEdition = new JLabel("Édition :");
		lblEdition.setBounds(6, 244, 61, 16);
		contentPane.add(lblEdition);
		
		txtfCode = new JTextField();
		txtfCode.setBounds(56, 43, 217, 26);
		contentPane.add(txtfCode);
		txtfCode.setColumns(10);
		
		txtfTitre = new JTextField();
		txtfTitre.setColumns(10);
		txtfTitre.setBounds(56, 71, 217, 26);
		contentPane.add(txtfTitre);
		
		JComboBox<String> cBox_Auteur = new JComboBox<String>();
		cBox_Auteur.setBounds(56, 100, 217, 27);
		contentPane.add(cBox_Auteur);
		AuteurDAO auteurDAO = new AuteurDAO();
		List<Auteur> auteurs = auteurDAO.getAllAuteurs();
		for (Auteur auteur : auteurs) {
		    cBox_Auteur.addItem(auteur.getNom());
		}
		
		txtfPublication = new JTextField();
		txtfPublication.setColumns(10);
		txtfPublication.setBounds(132, 127, 141, 26);
		contentPane.add(txtfPublication);
		
		txtfISBN = new JTextField();
		txtfISBN.setColumns(10);
		txtfISBN.setBounds(45, 155, 228, 26);
		contentPane.add(txtfISBN);
		
		txtfNbPages = new JTextField();
		txtfNbPages.setColumns(10);
		txtfNbPages.setBounds(87, 183, 186, 26);
		contentPane.add(txtfNbPages);
		
		txtfDateAchat = new JTextField();
		txtfDateAchat.setColumns(10);
		txtfDateAchat.setBounds(87, 211, 186, 26);
		contentPane.add(txtfDateAchat);
		
		txtfEdition = new JTextField();
		txtfEdition.setColumns(10);
		txtfEdition.setBounds(79, 239, 194, 26);
		contentPane.add(txtfEdition);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String code = txtfCode.getText();
		            
		            // Vérifier si le champ 'nom' est vide
		            if (code.isEmpty()) {
		                throw new Exception("Le code est nécessaire pour la recherche.");
		            }

		            LivreDAO livreDAO = new LivreDAO();
		            Livre livre = livreDAO.getLivreByCode(code);  // Recherche de l'auteur

		            // Vérifier si l'auteur a été trouvé
		            if (livre != null) {
		            	txtfCode.setText(livre.getCode());
	                    txtfTitre.setText(livre.getTitre());
	                    //cBox_Auteur.getItemAt(cBox_Auteur.getSelectedIndex());
	                    txtfPublication.setText(Integer.toString(livre.getAnneePublication()));
	                    txtfISBN.setText(livre.getIsbn());
	                    txtfNbPages.setText(Integer.toString(livre.getNbPages()));
	                    txtfDateAchat.setText(livre.getDateAchat());
	                    txtfEdition.setText(Integer.toString(livre.getAnneeEdition()));

		                JOptionPane.showMessageDialog(null, "Livre trouvé avec succès.");
		            } else {
		                JOptionPane.showMessageDialog(null, "Aucun livre trouvé avec ce nom.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Erreur lors de la recherche d'un livre : " + ex.getMessage());
		        }
			}
		});
		btnRechercher.setBounds(327, 99, 117, 29);
		contentPane.add(btnRechercher);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String code = txtfCode.getText();
                    String titre = txtfTitre.getText();
                    String auteur = cBox_Auteur.getItemAt(cBox_Auteur.getSelectedIndex());
                    String anneePublication = txtfPublication.getText();
                    String ISBN = txtfISBN.getText();
                    String nbPages = txtfNbPages.getText();
                    String dateAchat = txtfDateAchat.getText();
                    String anneeEdition = txtfEdition.getText();
                    
                    // Vérifier si un ou plusieurs champs sont vide
                    if (code.isEmpty() || titre.isEmpty() || auteur.isEmpty()  || anneePublication.isEmpty()  ||  ISBN.isEmpty() ||  nbPages.isEmpty() ||  dateAchat.isEmpty()||  anneeEdition.isEmpty()) {
                        throw new Exception("Tous les champs doivent être remplis.");
                    }
                    
                    // Vérification du format de la date (YYYY-MM-DD)
                    if (!dateAchat.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        throw new Exception("La date d'achat doit être au format YYYY-MM-DD.");
                    }
                    
                    AuteurDAO auteurDAO = new AuteurDAO();
                    Livre livre = new Livre(code,titre,auteurDAO.getAuteurByNom(auteur),Integer.parseInt(anneePublication), ISBN, Integer.parseInt(nbPages), dateAchat, Integer.parseInt(anneeEdition));
                    LivreDAO livreDAO = new LivreDAO();
                    livreDAO.ajouterLivre(livre);
                    
                   
                    JOptionPane.showMessageDialog(null, "Livre ajouté avec succès!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du livre: " + ex.getMessage());
                }
			}
		});
		btnAjouter.setBounds(327, 127, 117, 29);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String code = txtfCode.getText();
                    String titre = txtfTitre.getText();
                    String auteur = cBox_Auteur.getItemAt(cBox_Auteur.getSelectedIndex());
                    String anneePublication = txtfPublication.getText();
                    String ISBN = txtfISBN.getText();
                    String nbPages = txtfNbPages.getText();
                    String dateAchat = txtfDateAchat.getText();
                    String anneeEdition = txtfEdition.getText();
                    
                    // Vérifier si un ou plusieurs champs sont vide
                    if (code.isEmpty() || titre.isEmpty() || auteur.isEmpty()  || anneePublication.isEmpty()  ||  ISBN.isEmpty() ||  nbPages.isEmpty() ||  dateAchat.isEmpty()||  anneeEdition.isEmpty()) {
                        throw new Exception("Tous les champs doivent être remplis.");
                    }
                    
                    // Vérification du format de la date (YYYY-MM-DD)
                    if (!dateAchat.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        throw new Exception("La date d'achat doit être au format YYYY-MM-DD.");
                    }
                    
                    LivreDAO livreDAO = new LivreDAO();
		            System.out.println("Coucou 2");
		            Livre livre = livreDAO.getLivreByCode(code);
		            
                    if (livre != null) {
                    	Livre editedBook = new Livre(code,titre,auteurDAO.getAuteurByNom(auteur),Integer.parseInt(anneePublication), ISBN, Integer.parseInt(nbPages), dateAchat, Integer.parseInt(anneeEdition));
                    	livreDAO.updateLivre(editedBook);
                    }
                    
                   
                    JOptionPane.showMessageDialog(null, "Livre modifié avec succès!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erreur lors de la modification du livre: " + ex.getMessage());
                }
			}
		});
		btnModifier.setBounds(327, 155, 117, 29);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String code = txtfCode.getText();
		            
		            // Vérifier si le champ 'nom' est vide
		            if (code.isEmpty()) {
		                throw new Exception("Le code est nécessaire pour la suppresion.");
		            }

		            LivreDAO livreDAO = new LivreDAO();
		            System.out.println("Coucou 2");
		            Livre livre = livreDAO.getLivreByCode(code);
		            
		            // Vérifier si l'auteur a été trouvé
		            if (livre != null) {
		                txtfCode.setText("");
	                    txtfTitre.setText("");
	                    //cBox_Auteur.getItemAt(cBox_Auteur.getSelectedIndex());
	                    txtfPublication.setText("");
	                    txtfISBN.setText("");
	                    txtfNbPages.setText("");
	                    txtfDateAchat.setText("");
	                    txtfEdition.setText("");
	                    livreDAO.supprimerLivre(code);
	                    
		                JOptionPane.showMessageDialog(null, "Livre supprimé avec succès.");
		            } else {
		                JOptionPane.showMessageDialog(null, "Aucun livre trouvé avec ce code.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Erreur lors de la suppresion du livre : " + ex.getMessage());
		        }
			}
		});
		btnSupprimer.setBounds(327, 183, 117, 29);
		contentPane.add(btnSupprimer);
	}
}
