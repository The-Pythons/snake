package snake;

import java.io.Serializable;

import logica.Punto2D;

public class Cabeza implements Serializable{
	private Punto2D posicion;
	private Orientacion orientacion;

	public Cabeza(int x, int y,Orientacion orientacion) {
		this.posicion = new Punto2D(x,y);
		this.orientacion = orientacion;
	}

	public Cabeza(Punto2D posicion, Orientacion orientacion) {
		this.posicion = new Punto2D(posicion);
		this.orientacion = orientacion;
	}
	
	public Punto2D getPosicion() {
		return posicion;
	}
	
	public void setPosicion(int x, int y) {
		this.posicion.x = x;
		this.posicion.y = y;
	}
	
	public Orientacion getOrientacion() {
		return orientacion;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cabeza other = (Cabeza) obj;
//		if (orientacion != other.orientacion)
//			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}

	public void setOrientacion(Orientacion dir) {
		this.orientacion=dir;
		
	}

	public void setPosicion(Punto2D posicionSig) {
		posicion=posicionSig;
		
	}

	
}
