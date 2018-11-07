package obstaculo;

import java.util.ArrayList;

import logica.Choques;
import logica.Escenario;
import logica.Punto2D;
import snake.Serpiente;

public class Obstaculo implements Choques {
	Punto2D pos;
	String tipo = "X";

	public Obstaculo(int x, int y) {
		this.pos = new Punto2D(x, y);

	}
	
	public Obstaculo(Punto2D pos) {
		this.pos = new Punto2D(pos.x, pos.y);

	}
	@Override
	public String toString() {
		return tipo;
	}

	@Override
	public void chocar(Serpiente s1) {
		s1.muere();
	}
	@Override
	public boolean getEstado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Punto2D> eliminar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Escenario escenario) {
		escenario.vaciarPosicion(this.pos);
	}

/*	@Override
	public void getDibujable(Graphics g) {
		 g.drawRect (pos.x, pos.y, 10, 20);
		
	}
*/
}