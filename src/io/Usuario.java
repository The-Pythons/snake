package io;

public class Usuario {

	private String user;
	private String password;
	private boolean logState; //Para saber si esta logueado. false = offline - true = online.
	
	public Usuario(){
		this.user = "";
		this.password = "";
		this.logState = false;
	}
	
	public Usuario(String user, String password, boolean state) {
		this.user = user;
		this.password = password;
		this.logState = state;
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

	public boolean getLogState() {
		return logState;
	}

	public void setLogState(boolean estado) {
		this.logState = estado;
	}

	@Override
	public String toString() {
		return user + "|" + password +  "|" + logState;
	}

}
