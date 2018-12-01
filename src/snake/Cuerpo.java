package snake;

import java.io.Serializable;

import logica.Punto2D;

public class Cuerpo implements Serializable{
	private Punto2D posicion;
	private Orientacion orientacion;

	public Cuerpo(int x, int y, Orientacion orientacion) {
		this.posicion = new Punto2D(x, y);
		this.orientacion = orientacion;
		
	}
	
	
	public Cuerpo(Punto2D posicion, Orientacion orientacion) {
		this.posicion = new Punto2D(posicion);
		this.orientacion = orientacion;
	}

	public Punto2D getPosicion() {
		return posicion;
	}
	public Punto2D setPosicion(Punto2D pos) {
		return posicion;
	}

	public void  mover() {
		switch (orientacion) { // Muevo el cuerpo
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
	}
	public void  moverI() {
		switch (this.orientacion) { // Muevo el cuerpo
		case N:
			this.posicion.y++;
			break;
		case S:
			this.posicion.y--;
			break;
		case O:
			this.posicion.x++;
			break;
		default:
			this.posicion.x--;
			}
		
	}
	
	public void setOrientacion(Orientacion o) {
		this.orientacion=o;
	}
	public Orientacion getOrientacion() {
		return this.orientacion;
	}

}
