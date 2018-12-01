package mensajes;

import java.io.Serializable;

public class MsjSalida implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean respuesta;
	private String detalleError;
	
	public MsjSalida(boolean respuesta, String detalleError) {
		this.respuesta = respuesta;
		this.detalleError = detalleError;
	}
	public boolean isRespuesta() {
		return respuesta;
	}
	
	public String getDetalleError() {
		return detalleError;
	}
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	public void setDetalleError(String detalleError) {
		this.detalleError = detalleError;
	}
	
	
	
}
