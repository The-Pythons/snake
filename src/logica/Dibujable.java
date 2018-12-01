package logica;

import java.awt.Graphics;

public abstract class Dibujable {

	public final int TAMANO=15;
	public abstract void dibujar (Graphics g);
	public abstract boolean getEstado (Graphics g);
	
}
