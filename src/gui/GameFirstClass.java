package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import logica.Dibujable;
import logica.Escenario;
import logica.Punto2D;
import snake.Orientacion;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameFirstClass extends JFrame {

	Timer tiempo;
	TimerTask tarea;
	
	// Variables

	int y, x, dir;
	static final int N = 1;
	static final int S = -1;
	static final int O = -2;
	static final int E = 2;
	
	//private Image dbImage;
	//private Graphics dbg;
	private AL controles;
	Escenario escenario; 
	private JPanelGrafico contentPane;
	private final JButton btnNewButton = new JButton("New button");

	// Window Basics
	public GameFirstClass() {
	
		setTitle("Prueba de teclas");
		setBounds(100, 100, 400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		escenario = new Escenario(40,37);
		addKeyListener(new AL(escenario));
		escenario.start();
		JPanelGrafico contentPane = new JPanelGrafico(escenario);
		setContentPane(contentPane);
		//escenario = new Escenario(40, 40);
		//escenario.start();
		contentPane.setLayout(null);
	


		//repaint();
		
		
	}
	public void repintar() {
		long tf,ti;
		while(true)
		{
			ti = System.currentTimeMillis();
			repaint();
			try {
			tf = System.currentTimeMillis();
			Thread.sleep(17-(tf-ti));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
		}
	
	
	
	// main
	public static void main(String[] args) {
		GameFirstClass g =new GameFirstClass();
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