package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import io.HibernateApp;

public class ThreadServidor extends Thread {
	
	private ServerSocket sockeServidor;
	private Servidor servidorPrincipal;
	
	public ThreadServidor(Servidor servidor) {
		this.servidorPrincipal = servidor;
		start();
	}
	
	public void run() {
		try {
			sockeServidor = new ServerSocket(5000);
			System.out.println("Servidor conectado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			try {
				Socket socketCliente = sockeServidor.accept();
				ThreadUsuario u=new ThreadUsuario(socketCliente,servidorPrincipal);
				u.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}
	}

}
