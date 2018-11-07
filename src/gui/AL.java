package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import logica.Escenario;
import snake.Orientacion;


	public class AL extends KeyAdapter {
		Orientacion dir ;
		Escenario e;
		@Override
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			if (keyCode == event.VK_LEFT) {
				dir = Orientacion.E;
				e.girarSerpiente(0, dir);
			}
			if (keyCode == event.VK_RIGHT) {
				dir = Orientacion.O;
				e.girarSerpiente(0, dir);
			}
			if (keyCode == event.VK_UP) {
				dir = Orientacion.N;
				e.girarSerpiente(0, dir);
			}
			if (keyCode == event.VK_DOWN) {
				dir = Orientacion.S;
				e.girarSerpiente(0, dir);
			}
		}
		public Orientacion getDir() {
			return dir;
		}
		public AL(Escenario e) {
			this.e=e;
		}

		@Override
		public void keyReleased(KeyEvent event) {
		}
	}

