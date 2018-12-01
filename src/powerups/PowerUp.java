package powerups;

import frutas.Fruta;
import logica.Punto2D;
import snake.Serpiente;

public class PowerUp extends Fruta {
	private String tipo;
	public PowerUp(int x, int y,String tipo) {
		super(x, y);
		this.tipo=tipo;
	}

	public PowerUp(Punto2D pos2, String tipo) {
		super(pos2);
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}
	@Override
	public void chocar(Serpiente s1) {
		super.estado =true;
		switch(tipo) {
		case "achicar":
			this.achicar(s1);
			break;
		}
		
		
	}
	
	void achicar(Serpiente s1) {
		s1.achicar();
		s1.achicar();
		s1.achicar();
	}
}
