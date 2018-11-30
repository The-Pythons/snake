package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadUsuario {

	private Servidor servidorPrincipal;
	private Socket socket;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	public ThreadUsuario(Socket socket, Servidor servidorPrincipal) {
		this.servidorPrincipal = servidorPrincipal;
		this.socket = socket;
		try {
			this.entrada = new ObjectInputStream(socket.getInputStream());
			this.salida = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		///aca hay qe leer y manda
	}
}
