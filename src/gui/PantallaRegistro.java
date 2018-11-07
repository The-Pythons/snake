package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaRegistro {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegistro window = new PantallaRegistro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 255, 0));
		frame.getContentPane().setBackground(new Color(0, 102, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setForeground(new Color(255, 0, 0));
		lblRegistro.setFont(new Font("Viner Hand ITC", Font.PLAIN, 40));
		lblRegistro.setBounds(90, 23, 243, 86);
		frame.getContentPane().add(lblRegistro);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setForeground(new Color(255, 255, 0));
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreUsuario.setBounds(44, 148, 142, 14);
		frame.getContentPane().add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 255, 0));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasea.setBounds(44, 175, 97, 14);
		frame.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(196, 140, 86, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(196, 172, 86, 25);
		frame.getContentPane().add(passwordField);
		
		JButton btnRegistrate = new JButton("Registrate!");
		btnRegistrate.setBounds(108, 217, 89, 23);
		frame.getContentPane().add(btnRegistrate);
	}

}
