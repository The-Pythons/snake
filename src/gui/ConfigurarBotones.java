package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConfigurarBotones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int dirIzq = KeyEvent.VK_LEFT;
	int dirDer = KeyEvent.VK_RIGHT;
	int dirArriba = KeyEvent.VK_UP;
	int dirAbajo = KeyEvent.VK_DOWN;
	boolean keyset= false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarBotones frame = new ConfigurarBotones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public ConfigurarBotones() {
		setTitle("Configuracion de Botones");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 247);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIzquierda = new JButton("Izquierda");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyset=false;
			}
		});
		btnIzquierda.setBounds(41, 39, 89, 23);
		contentPane.add(btnIzquierda);
		
		JButton btnDerecha = new JButton("Derecha");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyset=false;
			}
		});
		btnDerecha.setBounds(41, 73, 89, 23);
		contentPane.add(btnDerecha);
		
		JButton btnArriba = new JButton("Arriba");
		btnArriba.setBounds(41, 107, 89, 23);
		contentPane.add(btnArriba);
		btnArriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyset=false;
			}
		});
		JButton btnAbajo = new JButton("Abajo");
		btnAbajo.setBounds(41, 141, 89, 23);
		contentPane.add(btnAbajo);
		btnAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyset=false;
			}
		});
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dirArriba == dirAbajo || dirArriba == dirIzq || dirArriba == dirDer
					|| dirAbajo == dirIzq || dirAbajo == dirDer || dirIzq == dirDer) {
					JOptionPane.showMessageDialog(null, "Hay teclas repetidas", "ATENCION!",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				AL.cambiarDirecciones(dirArriba, dirAbajo, dirIzq, dirDer);
	            Container frame = btnAceptar.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
		});		
		btnAceptar.setBounds(320, 141, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            Container frame = btnCancelar.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
			}
		});		
		btnCancelar.setBounds(320, 107, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel labelzquierda = new JLabel(KeyEvent.getKeyText(AL.dirIzq));
		labelzquierda.setBounds(194, 43, 74, 14);
		contentPane.add(labelzquierda);
		
		JLabel labelDerecha = new JLabel(KeyEvent.getKeyText(AL.dirDer));
		labelDerecha.setBounds(194, 77, 74, 14);
		contentPane.add(labelDerecha);
		
		JLabel labelArriba = new JLabel(KeyEvent.getKeyText(AL.dirArriba));
		labelArriba.setBounds(194, 111, 74, 14);
		contentPane.add(labelArriba);
		
		JLabel labelAbajo = new JLabel(KeyEvent.getKeyText(AL.dirAbajo));
		labelAbajo.setBounds(194, 145, 74, 14);
		contentPane.add(labelAbajo);
		
		btnIzquierda.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				if(!keyset){
				dirIzq = evt.getKeyCode();
				keyset=true;
				}
				labelzquierda.setText(KeyEvent.getKeyText(dirIzq));
			}
		});
		
		btnDerecha.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				if(!keyset){
					dirDer = evt.getKeyCode();
					keyset=true;
					}
				labelDerecha.setText(KeyEvent.getKeyText(dirDer));
			}
		});
		
		btnArriba.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				if(!keyset){
					dirArriba = evt.getKeyCode();
					keyset=true;
					}
				labelArriba.setText(KeyEvent.getKeyText(dirArriba));
			}
		});
		
		btnAbajo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				if(!keyset){
					dirAbajo = evt.getKeyCode();
					keyset=true;
					}
				labelAbajo.setText(KeyEvent.getKeyText(dirAbajo));
			}
		});
		
			
		
	}
	
	public int keyPressed(KeyEvent event) {
		
		return event.getKeyCode();
	}
}
