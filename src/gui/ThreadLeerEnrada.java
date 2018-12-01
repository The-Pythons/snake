package gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import logica.Dibujable;

public class ThreadLeerEnrada extends Thread {

	private ObjectInputStream conexion;
	private ObjectOutputStream salida;
	private ArrayList<Dibujable> elementos;

	public ThreadLeerEnrada(ObjectInputStream conexion, ObjectOutputStream salida) {
		this.conexion = conexion;
		this.salida = salida;
		
	}

	@SuppressWarnings("unchecked")
	public void run() {
		while (true)
			try {
				elementos = (ArrayList<Dibujable>) conexion.readObject();
//				salida.writeObject("ok");
				System.out.println(elementos.size());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public ArrayList<Dibujable> getElementos(){
		return elementos;
	}

}
