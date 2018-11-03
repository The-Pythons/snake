package snake;

import java.awt.Color;
import java.awt.Graphics;

public class obstaculoDibujable extends Dibujable {

	Obstaculo o;
	
	public obstaculoDibujable(Obstaculo o) {
		this.o = o;
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(o.pos.x + 1, o.pos.y + 1, 8, 8);
	}

}
