package frutas;

import java.awt.Color;
import java.awt.Graphics;

import logica.Dibujable;

public class frutaDibujable extends Dibujable {

	Fruta f;
	
	public frutaDibujable (Fruta f) {
		this.f = f;
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(f.pos.x*10, f.pos.y*10, 10, 10);
	}

	@Override
	public boolean getEstado(Graphics g) {
		return f.getEstado();
	}
	
	
}
