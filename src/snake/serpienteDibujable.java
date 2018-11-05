package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

public class serpienteDibujable extends Dibujable {
	
	Serpiente s;

	public serpienteDibujable(Serpiente s) {
		this.s = s;
	}
	
	@Override
	public void dibujar(Graphics g) {
		int k=8;
		int cx=s.cabeza.getPosicion().x*10;
		int cy=s.cabeza.getPosicion().y*10;
		int dx,dy;
		Punto2D pos; 
		g.setColor(Color.RED);
		g.fillRect(cx , cy, k, k);
		Iterator<Cuerpo> it = s.cuerpo.iterator();		
		while (it.hasNext()) {
			Cuerpo c = it.next();
			pos = c.getPosicion();
			dx= cx+ (cx - pos.x*10);
			dy= cy + (cy - pos.y*10);
			g.setColor(Color.GREEN);
			g.fillRect(dx,dy, 8, 8);
		}
	}

	
	
}
