package gui;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import logica.Escenario;

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

	// Window Basics
	public GameFirstClass() {

		setTitle("Snake");
		setBounds(100, 100, 600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.escenario = new Escenario(30, 24);
		this.controles = new AL(escenario);
		addKeyListener(this.controles);
		//escenario.start();
		//this.contentPane = new JPanelGrafico(escenario, new ImageIcon("recursos/clover.jpg").getImage());
		this.contentPane = new JPanelGrafico(escenario, new ImageIcon("recursos/arena.jpg").getImage());
		setContentPane(this.contentPane);
		contentPane.setLayout(null);

	}

	public void repintar() {
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

	// main
	public static void main(String[] args) {
		GameFirstClass g = new GameFirstClass();
		g.setVisible(true);
		g.repintar();
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