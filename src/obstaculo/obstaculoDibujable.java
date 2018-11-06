package obstaculo;

import java.awt.Color;
import java.awt.Graphics;

import logica.Dibujable;

public class obstaculoDibujable extends Dibujable {

	
	Obstaculo o;
	public obstaculoDibujable(Obstaculo o) {
		o=o;
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(o.pos.x + 1, o.pos.y + 1, super.TAMANO, super.TAMANO);
	}

	@Override
	public boolean getEstado(Graphics g) {
		return o.getEstado();
		
	}

}
