package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import logica.Escenario;
import logica.ConexionUsuario;
import snake.Orientacion;

public class AL extends KeyAdapter {
	Orientacion dir;
	ConexionUsuario u;
	static int dirIzq = KeyEvent.VK_LEFT;
	static int dirDer = KeyEvent.VK_RIGHT;
	static int dirArriba = KeyEvent.VK_UP;
	static int dirAbajo = KeyEvent.VK_DOWN;

	@Override
	public void keyPressed(KeyEvent event) {
		int keyCode = event.getKeyCode();
		if (keyCode == this.dirIzq) {
			if (dir != Orientacion.O) {
				dir = Orientacion.E;
				u.setDir(dir);
			}
		}
		if (keyCode == this.dirDer) {
			if (dir != Orientacion.E) {
				dir = Orientacion.O;
				u.setDir(dir);
			}

		}
		if (keyCode == this.dirArriba) {
			if (dir != Orientacion.S) {
				dir = Orientacion.N;
				u.setDir(dir);
			}
		}
		if (keyCode == this.dirAbajo) {
			if (dir != Orientacion.N) {
				dir = Orientacion.S;
				u.setDir(dir);
			}
		}
	}

	public Orientacion getDir() {
		return dir;
	}

	public AL(ConexionUsuario u) {
		this.u = u;
	}

	@Override
	public void keyReleased(KeyEvent event) {
	}
	
	public static void cambiarDirecciones (int arriba, int abajo, int izquierda, int derecha) {
		dirArriba = arriba;
		dirAbajo = abajo;
		dirIzq = izquierda;
		dirDer = derecha;
	}
}
