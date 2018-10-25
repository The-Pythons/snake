package snake;

public class Cabeza implements Direcciones{
	private Punto2D posicion;
	private int orientacion;

	public Cabeza(int x, int y, int orientacion) {
		this.posicion = new Punto2D(x,y);
		this.orientacion = orientacion;
	}

	public Cabeza() {
		this.posicion = new Punto2D(1,0);
		this.orientacion = E;
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
}
