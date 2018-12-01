package servidor;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;

import io.HibernateApp;
import logica.Sala;

public class Servidor {
	private ServerSocket socketServer;
	private HibernateApp baseDeDatos;
	private  ArrayList<Sala> listaSalas;
	private ArrayList<String> listaNombreSalas;
	
	public Servidor() {
		this.baseDeDatos = new HibernateApp();
		new ThreadServidor(this);
		listaSalas= new ArrayList<Sala>();
		listaNombreSalas = new ArrayList<String>();
	}
	
	public static void main(String[] args) {
		new Servidor();
	}
	

	public HibernateApp getBaseDeDatos() {
		return baseDeDatos;
	}

	public void crearSala(String nombreSala, String passwordSala) {
		listaSalas.add(new Sala(nombreSala, passwordSala));
		listaNombreSalas.add(nombreSala);		
	}


	public Sala getSala(String nombreSala, String passwordSala) {
		Iterator<Sala> it = listaSalas.iterator();
		while(it.hasNext()){
			Sala tmp = it.next();
			if(nombreSala.equals(tmp.getNombre()))
				return tmp;
		}
		return null;
	}

	public void eliminarSala(String nombreSala) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<String> getListaNombreSalas() {
		return listaNombreSalas;
	}
	
	
}
