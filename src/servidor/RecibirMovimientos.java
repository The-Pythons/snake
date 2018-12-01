package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;

import logica.ConexionUsuario;
import mensajes.MsjJugada;

public class RecibirMovimientos extends Thread{
	
	private ObjectInputStream entrada;
	private ConexionUsuario usuario;
	
	public RecibirMovimientos(ConexionUsuario usuario,ObjectInputStream entrada) {
		this.usuario=usuario;
		this.entrada=entrada;
	}
	
	
	
	public void run() {
		
		MsjJugada msj;
		try {
			while((msj = (MsjJugada)entrada.readObject())!= null) {
				
				usuario.recibirDir(msj.getNuevaOrientacion());
				
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
