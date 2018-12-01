package gui;

import java.io.IOException;
import java.util.ArrayList;

import logica.Dibujable;

public class Repintar extends Thread {
	
	GameFirstClass c;
	
	
	
	
	public Repintar(GameFirstClass c) {
		this.c = c;
	}




	public void run(){
		long tf, ti;
		try {
			c.elementos = (ArrayList<Dibujable>) c.entrada.entrada.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			
			ti = System.currentTimeMillis();
			c.repaint();
			try {
				tf = System.currentTimeMillis();
				Thread.sleep(17 - (tf - ti));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
		
	}

}
