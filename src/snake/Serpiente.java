package snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;



public class Serpiente {

	Cabeza cabeza;
	ArrayList<Cuerpo> cuerpo;
//	private int orientacion;// direccion en la que avanza la serpiente, enviar inputs para mover a la izq o
	// der la modificaria.
	// norte/sur/este/oeste estan definidas como constantes en la interfaz
	// direcciones.

	public Serpiente(int x, int y, Orientacion orientacion) {
		this.cabeza = new Cabeza(x, y, orientacion);
		this.cuerpo = new ArrayList<Cuerpo>();
		switch (orientacion) {// agrego el primer segmento del cuerpo detras de la cabeza, dependiendo de
								// donde "mira"
		case N:
			this.cuerpo.add(new Cuerpo(x, y + 1, orientacion));
			break;
		case S:
			this.cuerpo.add(new Cuerpo(x, y - 1, orientacion));
			break;
		case O:
			this.cuerpo.add(new Cuerpo(x + 1, y, orientacion));
			break;
		default:
			this.cuerpo.add(new Cuerpo(x - 1, y, orientacion));
		}
	}

	public void crecer() {
		/*
		 * Agrega un segmento de cuerpo al final de la lista en funcion del ultimo
		 * segmento
		 */
		Orientacion orientacion = this.cuerpo.get(this.cuerpo.size() - 1).getOrientacion();
		Punto2D posicion = this.cuerpo.get(this.cuerpo.size() - 1).getPosicion();
		switch (orientacion) {
		case N:
			posicion.y++;
			break;
		case S:
			posicion.y--;
			break;
		case O:
			posicion.x++;
			break;
		default:
			posicion.x--;
		}
		this.cuerpo.add(new Cuerpo(posicion, orientacion));
	}

	public void avanzar() {
		Orientacion orientacion = this.cabeza.getOrientacion();
		Punto2D posicion = this.cabeza.getPosicion();
		Cuerpo aux = new Cuerpo(posicion, orientacion); // Guardo la posicion de la cabeza
		
		for (int i = this.cuerpo.size() - 1; i > 0; i--) { // Desde el ultimo segmento de cuerpo reemplazo con el anterior
			this.cuerpo.set(i, this.cuerpo.get(i - 1));
		}
		this.cuerpo.set(0, aux); // El primer segmento queda en la posicion que tenia la cebeza
		
		switch (orientacion) { // Muevo la cabeza
		case N:
			posicion.y--;
			break;
		case S:
			posicion.y++;
			break;
		case O:
			posicion.x--;
			break;
		default:
			posicion.x++;
		}
		this.cabeza.setPosicion(posicion.x, posicion.y);

		
	}

	public void muere() {
		// TODO Auto-generated method stub

	}

	public void comer(Fruta object) {
		this.crecer();
	}

	public Cabeza getCabeza() {
		return cabeza;
	}

	public ArrayList<Cuerpo> getCuerpo() {
		return cuerpo;
	}

	public void girar(Orientacion dir) {
		cabeza.setOrientacion(dir);
		
	}




}
