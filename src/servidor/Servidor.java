package servidor;

import java.net.ServerSocket;
import java.util.ArrayList;

import io.HibernateApp;

public class Servidor {
	private ServerSocket socketServer;
	private HibernateApp baseDeDatos;
//	private ArrayList<Sala> listaSalas;
	
	public Servidor() {
		this.baseDeDatos = new HibernateApp();
		new ThreadServidor(this);
	}
	
	public static void main(String[] args) {
		new Servidor();
	}
	
	public void crearSala() {
		
	}
	
	public void unirASala() {
		
	}

	public HibernateApp getBaseDeDatos() {
		return baseDeDatos;
	}
	
	
}
