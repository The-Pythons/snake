package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import logica.Escenario;
import logica.Usuario;
import snake.Orientacion;


	public class AL extends KeyAdapter {
		Orientacion dir ;
		Usuario  u;
		@Override
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			if (keyCode == KeyEvent.VK_LEFT) {
				if(dir!=Orientacion.O){
					dir = Orientacion.E;
					u.setDir(dir);
				}
			}
			if (keyCode == KeyEvent.VK_RIGHT) {
				if(dir!=Orientacion.E){
					dir = Orientacion.O;
					u.setDir(dir);
				}
				
			}
			if (keyCode == KeyEvent.VK_UP) {
				if(dir!=Orientacion.S){
					dir = Orientacion.N;
					u.setDir(dir);
				}
			}
			if (keyCode == KeyEvent.VK_DOWN) {
				if(dir!=Orientacion.N){
					dir = Orientacion.S;
					u.setDir(dir);
				}
			}
		}
		public Orientacion getDir() {
			return dir;
		}
		public AL(Usuario u) {
			this.u=u;
		}

		@Override
		public void keyReleased(KeyEvent event) {
		}
	}

