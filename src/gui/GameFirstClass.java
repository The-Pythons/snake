package gui;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import io.Usuario;
import logica.ConexionUsuario;
import logica.Escenario;
import logica.Sala;

public class GameFirstClass extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer tiempo;
	TimerTask tarea;

	// Variables
	int y, x, dir;
	private AL controles;
	Escenario escenario;
	private JPanelGrafico contentPane;
	
	///			INICIO AGREGAR EL PROYECTO
	
	static String fondo = "madera";

	///			FIN AGREGAR AL PROYECTO
	
	// Window Basics
	public GameFirstClass() {

		setTitle("Snake");
		setBounds(100, 100, 600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.escenario = new Escenario(30, 24);
		ConexionUsuario usuario= new ConexionUsuario();// solo para testeo
		this.controles = new AL(usuario);
		Sala sala = new Sala("Test",5);// solo para testeo
		sala.start();
		sala.nuevaSession(usuario); // solo para testeo
		addKeyListener(this.controles);
		//escenario.start();
		//this.contentPane = new JPanelGrafico(escenario, new ImageIcon("recursos/clover.jpg").getImage());

		//this.contentPane = new JPanelGrafico(sala.getEscenario(), new ImageIcon("recursos/arena.jpg").getImage());
		
		///		ESTA ES LA LINEA QUE VA. LAS ANTERIORES NO 
		
		this.contentPane = new JPanelGrafico(sala.getEscenario(), new ImageIcon("recursos/" + fondo + ".jpg").getImage());
		
		
		setContentPane(this.contentPane);
		contentPane.setLayout(null);
		new Repintar(this).start();;

	}

	/*public void repintar() {
		long tf, ti;
		while (true) {
			ti = System.currentTimeMillis();
			repaint();
			try {
				tf = System.currentTimeMillis();
				Thread.sleep(17 - (tf - ti));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
*/
	// main
	public static void main(String[] args) {
		GameFirstClass g = new GameFirstClass();
		g.setVisible(true);
		//g.repintar();
	}
	
	// Double Buffer
	/*@Override
	public void paint(Graphics g) {
		//dbImage = createImage(getWidth(), getHeight());
		//dbg = dbImage.getGraphics();
		paintComponent(dbg);
		//g.drawImage(dbImage, 0, 0, this);
	}*/
	
	public void paintComponent(Graphics g) {
		g.fillOval(x, y, 10, 10);
		tarea = new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		};
		tiempo = new Timer();
		//tiempo.scheduleAtFixedRate(tarea, 0, 2000);
		tiempo.schedule(tarea, 70);
	}
}