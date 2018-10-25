package snake;

public class Cuerpo implements Direcciones {
	private Punto2D posicion;
	private int orientacion;

	public Cuerpo(int x, int y, int orientacion) {
		this.posicion = new Punto2D(x, y);
		this.orientacion = orientacion;
	}

	public Cuerpo() {
		this.posicion = new Punto2D(1, 0);
		this.orientacion = E;
	}

	public Punto2D getPosicion() {
		return posicion;
	}
	
	public int getOrientacion() {
		return orientacion;
	}

}
