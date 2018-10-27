package io;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class GameFirstClass extends JFrame {

	Timer tiempo;
	TimerTask tarea;
	
	// Variables

	int y, x, dir;
	static final int N = 1;
	static final int S = -1;
	static final int O = -2;
	static final int E = 2;
	
	private Image dbImage;
	private Graphics dbg;

	// Window Basics
	public GameFirstClass() {
		addKeyListener(new AL());
		setTitle("Prueba de teclas");
		setSize(800, 800);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x = 400;
		y = 400;	
	}
	// main

	public static void main(String[] args) {
		new GameFirstClass();
	}

	// Controls
	public class AL extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			if (keyCode == event.VK_LEFT) {
				dir = O;
			}
			if (keyCode == event.VK_RIGHT) {
				dir = E;
			}
			if (keyCode == event.VK_UP) {
				dir = N;
			}
			if (keyCode == event.VK_DOWN) {
				dir = S;
			}
		}

		@Override
		public void keyReleased(KeyEvent event) {
		}
	}
	// Double Buffer

	@Override
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void paintComponent(Graphics g) {
		g.fillOval(x, y, 15, 15);
		tarea = new TimerTask() {
			@Override
			public void run() {
				switch (dir) {
				case N:
					y-=10;
					break;
				case S:
					y+=10;
					break;
				case O:
					x-=10;
					break;
				default:
					x+=10;
					break;
				}
				repaint();
			}
		};
		tiempo = new Timer();
		//tiempo.scheduleAtFixedRate(tarea, 0, 2000);
		tiempo.schedule(tarea, 200);
	}
}