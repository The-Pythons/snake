package gui;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

import snake.Fondo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PantallaInicio {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio window = new PantallaInicio();
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
	public PantallaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 0));
		frame.setForeground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Fondo contentPane = new Fondo();
		contentPane.setBackground("snake-306109_960_720.png");
		frame.setContentPane(contentPane);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario_1 = new JLabel("Usuario");
		lblUsuario_1.setForeground(Color.GRAY);
		lblUsuario_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario_1.setBounds(103, 108, 67, 14);
		frame.getContentPane().add(lblUsuario_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.GRAY);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(103, 133, 83, 14);
		frame.getContentPane().add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(190, 105, 86, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setHorizontalAlignment(SwingConstants.CENTER);
		txtClave.setBounds(190, 133, 86, 20);
		frame.getContentPane().add(txtClave);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char []clave = txtClave.getPassword();
				String claveFinal = new String(clave);
				if(txtUsuario.getText().equals("") || claveFinal.equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresa un usuario y contrase�a", "ATENCION!", JOptionPane.INFORMATION_MESSAGE);
				}else {
				if(txtUsuario.getText().equals("juan") && claveFinal.equals("123")) {
				frame.setVisible(false);
				PantallaSala s = new PantallaSala();
				s.frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrecto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					txtUsuario.setText("");
					txtClave.setText("");
					txtUsuario.requestFocus();
					
				}
				}
				
			}
		});
		btnIngresar.setBounds(190, 164, 89, 23);
		frame.getContentPane().add(btnIngresar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaRegistro r = new PantallaRegistro();
				frame.setVisible(false);
				r.frame.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(0, 239, 101, 23);
		frame.getContentPane().add(btnRegistrarse);
		
		JLabel lblNoTienesUna = new JLabel("No tienes una cuenta? Registrate!");
		lblNoTienesUna.setForeground(new Color(255, 255, 255));
		lblNoTienesUna.setBounds(0, 224, 256, 14);
		frame.getContentPane().add(lblNoTienesUna);
		
		JLabel lblSnake = new JLabel("SNAKE");
		lblSnake.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnake.setForeground(Color.BLACK);
		lblSnake.setFont(new Font("Viner Hand ITC", Font.PLAIN, 40));
		lblSnake.setBounds(140, 22, 165, 54);
		frame.getContentPane().add(lblSnake);
		
		JLabel lblJuegoLocal = new JLabel("JUEGO LOCAL");
		lblJuegoLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuegoLocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJuegoLocal.setForeground(new Color(0, 0, 0));
		lblJuegoLocal.setBounds(338, 183, 75, 14);
		frame.getContentPane().add(lblJuegoLocal);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.GRAY);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(271, 211, 57, 14);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(338, 208, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(338, 239, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
