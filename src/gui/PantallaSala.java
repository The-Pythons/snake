package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class PantallaSala extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField nombreField;
	private JList<String> listaSalas;

	public PantallaSala() {
		setResizable(false);

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(0, 102, 0));
		contentPane.setLayout(null);

		JLabel lblCrearSala = new JLabel("CREAR SALA");
		lblCrearSala.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrearSala.setBounds(10, 31, 155, 28);
		contentPane.add(lblCrearSala);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setForeground(new Color(255, 255, 0));
		lblNombre.setBounds(10, 73, 73, 14);
		contentPane.add(lblNombre);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setForeground(new Color(255, 255, 0));
		lblContrasea.setBounds(10, 98, 89, 14);
		contentPane.add(lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setBounds(104, 97, 71, 19);
		contentPane.add(passwordField);

		nombreField = new JTextField();
		nombreField.setBounds(104, 70, 71, 19);
		contentPane.add(nombreField);

		JButton btnAadirSala = new JButton("A\u00F1adir Sala");
		btnAadirSala.setBounds(36, 132, 105, 23);
		contentPane.add(btnAadirSala);

		JLabel lblSalasActuales = new JLabel("Salas Actuales");
		lblSalasActuales.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalasActuales.setForeground(new Color(255, 204, 0));
		lblSalasActuales.setBounds(300, 31, 105, 14);
		contentPane.add(lblSalasActuales);

		JLabel lblMultijugador = new JLabel("MULTIJUGADOR");
		lblMultijugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultijugador.setForeground(new Color(255, 0, 0));
		lblMultijugador.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		lblMultijugador.setBounds(105, 0, 204, 45);
		contentPane.add(lblMultijugador);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(314, 228, 91, 23);
		contentPane.add(btnActualizar);

		JScrollPane scrollPane = new JScrollPane(listaSalas);
		scrollPane.setBounds(284, 69, 140, 156);
		contentPane.add(scrollPane);

		listaSalas = new JList<String>();
//		listaSalas.setBounds(284, 69, 140, 156);
		contentPane.add(listaSalas);

		setVisible(true);
	}
}
