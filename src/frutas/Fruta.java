package frutas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import logica.Choques;
import logica.Escenario;
import logica.Punto2D;
import snake.Serpiente;

public class Fruta implements Choques {
	Punto2D pos;
	String tipo = "F";
	
	public Fruta(int x, int y){
		this.pos = new Punto2D(x,y);
		
	}
	
	public Fruta(Punto2D pos2) {
		this.pos=pos2;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return tipo;
	}

	@Override
	public void chocar(Serpiente s1) {
		s1.crecer();
		
	}

	@Override
	public boolean getEstado() {
		return false;
	}

	@Override
	public ArrayList<Punto2D> eliminar() {
		ArrayList<Punto2D> a= new ArrayList<Punto2D>();
		a.add(pos);
		return a;
	}

	@Override
	public void eliminar(Escenario escenario) {
		escenario.vaciarPosicion(this.pos);
		
	}

	/*@Override
	public void getDibujable(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(pos.x, pos.y, 50, 50);
		
	}*/


	

}
