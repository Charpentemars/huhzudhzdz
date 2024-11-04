package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GestionEmprunts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtF_CodeAdherent;
	private JTextField txtF_CodeLivre1;
	private JTextField txtF_CodeLivre2;
	private JTextField txtF_CodeLivre3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionEmprunts frame = new GestionEmprunts();
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
	public GestionEmprunts() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 499, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Gestion des Emprunts");
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 21));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(6, 6, 504, 16);
		contentPane.add(lblTitle);

		JLabel lblNumAdhérent = new JLabel("Numéro Emprunt:");
		lblNumAdhérent.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNumAdhérent.setBounds(297, 56, 130, 16);
		contentPane.add(lblNumAdhérent);
		
		JLabel lblCodeAdherent = new JLabel("Code adhérent :");
		lblCodeAdherent.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCodeAdherent.setBounds(6, 56, 114, 16);
		contentPane.add(lblCodeAdherent);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(36, 84, 45, 16);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(36, 103, 61, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblCodeLivre1 = new JLabel("Code livre 1 :");
		lblCodeLivre1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCodeLivre1.setBounds(6, 131, 101, 16);
		contentPane.add(lblCodeLivre1);
		
		JLabel lblTitreLivre1 = new JLabel("Titre du livre :");
		lblTitreLivre1.setBounds(36, 150, 95, 16);
		contentPane.add(lblTitreLivre1);
		
		JLabel lblTitreLivre2 = new JLabel("Titre du livre :");
		lblTitreLivre2.setBounds(36, 197, 95, 16);
		contentPane.add(lblTitreLivre2);
		
		JLabel lblCodeLivre2 = new JLabel("Code livre 2 :");
		lblCodeLivre2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCodeLivre2.setBounds(6, 178, 101, 16);
		contentPane.add(lblCodeLivre2);
		
		JLabel lblCodeLivre3 = new JLabel("Code livre 3 :");
		lblCodeLivre3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCodeLivre3.setBounds(6, 225, 101, 16);
		contentPane.add(lblCodeLivre3);
		
		JLabel lblTitreLivre3 = new JLabel("Titre du livre :");
		lblTitreLivre3.setBounds(36, 244, 95, 16);
		contentPane.add(lblTitreLivre3);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(6, 276, 153, 29);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(171, 276, 153, 29);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(336, 276, 153, 29);
		contentPane.add(btnSupprimer);
		
		txtF_CodeAdherent = new JTextField();
		txtF_CodeAdherent.setBounds(132, 52, 130, 26);
		contentPane.add(txtF_CodeAdherent);
		txtF_CodeAdherent.setColumns(10);
		
		txtF_CodeLivre1 = new JTextField();
		txtF_CodeLivre1.setColumns(10);
		txtF_CodeLivre1.setBounds(119, 127, 130, 26);
		contentPane.add(txtF_CodeLivre1);
		
		txtF_CodeLivre2 = new JTextField();
		txtF_CodeLivre2.setColumns(10);
		txtF_CodeLivre2.setBounds(119, 174, 130, 26);
		contentPane.add(txtF_CodeLivre2);
		
		txtF_CodeLivre3 = new JTextField();
		txtF_CodeLivre3.setColumns(10);
		txtF_CodeLivre3.setBounds(119, 221, 130, 26);
		contentPane.add(txtF_CodeLivre3);
		
		JLabel lblNumEmpruntAffichage = new JLabel("0123456");
		lblNumEmpruntAffichage.setBounds(428, 57, 61, 16);
		contentPane.add(lblNumEmpruntAffichage);
		
		JLabel lblNomAffichage = new JLabel("?????????");
		lblNomAffichage.setBounds(93, 84, 396, 16);
		contentPane.add(lblNomAffichage);
		
		JLabel lblPrenomAffichage = new JLabel("?????????");
		lblPrenomAffichage.setBounds(109, 103, 380, 16);
		contentPane.add(lblPrenomAffichage);
		
		JLabel lblTitreAffichage1 = new JLabel("?????????");
		lblTitreAffichage1.setBounds(143, 150, 346, 16);
		contentPane.add(lblTitreAffichage1);
		
		JLabel lblTitreAffichage2 = new JLabel("?????????");
		lblTitreAffichage2.setBounds(143, 197, 346, 16);
		contentPane.add(lblTitreAffichage2);
		
		JLabel lblTitreAffichage3 = new JLabel("?????????");
		lblTitreAffichage3.setBounds(143, 244, 346, 16);
		contentPane.add(lblTitreAffichage3);
	}
}
