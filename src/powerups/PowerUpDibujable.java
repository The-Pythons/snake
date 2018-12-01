package powerups;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import logica.Dibujable;

public class PowerUpDibujable extends Dibujable {

	PowerUp p;
	private Image image;
	
	public PowerUpDibujable (PowerUp p) {
		this.p = p;
		image = new ImageIcon("recursos/manzana_2.png").getImage();
	}
	
	@Override
	public void dibujar(Graphics g) {
		//g.setColor(Color.BLUE);
		//g.fillOval(f.pos.x*10, f.pos.y*10, 10, 10);
		g.drawImage(this.image, p.pos.x*super.TAMANO, p.pos.y*super.TAMANO, super.TAMANO, super.TAMANO, null);
	}

	@Override
	public boolean getEstado(Graphics g) {
		return p.getEstado();
	}
	
	
}
