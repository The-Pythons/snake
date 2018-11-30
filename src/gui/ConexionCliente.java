package gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConexionCliente extends Thread {

	
	public  ObjectInputStream entrada;
	Socket socket;
	//public  ObjectOutputStream salida;

	public ConexionCliente(Socket socket) throws UnknownHostException, IOException{
	 this.socket = socket;
		
		//salida = new ObjectOutputStream(socket.getOutputStream());
	}
	
	public void run(){
		try {
			entrada = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
