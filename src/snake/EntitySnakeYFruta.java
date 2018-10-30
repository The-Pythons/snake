package snake;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class EntitySnakeYFruta {
	private int x, y, Tama�odelCuerpo;
	///Posicione y,x
	/// tama�o size (Seria el ancho y alto)

	public EntitySnakeYFruta(int size) {
		this.Tama�odelCuerpo = size;
	
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void SetPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public Rectangle getBound() {
		return new Rectangle(x, y, Tama�odelCuerpo, Tama�odelCuerpo);
	}

	public boolean isCollsion(EntitySnakeYFruta o) {
		if (o == this)
		return false;///si pongo en true entra en un bucle
		return getBound().intersects(o.getBound());
	}
	////Por defecto
	public void render(Graphics2D g2d2) {
		// TODO Auto-generated method stub
		g2d2.fillRect(x+1, y+1,Tama�odelCuerpo-1,Tama�odelCuerpo-1);///Le da el efecto de espacio
	}
}
