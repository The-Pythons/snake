package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElegirEscenario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirEscenario frame = new ElegirEscenario();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ElegirEscenario() {
		setTitle("Elegir escenario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 600, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblElegirEscenario = new JLabel("ELEGIR ESCENARIO");
		lblElegirEscenario.setBounds(0, 0, 600, 125);
		contentPane.add(lblElegirEscenario);
		lblElegirEscenario.setFont(new Font("Comic sans", 0, 20));
		lblElegirEscenario.setHorizontalAlignment(SwingConstants.CENTER);		
		
		JLabel labelArena = new JLabel("Arena");
		labelArena.setBounds(25, 125, 250, 200);
		contentPane.add(labelArena);
		labelArena.setIcon(new ImageIcon("recursos/arena.jpg"));
		
		JButton btnArena = new JButton("Arena");
		btnArena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameFirstClass.fondo = "arena";
				Container frame = btnArena.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
		});
		btnArena.setBounds(25, 350, 250, 30);
		contentPane.add(btnArena);

		JLabel labelHierba = new JLabel("Hierba");
		labelHierba.setBounds(325, 125, 250, 200);
		contentPane.add(labelHierba);
		labelHierba.setIcon(new ImageIcon("recursos/hierba.jpg"));
		
		JButton btnHierba = new JButton("Hierba");
		btnHierba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameFirstClass.fondo = "hierba";
				Container frame = btnHierba.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
		});
		btnHierba.setBounds(325, 350, 250, 30);
		contentPane.add(btnHierba);

		JLabel labelMadera = new JLabel("Madera");
		labelMadera.setBounds(25, 425, 250, 200);
		contentPane.add(labelMadera);
		labelMadera.setIcon(new ImageIcon("recursos/madera.jpg"));
		
		JButton btnMadera = new JButton("Madera");
		btnMadera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameFirstClass.fondo = "madera";
				Container frame = btnMadera.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
		});
		btnMadera.setBounds(25, 650, 250, 30);
		contentPane.add(btnMadera);

		JLabel labelTierra = new JLabel("Tierra");
		labelTierra.setBounds(325, 425, 250, 200);
		contentPane.add(labelTierra);
		labelTierra.setIcon(new ImageIcon("recursos/tierra.jpg"));
		
		JButton btnTierra = new JButton("Tierra");
		btnTierra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameFirstClass.fondo = "tierra";
				Container frame = btnTierra.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
		});
		btnTierra.setBounds(325, 650, 250, 30);
		contentPane.add(btnTierra);
		
	}
}
