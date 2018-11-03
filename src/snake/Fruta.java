package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Fruta {
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

	/*@Override
	public void getDibujable(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(pos.x, pos.y, 50, 50);
		
	}*/


	

}
