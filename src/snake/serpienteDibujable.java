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
		g.setColor(Color.GREEN);
		g.fillRect(s.cabeza.getPosicion().x + 1, s.cabeza.getPosicion().x + 1, 8, 8);
		Iterator<Cuerpo> it = s.cuerpo.iterator();		
		while (it.hasNext()) {
			Cuerpo c = it.next();
			//g.setColor(Color.GREEN);
			g.fillRect(c.getPosicion().x + 1, c.getPosicion().x + 1, 8, 8);
		}
	}

	
	
}
