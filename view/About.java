package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class About extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 450, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAboutTitle = new JLabel("À propos de l'appli Bibliobus");
		lblAboutTitle.setFont(new Font("Lucida Grande", Font.BOLD, 21));
		lblAboutTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutTitle.setBounds(6, 6, 438, 30);
		contentPane.add(lblAboutTitle);
		
		JLabel lblNewLabel = new JLabel("Nom du responsable : ...");
		lblNewLabel.setBounds(23, 82, 421, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdresseMairie = new JLabel("Adresse Mairie : ....");
		lblAdresseMairie.setBounds(23, 114, 421, 16);
		contentPane.add(lblAdresseMairie);
	}

}
