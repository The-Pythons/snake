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
		int dx;
		int dy;
		g.setColor(Color.GREEN);
		g.fillRect(s.cabeza.getPosicion().x , s.cabeza.getPosicion().y + 1, 8, 8);
		Iterator<Cuerpo> it = s.cuerpo.iterator();		
		while (it.hasNext()) {
			Cuerpo c = it.next();
			//g.setColor(Color.GREEN);
			dx = s.cabeza.getPosicion().x -(s.cabeza.getPosicion().x-c.getPosicion().x)*8;
			dy = s.cabeza.getPosicion().y -(s.cabeza.getPosicion().y-c.getPosicion().y)*8;
			g.fillRect(dx,dy, 8, 8);
		}
	}

	
	
}
