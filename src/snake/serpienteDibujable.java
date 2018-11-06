package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import logica.Dibujable;
import logica.Punto2D;

public class serpienteDibujable extends Dibujable {
	
	Serpiente s;

	public serpienteDibujable(Serpiente s) {
		this.s = s;
	}
	
	@Override
	public void dibujar(Graphics g) {
		Punto2D pos=s.cabeza.getPosicion();
		g.setColor(Color.RED);
		g.fillRect(pos.x * super.TAMANO,pos.y*super.TAMANO, super.TAMANO, super.TAMANO);		
		for (Iterator<Cuerpo> it = s.cuerpo.iterator(); it.hasNext();) {
			pos = it.next().getPosicion();
			g.setColor(Color.GREEN);
			g.fillRect(pos.x*super.TAMANO,pos.y*super.TAMANO,super.TAMANO, super.TAMANO);
		}
	}
	@Override
	public boolean getEstado(Graphics g) {
		return s.getEstado();
	}

	
	
}
