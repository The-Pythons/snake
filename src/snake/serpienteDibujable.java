package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;

import logica.Dibujable;
import logica.Punto2D;
import logica.ConexionUsuario;

public class serpienteDibujable extends Dibujable {
	
	Serpiente s;
	Image imagenCabeza;
	Image imagenCuerpo;
/*	static final int ROSA = 1;
	static final int VERDE = 2;
	static final int AMARILLO = 3;
	static final int AZUL = 4;
*/		
	public serpienteDibujable(Serpiente s, Skin color) {
		this.s = s;
		String cabezaString = null, cuerpoString = null;
		switch (color) {
		case ROSA:
			cabezaString = "recursos/Cabeza snake rosa.png";
			cuerpoString = "recursos/Cuerpo snake rosa.png";
			break;
		case VERDE:
			cabezaString = "recursos/Cabeza snake verde.png";
			cuerpoString = "recursos/Cuerpo snake verde.png";
			break;
		case AMARILLO:
			cabezaString = "recursos/Cabeza snake amarillo.png";
			cuerpoString = "recursos/Cuerpo snake amarillo.png";
			break;
		case AZUL: // AZUL
			cabezaString = "recursos/Cabeza snake azul.png";
			cuerpoString = "recursos/Cuerpo snake azul.png";
			break;
		case VIOLETA: // AZUL
			cabezaString = "recursos/Cabeza snake violeta.png";
			cuerpoString = "recursos/Cuerpo snake violeta.png";
			break;
		case DORADA: // AZUL
			cabezaString = "recursos/Cabeza snake dorada.png";
			cuerpoString = "recursos/Cuerpo snake dorada.png";
			break;
		}
		this.imagenCabeza = new ImageIcon(cabezaString).getImage();
		this.imagenCuerpo = new ImageIcon(cuerpoString).getImage();
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
