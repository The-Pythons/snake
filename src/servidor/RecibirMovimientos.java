package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logica.ConexionUsuario;
import mensajes.MsjJugada;

public class RecibirMovimientos extends Thread{
	
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private ConexionUsuario usuario;
	
	public RecibirMovimientos(ConexionUsuario usuario,ObjectInputStream entrada) {
		this.usuario=usuario;
		this.entrada=entrada;
	}
	
	public RecibirMovimientos(ConexionUsuario usuario,ObjectInputStream entrada, ObjectOutputStream salida) {
		this.usuario=usuario;
		this.entrada=entrada;
		this.salida = salida;
	}
	
	
	
	public void run() {
		
		MsjJugada msj;
		try {
			while((msj = (MsjJugada)entrada.readObject())!= null) {
				usuario.recibirDir(msj.getNuevaOrientacion());
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
