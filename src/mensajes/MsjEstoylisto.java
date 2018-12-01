package mensajes;

import java.io.Serializable;

public class MsjEstoylisto implements Serializable{
	private boolean estoyListo;

	public MsjEstoylisto(boolean estoyListo) {
		this.estoyListo = estoyListo;
	}

	public boolean getEstoyListo() {
		return estoyListo;
	}
	
	
}
