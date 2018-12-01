package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logica.Escenario;
import mensajes.MsjJugada;
import logica.ConexionUsuario;
import snake.Orientacion;

public class AL extends KeyAdapter {
	Orientacion dir;
	ObjectOutputStream u;
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
				try {
					this.u.writeObject(new MsjJugada(dir));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (keyCode == this.dirDer) {
			if (dir != Orientacion.E) {
				dir = Orientacion.O;
				try {
					this.u.writeObject(new MsjJugada(dir));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		if (keyCode == this.dirArriba) {
			if (dir != Orientacion.S) {
				dir = Orientacion.N;
				try {
					this.u.writeObject(new MsjJugada(dir));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (keyCode == this.dirAbajo) {
			if (dir != Orientacion.N) {
				dir = Orientacion.S;
				try {
					this.u.writeObject(new MsjJugada(dir));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Orientacion getDir() {
		return dir;
	}

	public AL(ObjectOutputStream salida) {
		this.u = salida;
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
