package logica;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Dibujable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int TAMANO=18;
	public abstract void dibujar (Graphics g);
	public abstract boolean getEstado (Graphics g);
	
}
