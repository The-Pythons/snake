package snake;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaSala {

	JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaSala window = new PantallaSala();
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
	public PantallaSala() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCrearSala = new JLabel("CREAR SALA");
		lblCrearSala.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrearSala.setBounds(10, 31, 155, 28);
		frame.getContentPane().add(lblCrearSala);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setForeground(new Color(255, 255, 0));
		lblNombre.setBounds(10, 73, 73, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setForeground(new Color(255, 255, 0));
		lblContrasea.setBounds(10, 98, 89, 14);
		frame.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 97, 71, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(104, 70, 71, 19);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnAadirSala = new JButton("A\u00F1adir Sala");
		btnAadirSala.setBounds(44, 123, 89, 23);
		frame.getContentPane().add(btnAadirSala);
		
		JLabel lblSalasActuales = new JLabel("Salas Actuales");
		lblSalasActuales.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalasActuales.setForeground(new Color(255, 204, 0));
		lblSalasActuales.setBounds(300, 31, 105, 14);
		frame.getContentPane().add(lblSalasActuales);
		
		JLabel lblMultijugador = new JLabel("MULTIJUGADOR");
		lblMultijugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultijugador.setForeground(new Color(255, 0, 0));
		lblMultijugador.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		lblMultijugador.setBounds(105, 0, 204, 45);
		frame.getContentPane().add(lblMultijugador);
		
		JList list = new JList();
		list.setBounds(284, 47, 140, 178);
		frame.getContentPane().add(list);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(314, 228, 89, 23);
		frame.getContentPane().add(btnActualizar);
	}
}
