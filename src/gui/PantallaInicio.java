package gui;

import javax.swing.*;

import io.HibernateApp;
import io.Usuario;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JFrame {

	private Fondo contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JTextField txtNombre;
	private String usuario;
	private String clave;
	GameFirstClass g; 
	
	public PantallaInicio() {
		setResizable(false);
		setForeground(new Color(0, 0, 0));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new Fondo();
		contentPane.setBackground("recursos\\Fondo.jpg");
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario_1 = new JLabel("Usuario");
		lblUsuario_1.setForeground(new Color(0, 0, 0));
		lblUsuario_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario_1.setBounds(113, 108, 67, 14);
		contentPane.add(lblUsuario_1);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(113, 136, 67, 14);
		contentPane.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setForeground(new Color(0, 0, 0));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(190, 105, 86, 20);
		txtUsuario.setText("");
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setHorizontalAlignment(SwingConstants.CENTER);
		txtClave.setBounds(190, 133, 86, 20);
		txtClave.setText("");
		contentPane.add(txtClave);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ingresar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnIngresar.setBounds(190, 164, 89, 23);
		contentPane.add(btnIngresar);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro();
			}
		});
		btnRegistrarse.setBounds(10, 229, 101, 23);
		contentPane.add(btnRegistrarse);

		JLabel lblSnake = new JLabel("SNAKE");
		lblSnake.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnake.setForeground(new Color(0, 0, 0));
		lblSnake.setFont(new Font("GROBOLD", Font.PLAIN, 40));
		lblSnake.setBounds(139, 43, 165, 54);
		contentPane.add(lblSnake);

		JLabel lblJuegoLocal = new JLabel("JUEGO LOCAL");
		lblJuegoLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuegoLocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJuegoLocal.setForeground(new Color(0, 0, 0));
		lblJuegoLocal.setBounds(335, 173, 75, 14);
		contentPane.add(lblJuegoLocal);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(268, 201, 57, 14);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(335, 198, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		PlayerThread elReproductor = new PlayerThread("./Audios/openingSnake.mp3");
		elReproductor.start();
		
		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elReproductor.stop();//Ver como hacerlo de otra forma...
				jugar();
			}
		});
		btnNewButton.setBounds(335, 229, 89, 23);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
//		setVisible(true);
	}
	
	private void ingresar() throws Exception {
		HibernateApp obj = new HibernateApp();
		Usuario user;
		usuario = txtUsuario.getText();
		char[] claveTxt = txtClave.getPassword();
		clave = new String(claveTxt);
		user = new Usuario(usuario,clave,false);
		if (usuario.equals("") || clave.equals("")) {
			JOptionPane.showMessageDialog(null, "Ingresa un usuario y contraseña", "ATENCION!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			user = obj.existeUsuario(usuario);
			if (user == null){
				JOptionPane.showMessageDialog(null, "El usuario y/o contraseña es/son incorrecta/s", "ERROR",
						JOptionPane.INFORMATION_MESSAGE);}
			else {
				if(!user.getPassword().equals(clave))
					JOptionPane.showMessageDialog(null, "El usuario y/o contraseña es/son incorrecta/s", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
				else{
					if(user.getLogState())
						JOptionPane.showMessageDialog(null, "El usuario ya se encuentra logueado", "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
					else
					{
						user.setLogState(true);
						obj.updateUsuario(user);
						setVisible(false);
						sala();
					}
				}
				txtUsuario.setText("");
				txtClave.setText("");
				txtUsuario.requestFocus();
			}
		}
	}

	private void registro() {
		new PantallaRegistro(this);
		char[] claveTxt = txtClave.getPassword();
		clave = new String(claveTxt);
		usuario = new String(txtUsuario.getText());
	}

	public void escribirUsuarioClave(String usuario, String clave) {
		txtUsuario.setText(usuario);
		txtClave.setText(clave);
	}

	private void sala() {
		new PantallaSeleccionSala(this);
	}

	private void jugar() {
		//Hay que ver bien donde va...
		String []canciones = new String[]{"./Audios/gameTheme1.mp3","./Audios/gameTheme2.mp3","./Audios/gameTheme3.mp3"};
		PlayerThread elReproductor = new PlayerThread(canciones[(int)(Math.random() * 3)]);
		elReproductor.start();
		
		g = new GameFirstClass();
		g.setVisible(true);
		}
	
	public String getUsuario() {
		return usuario;
	}

	public static void main(String[] args) {
		new PantallaInicio().setVisible(true);
	}

}
