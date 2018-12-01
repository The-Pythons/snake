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
	
		while (true) {
			
//			try {
////				Thread.sleep(17);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			c.repaint();

		}
		
		
	}

}
