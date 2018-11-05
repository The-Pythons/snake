package snake;

public class Cuerpo {
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

	public void  mover() {
		switch (orientacion) { // Muevo el cuerpo
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
	}
	
	public Orientacion getOrientacion() {
		return this.orientacion;
	}

}
