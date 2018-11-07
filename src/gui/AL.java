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
			if (keyCode == KeyEvent.VK_LEFT) {
				if(dir!=Orientacion.O){
					dir = Orientacion.E;
					e.girarSerpiente(0, dir);
				}
			}
			if (keyCode == KeyEvent.VK_RIGHT) {
				if(dir!=Orientacion.E){
					dir = Orientacion.O;
					e.girarSerpiente(0, dir);
				}
				
			}
			if (keyCode == KeyEvent.VK_UP) {
				if(dir!=Orientacion.S){
					dir = Orientacion.N;
					e.girarSerpiente(0, dir);
				}
			}
			if (keyCode == KeyEvent.VK_DOWN) {
				if(dir!=Orientacion.N){
					dir = Orientacion.S;
					e.girarSerpiente(0, dir);
				}
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

