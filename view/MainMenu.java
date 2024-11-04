package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setTitle("Appli_Bibliobus");
		setBackground(new Color(45, 15, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 55, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAbout = new JButton("A propos...");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About aboutView = new About();
				aboutView.setVisible(true);
			}
		});
		btnAbout.setBounds(6, 467, 253, 29);
		contentPane.add(btnAbout);

		JButton btnAuteurs = new JButton("AUTEURS");
		btnAuteurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAuteurs auteursView = new GestionAuteurs();
				auteursView.setVisible(true);
			}
		});
		btnAuteurs.setBounds(6, 77, 253, 50);
		contentPane.add(btnAuteurs);

		JButton btnLivres = new JButton("LIVRES");
		btnLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionLivres livresView = new GestionLivres();
				livresView.setVisible(true);
			}
		});
		btnLivres.setBounds(6, 139, 253, 50);
		contentPane.add(btnLivres);

		JButton btnEmprunts = new JButton("EMPRUNTS");
		btnEmprunts.setBounds(6, 201, 253, 50);
		contentPane.add(btnEmprunts);

		JButton btnAdherents = new JButton("ADHERENTS");
		btnAdherents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAdherents adherentView = new GestionAdherents();
				adherentView.setVisible(true);
			}
		});
		btnAdherents.setBounds(6, 263, 253, 50);
		contentPane.add(btnAdherents);

		JButton btnBack = new JButton("RETOURS");
		btnBack.setBounds(6, 325, 253, 50);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("Le BIBLIOBUS");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(249, 255, 251));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 253, 50);
		contentPane.add(lblNewLabel);
	}

}
