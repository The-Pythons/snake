package io;

public class Usuario {

	private String user;
	private String password;
	private int estado; //Para saber si esta logueado. 0 = offline - 1 = online.
	
	public Usuario(){
		this.user = "";
		this.password = "";
		this.estado = 0;
	}
	
	public Usuario(String user, String password, int estado) {
		this.user = user;
		this.password = password;
		this.estado = estado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return user + "|" + password +  "|" + estado;
	}

}
