package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PantallaSala extends JFrame {

	private JPanel contentPane;
	private PantallaSeleccionSala seleccionSala;
	private JList<String> listaUsuarios;
	private DefaultListModel<String> modelo;
	private String sala;
	private String usuario;

	public PantallaSala(PantallaSeleccionSala seleccionSala, String sala, String usuario) {
		this.seleccionSala = seleccionSala;
		this.sala = sala;
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(seleccionSala);

		listaUsuarios = new JList<String>();
		modelo = new DefaultListModel<String>();
		modelo.addElement("Usuario1");
		modelo.addElement("Usuario2");
		modelo.addElement("Usuario3");
		listaUsuarios.setModel(modelo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 80, 140, 156);
		scrollPane.setViewportView(listaUsuarios);
		contentPane.add(scrollPane);

		JLabel label = new JLabel("Usuarios");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(325, 55, 55, 14);
		contentPane.add(label);

		JButton ListoButton = new JButton("Listo");
		ListoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listo();
			}
		});
		ListoButton.setBounds(68, 95, 89, 23);
		contentPane.add(ListoButton);

		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(68, 138, 89, 23);
		contentPane.add(btnJugar);

		JButton btnEliminarSala = new JButton("Eliminar Sala");
		btnEliminarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			eliminarSala();
			}
		});
		btnEliminarSala.setBounds(55, 227, 118, 23);
		contentPane.add(btnEliminarSala);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 37));
		lblSala.setBounds(10, 11, 101, 43);
		contentPane.add(lblSala);

		JLabel lblNombresala = new JLabel(seleccionSala.getSala());
		lblNombresala.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 38));
		lblNombresala.setBounds(97, 13, 216, 38);
		contentPane.add(lblNombresala);

		setVisible(true);
	}

	protected void eliminarSala() {
		seleccionSala.eliminarSala(sala);
		dispose();
	}

	protected void listo() {
		if (!modelo.contains(usuario)) {
			modelo.addElement(usuario);
		}

	}
}
