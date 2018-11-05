package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import snake.Orientacion;


	public class AL extends KeyAdapter {
		Orientacion dir ;
		@Override
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			if (keyCode == event.VK_LEFT) {
				dir = Orientacion.O;
			}
			if (keyCode == event.VK_RIGHT) {
				dir = Orientacion.E;
			}
			if (keyCode == event.VK_UP) {
				dir = Orientacion.N;
			}
			if (keyCode == event.VK_DOWN) {
				dir = Orientacion.S;
			}
		}
		public Orientacion getDir() {
			return dir;
		}


		@Override
		public void keyReleased(KeyEvent event) {
		}
	}

