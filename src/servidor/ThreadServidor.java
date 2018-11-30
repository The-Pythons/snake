package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServidor extends Thread {
	
	private ServerSocket sockeServidor;
	private Servidor servidorPrincipal;
	
	public ThreadServidor(Servidor servidor) {
		this.servidorPrincipal = servidor;
		start();
	}
	
	public void run() {
		try {
			sockeServidor = new ServerSocket(1025);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			try {
				Socket socketCliente = sockeServidor.accept();
				new ThreadUsuario(socketCliente,servidorPrincipal);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}
	}

}
