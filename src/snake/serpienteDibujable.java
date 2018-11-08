package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;

import logica.Dibujable;
import logica.Punto2D;

public class serpienteDibujable extends Dibujable {
	
	Serpiente s;
	Image imagenCabeza;
	Image imagenCuerpo;
	
	public serpienteDibujable(Serpiente s) {
		this.s = s;
		this.imagenCabeza = new ImageIcon("recursos/Cabeza snake rosa.png").getImage();
		this.imagenCuerpo = new ImageIcon("recursos/Cuerpo snake rosa.png").getImage();
	}
	
	@Override
	public void dibujar(Graphics g) {
		Punto2D pos=s.cabeza.getPosicion();
		//g.setColor(Color.RED);
		g.drawImage(this.imagenCabeza, pos.x*super.TAMANO, pos.y*super.TAMANO, super.TAMANO, super.TAMANO, null);
		//g.fillRect(pos.x * super.TAMANO,pos.y*super.TAMANO, super.TAMANO, super.TAMANO);		
		for (Iterator<Cuerpo> it = s.cuerpo.iterator(); it.hasNext();) {
			pos = it.next().getPosicion();
			//g.setColor(Color.yellow);
			g.drawImage(this.imagenCuerpo, pos.x*super.TAMANO, pos.y*super.TAMANO, super.TAMANO, super.TAMANO, null);
			//g.fillRect(pos.x*super.TAMANO,pos.y*super.TAMANO,super.TAMANO, super.TAMANO);
		}
	}
	
	@Override
	public boolean getEstado(Graphics g) {
		return s.getEstado();
	}	
	
}
