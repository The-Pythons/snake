package snake;

public class Cuerpo {
	private Punto2D posicion;
	private Orientacion orientacion;

	public Cuerpo(int x, int y, Orientacion orientacion) {
		
		switch (orientacion) { // Muevo la cabeza
		case N:
			y--;
			break;
		case S:
			y++;
			break;
		case O:
			x--;
			break;
		default:
			x++;
		this.posicion = new Punto2D(x, y);
		this.orientacion = orientacion;
		}
	}
	
	public Cuerpo(Punto2D posicion, Orientacion orientacion) {
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
			posicion.x++;}
	
		this.posicion = new Punto2D(posicion);
		this.orientacion = orientacion;
	}

	public Punto2D getPosicion() {
		return posicion;
	}

	
	public Orientacion getOrientacion() {
		return this.orientacion;
	}

}
