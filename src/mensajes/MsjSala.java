package mensajes;

import java.io.Serializable;

public class MsjSala implements Serializable {
	
	private String nombreSala;
	private String passwordSala;
	private boolean crear;
	private boolean loguerase;
	private boolean eliminar;
	public String getNombreSala() {
		return nombreSala;
	}
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}
	public String getPasswordSala() {
		return passwordSala;
	}
	public void setPasswordSala(String passwordSala) {
		this.passwordSala = passwordSala;
	}
	public boolean isCrear() {
		return crear;
	}
	public void setCrear(boolean crear) {
		this.crear = crear;
	}
	public boolean isLoguerase() {
		return loguerase;
	}
	public void setLoguerase(boolean loguerase) {
		this.loguerase = loguerase;
	}
	public boolean isEliminar() {
		return eliminar;
	}
	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}
	
	

}
