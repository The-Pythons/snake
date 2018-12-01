package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import logica.Dibujable;

public class EnviarObjetos extends Thread{

	private ObjectOutputStream salida;
	private ArrayList<Dibujable> dibujables;
	
	public EnviarObjetos(ObjectOutputStream salida,ArrayList<Dibujable> dibujables) {
		this.salida = salida;
		this.dibujables = dibujables;	
	}

	public void run() {
		while(true) {
			try {
				salida.writeObject(dibujables);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
