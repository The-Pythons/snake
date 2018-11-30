package servidor;

import java.net.ServerSocket;
import java.util.ArrayList;

public class Servidor {
	private ServerSocket socketServer;
//	private ArrayList<Sala> listaSalas;
	
	public Servidor() {
		new ThreadServidor(this);
	}
	
	public void crearSala() {
		
	}
	
	public void unirASala() {
		
	}
	
	
}
