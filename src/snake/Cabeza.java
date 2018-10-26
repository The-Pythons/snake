package snake;

public class Cabeza implements Direcciones{
	private Punto2D posicion;
	private int orientacion;

	public Cabeza(int x, int y, int orientacion) {
		this.posicion = new Punto2D(x,y);
		this.orientacion = orientacion;
	}

	public Cabeza(Punto2D posicion, int orientacion) {
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
	
	public int getOrientacion() {
		return orientacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orientacion;
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
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

	
}
