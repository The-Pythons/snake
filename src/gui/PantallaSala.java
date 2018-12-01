package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mensajes.MsjEstoylisto;
import mensajes.MsjSala;
import mensajes.MsjSalida;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PantallaSala extends JFrame {

	private Fondo contentPane;
	private PantallaSeleccionSala seleccionSala;
	private JList<String> listaUsuarios;
	private DefaultListModel<String> modelo;
	private String sala;
	private String usuario;
	private ObjectOutputStream salida;
	private ConexionCliente entrada;

	public PantallaSala(PantallaSeleccionSala seleccionSala, String sala, String usuario) {
		this.seleccionSala = seleccionSala;
		this.salida = seleccionSala.getInicio().getSalida();
		this.entrada = seleccionSala.getInicio().getConex();
		this.sala = sala;
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new Fondo();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBackground("recursos\\Fondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(seleccionSala);

		listaUsuarios = new JList<String>();
		modelo = new DefaultListModel<String>();
		listaUsuarios.setModel(modelo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 80, 140, 156);
		scrollPane.setViewportView(listaUsuarios);
		contentPane.add(scrollPane);

		JLabel label = new JLabel("Usuarios");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(323, 62, 55, 14);
		contentPane.add(label);

		JButton ListoButton = new JButton("Listo");
		ListoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					try {
						listo();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ListoButton.setBounds(131, 118, 89, 23);
		contentPane.add(ListoButton);

//		JButton btnJugar = new JButton("Jugar");
//		btnJugar.setBounds(131, 152, 89, 23);
//		contentPane.add(btnJugar);

		JButton btnEliminarSala = new JButton("Eliminar Sala");
		btnEliminarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			eliminarSala();
			}
		});
		btnEliminarSala.setBounds(121, 227, 118, 23);
		contentPane.add(btnEliminarSala);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 37));
		lblSala.setBounds(75, 11, 101, 43);
		contentPane.add(lblSala);

		JLabel lblNombresala = new JLabel(seleccionSala.getSala());
		lblNombresala.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 38));
		lblNombresala.setBounds(162, 13, 216, 38);
		contentPane.add(lblNombresala);

		setVisible(true);
	}

	protected void eliminarSala() {
		seleccionSala.eliminarSala(sala);
		dispose();
	}

	protected void listo() throws IOException, ClassNotFoundException {
		salida.writeObject(new MsjEstoylisto(true));
		
		// recivir el mensaje y jugar;
		if (!modelo.contains(usuario)) {
			modelo.addElement(usuario);
		}
		MsjSalida msj;
		msj = (MsjSalida)entrada.entrada.readObject();
		if(msj.isRespuesta())
			new GameFirstClass(this.entrada,this.salida);

	}
}
