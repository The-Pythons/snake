package gui;

public class Repintar extends Thread {
	
	GameFirstClass c;
	
	
	
	
	public Repintar(GameFirstClass c) {
		this.c = c;
	}




	public void run(){
		long tf, ti;
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
