package frutas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import logica.Dibujable;

public class frutaDibujable extends Dibujable {

	Fruta f;
	private Image image;
	
	public frutaDibujable (Fruta f) {
		this.f = f;
		image = new ImageIcon("manzana.png").getImage();
	}
	
	@Override
	public void dibujar(Graphics g) {
		//g.setColor(Color.BLUE);
		//g.fillOval(f.pos.x*10, f.pos.y*10, 10, 10);
		g.drawImage(this.image, f.pos.x*super.TAMANO, f.pos.y*super.TAMANO, super.TAMANO, super.TAMANO, null);
		
	}

	@Override
	public boolean getEstado(Graphics g) {
		return f.getEstado();
	}
	
	
}
