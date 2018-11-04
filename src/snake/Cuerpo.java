package snake;

public class Cuerpo {
	private Punto2D posicion;
	private Orientacion orientacion;

	public Cuerpo(int x, int y, Orientacion orientacion) {
		this.posicion = new Punto2D(x, y);
		this.orientacion = orientacion;
	}
	
	public Cuerpo(Punto2D posicion, Orientacion orientacion2) {
		this.posicion = new Punto2D(posicion);
		this.orientacion = orientacion2;
	}

	public Punto2D getPosicion() {
		return posicion;
	}

	
	public Orientacion getOrientacion() {
		return this.orientacion;
	}

}
