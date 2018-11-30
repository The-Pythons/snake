package mensajes;

import java.io.Serializable;

import snake.Orientacion;

public class MsjJugada implements Serializable {
	private Orientacion nuevaOrientacion;

	public MsjJugada(Orientacion nuevaOrientacion) {
		this.nuevaOrientacion = nuevaOrientacion;
	}

	public Orientacion getNuevaOrientacion() {
		return nuevaOrientacion;
	}
	

}
