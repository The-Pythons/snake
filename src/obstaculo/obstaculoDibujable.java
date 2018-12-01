package obstaculo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import logica.Dibujable;

public class obstaculoDibujable extends Dibujable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Obstaculo o;
	private Image image;
	public obstaculoDibujable(Obstaculo o) {
		this.o=o;
		//this.image = new ImageIcon("recursos/IMGP5539_almost_seamless.jpg").getImage();
		this.image = new ImageIcon("recursos/brick 1.jpg").getImage();
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.GRAY);
		//g.fillRect(o.pos.x *super.TAMANO, o.pos.y *super.TAMANO, super.TAMANO, super.TAMANO);
		g.drawImage(this.image, o.pos.x*super.TAMANO, o.pos.y*super.TAMANO, super.TAMANO, super.TAMANO, null);
	}

	@Override
	public boolean getEstado(Graphics g) {
		return o.getEstado();
	}

}
