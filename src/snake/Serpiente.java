package snake;

import java.util.ArrayList;

public class Serpiente implements Direcciones {

	private Cabeza cabeza;
	private ArrayList<Cuerpo> cuerpo;
//	private int orientacion;// direccion en la que avanza la serpiente, enviar inputs para mover a la izq o
	// der la modificaria.
	// norte/sur/este/oeste estan definidas como constantes en la interfaz
	// direcciones.

	public Serpiente(int x, int y, int orientacion) {
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
		int orientacion = this.cuerpo.get(this.cuerpo.size() - 1).getOrientacion();
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
		this.cuerpo.add(new Cuerpo(posicion.x, posicion.y, orientacion));
	}

	/*
	 * muevo la cabeza una unidad y "relleno" con un segmento donde esta estaba. (no
	 * se debe agregar un segmento antes de moverse) si manejo el crecimiento de
	 * esta forma, la lista con los N segmentos de la serpiente estaria ordenada de
	 * la sig manera: primer elemento: cola de la serpiente ultimo elemento:
	 * segmento antes de la cabeza
	 */
	public void avanzar() {
		int orientacion = this.cabeza.getOrientacion();
		Punto2D posicion = this.cabeza.getPosicion();
		Cuerpo aux = new Cuerpo(posicion.x,posicion.y,orientacion);
		switch (orientacion) {
		case N:
			posicion.y--;
			break;
		case S:
			posicion.y++;
			break;
		case O:
			posicion.x++;
			break;
		default:
			posicion.x--;
		}
		this.cabeza.setPosicion(posicion.x, posicion.y);
		
		
		for (int i = this.cuerpo.size()-1; i > 0; i--) {
			this.cuerpo.set(i, this.cuerpo.get(i-1));
		}
		this.cuerpo.set(0,aux);
	}

	public void muere() {
		// TODO Auto-generated method stub

	}

	public void comer(Fruta object) {
		this.crecer();
	}

}
