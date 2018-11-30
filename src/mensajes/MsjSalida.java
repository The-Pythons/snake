package mensajes;

import java.io.Serializable;

public class MsjSalida implements Serializable {
	private boolean respuesta;
	private String detalleError;
	
	public boolean isRespuesta() {
		return respuesta;
	}
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	public String getDetalleError() {
		return detalleError;
	}
	public void setDetalleError(String detalleError) {
		this.detalleError = detalleError;
	}
	
	
	
}
