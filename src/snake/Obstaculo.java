package snake;

public class Obstaculo {
	Punto2D pos;
	String tipo = "X";

	public Obstaculo(int x, int y) {
		this.pos = new Punto2D(x, y);

	}

	@Override
	public String toString() {
		return tipo;
	}

}