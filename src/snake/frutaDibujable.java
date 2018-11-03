package snake;

import java.awt.Color;
import java.awt.Graphics;

public class frutaDibujable extends Dibujable {

	Fruta f;
	
	public frutaDibujable (Fruta f) {
		this.f = f;
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(f.pos.x, f.pos.y, 10, 10);
	}
	
	
}
