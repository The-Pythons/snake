package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mensajes.MsjSala;
import mensajes.MsjSalida;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class PantallaSeleccionSala extends JFrame {

	private Fondo contentPane;
	private JPasswordField passwordField;
	private JTextField nombreField;
	private JList<String> listaSalas;
	private DefaultListModel<String> modelo;
	private PantallaInicio inicio;
	private String clave;
	private String sala;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;

	public PantallaSeleccionSala(PantallaInicio inicio) {
		this.inicio = inicio;
		this.salida = inicio.getSalida();
		this.entrada = inicio.getEntrada();
		
		//this.entrada = inicio.getConex();

		setResizable(false);

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				inicio.setVisible(true);
			}
		});
		contentPane = new Fondo();
		contentPane.setBackground("recursos\\FondoSala.png");
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(0, 102, 0));
		contentPane.setLayout(null);

		JLabel lblCrearSala = new JLabel("SALAS");
		lblCrearSala.setFont(new Font("GROBOLD", Font.BOLD, 20));
		lblCrearSala.setBounds(185, 24, 89, 25);
		contentPane.add(lblCrearSala);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setBounds(55, 73, 73, 14);
		contentPane.add(lblNombre);

		JLabel lblContrasea = new JLabel("Contrase�a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setBounds(55, 98, 89, 14);
		contentPane.add(lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setBounds(149, 97, 71, 19);
		passwordField.setText("123");
		contentPane.add(passwordField);

		nombreField = new JTextField();
		nombreField.setBounds(149, 70, 71, 19);
		nombreField.setText("Sala1");
		contentPane.add(nombreField);

		JButton btnAadirSala = new JButton("A�adir Sala");
		btnAadirSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					salaNueva();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAadirSala.setBounds(36, 132, 105, 23);
		contentPane.add(btnAadirSala);

		JLabel lblSalasActuales = new JLabel("Salas Actuales");
		lblSalasActuales.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalasActuales.setForeground(new Color(0, 0, 0));
		lblSalasActuales.setBounds(300, 52, 105, 14);
		contentPane.add(lblSalasActuales);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();
			}
		});
		btnActualizar.setBounds(314, 228, 91, 23);
		contentPane.add(btnActualizar);

		listaSalas = new JList<String>();
		listaSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					seleccionarSala(listaSalas.getSelectedValue());
				}
			}
		});
		listaSalas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel<String>();
		
		listaSalas.setModel(modelo);

		JScrollPane scrollPane = new JScrollPane(listaSalas);
		scrollPane.setBounds(284, 69, 140, 156);
		scrollPane.setViewportView(listaSalas);
		contentPane.add(scrollPane);

		JButton btnIngrersar = new JButton("Ingresar");
		btnIngrersar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ingresar();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnIngrersar.setBounds(151, 132, 100, 23);
		contentPane.add(btnIngrersar);

		setLocationRelativeTo(inicio);
		setVisible(true);
	}

	protected void ingresar() throws Exception {
		char[] claveTxt = passwordField.getPassword();
		clave = new String(claveTxt);
		sala = new String(nombreField.getText());
		if (sala.equals("") || clave.equals("")) {
			JOptionPane.showMessageDialog(null, "Ingresa una sala y contrase�a", "ATENCION!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			salida.writeObject(new MsjSala(sala, clave, false, true, false));
			MsjSalida respuesta = (MsjSalida) entrada.readObject();
			if (!respuesta.isRespuesta()) {
				JOptionPane.showMessageDialog(null, respuesta.getDetalleError(), "ERROR",
						JOptionPane.INFORMATION_MESSAGE);
			}
			// if (!verificarSalaBD()) {
			// JOptionPane.showMessageDialog(null, "Sala o clave incorrecta",
			// "ATENCION!",
			// JOptionPane.INFORMATION_MESSAGE);
			// }
			else {
				setVisible(false);
				new PantallaSala(this, sala, inicio.getUsuario());
			}
		}

	}

//	private boolean verificarSalaBD() {
//		if (sala.equals("Sala1") && clave.equals("123"))
//			return true;
//		return false;
//	}

	protected void actualizar() {

	}

	private void salaNueva() throws Exception {
		char[] claveTxt = passwordField.getPassword();
		clave = new String(claveTxt);
		sala = new String(nombreField.getText());
		if (sala.equals("") || clave.equals("")) {
			JOptionPane.showMessageDialog(null, "Ingresa una sala y contrase�a", "ATENCION!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			salida.writeObject(new MsjSala(sala, clave, true, false, false));
			MsjSalida respuesta = (MsjSalida) entrada.readObject();
			if (!respuesta.isRespuesta()) {
				JOptionPane.showMessageDialog(null, respuesta.getDetalleError(), "ERROR",
						JOptionPane.INFORMATION_MESSAGE);
			}
//			if (verificarNuevaSalaBD()) {
//				JOptionPane.showMessageDialog(null, "Sala ya registrada", "ATENCION!", JOptionPane.INFORMATION_MESSAGE);
//			} 
			else {
				modelo.addElement(sala);
			}
		}
	}

//	private boolean verificarNuevaSalaBD() {
//		return modelo.contains(sala);
//	}

	public void seleccionarSala(String seleccionado) {
		sala = seleccionado;
		nombreField.setText(sala);
	}

	public String getSala() {
		return sala;
	}
	
	public PantallaInicio getInicio() {
		return inicio;
	}

	public void eliminarSala(String sala) {
		modelo.removeElement(sala);
		setVisible(true);
	}

}
