package mensajes;

import java.io.Serializable;

/*
 * registrar: true si es registro, false para logueo normal  
 */
public class MsjEntradaLogin implements Serializable {
	private String login,password;
	private boolean registrar;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRegistrar() {
		return registrar;
	}
	public void setRegistrar(boolean registrar) {
		this.registrar = registrar;
	}
	
	
}
