package mensajes;

import java.io.Serializable;

/*
 * registrar: true si es registro, false para logueo normal  
 */
public class MsjLogin implements Serializable {
	private String login,password;
	private boolean registrar;
	
	
	public MsjLogin(String login, String password, boolean registrar) {
		this.login = login;
		this.password = password;
		this.registrar = registrar;
	}
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isRegistrar() {
		return registrar;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRegistrar(boolean registrar) {
		this.registrar = registrar;
	}
	
	
	
}
