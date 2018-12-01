package logica;

import java.awt.Graphics;

public abstract class Dibujable {

	public final static int TAMANO=18;
	public abstract void dibujar (Graphics g);
	public abstract boolean getEstado (Graphics g);
	
}
