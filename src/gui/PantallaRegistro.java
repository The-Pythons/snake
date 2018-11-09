package gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRegistro extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private PantallaInicio inicio;

	public PantallaRegistro(PantallaInicio inicio) {
		setModal(true);
		this.inicio = inicio;
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();

		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setForeground(new Color(255, 255, 0));
		contentPane.setBackground(new Color(0, 102, 0));
		contentPane.setLayout(null);

		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setForeground(new Color(255, 0, 0));
		lblRegistro.setFont(new Font("Viner Hand ITC", Font.PLAIN, 40));
		lblRegistro.setBounds(90, 23, 243, 86);
		contentPane.add(lblRegistro);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setForeground(new Color(255, 255, 0));
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreUsuario.setBounds(100, 128, 142, 14);
		contentPane.add(lblNombreUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 255, 0));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasea.setBounds(100, 155, 97, 14);
		contentPane.add(lblContrasea);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(252, 120, 86, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(252, 152, 86, 25);
		contentPane.add(passwordField);

		JButton btnRegistrate = new JButton("Registrate!");
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrate.setBounds(180, 212, 97, 23);
		contentPane.add(btnRegistrate);

		setLocationRelativeTo(inicio);
		setVisible(true);
	}

	private void registrar() {
		char[] claveTxt = passwordField.getPassword();
		String clave = new String(claveTxt);
		String usuario = new String(textField.getText());
		if (usuario.equals("") || clave.equals("")) {
			JOptionPane.showMessageDialog(null, "Ingresa un usuario y contraseña", "ATENCION!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (verificarEnBD(usuario))
				JOptionPane.showMessageDialog(null, "Usuario ya registrado", "ATENCION!",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				inicio.escribirUsuarioClave(usuario, clave);
				dispose();
			}
		}
	}

	private boolean verificarEnBD(String usuario) {
		if (usuario.equals("juan"))
			return true;
		return false;
	}

}
