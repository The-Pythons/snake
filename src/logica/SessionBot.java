package logica;

import org.omg.CORBA.MARSHAL;

import snake.Orientacion;
import snake.Serpiente;

public class SessionBot extends Thread {

	Escenario escenario;
	Usuario usuario;
	Serpiente serpiente;

	public SessionBot(Escenario escenario, Serpiente serpiente, Usuario usuario) {
		super();
		this.escenario = escenario;
		this.usuario = usuario;
		this.serpiente = serpiente;
	}

	public void run() {

		
			serpiente();
			escenario.limpiarSerpiente(serpiente);
			System.out.println("has muerto");
			
			
			int x = (int) (Math.random() );
			int y = (int) (Math.random() );
			y = y + (y % 10)+15;
			x = x + (x % 20)+15;
			serpiente.getCabeza().setPosicion(x,y);
			serpiente.revivir();
			// serpiente.getCabeza().setPosicion(15, 15);
			// serpiente.revivir();
		
	}

	private void serpiente() {
		long ti, tf;
		int c = 0, d = 0;
		while (!this.serpiente.getEstado()) {

			ti = System.currentTimeMillis();
			escenario.colicionador(this.serpiente);
			escenario.limpiarSerpiente(this.serpiente);

			if (c == 3) {
				switch (d) {
				case 0:
					serpiente.girar(Orientacion.O);
					break;
				case 1:
					serpiente.girar(Orientacion.N);
					break;
				case 2:
					serpiente.girar(Orientacion.E);
					break;
				case 3:
					serpiente.girar(Orientacion.S);
					break;
				}
				c = 0;
				d++;
				if (d == 4)
					d = 0;
			}
			
			if (!serpiente.getEstado()) {
				serpiente.avanzar();
				c++;
				escenario.colocarSerpiente(this.serpiente);
			}
			tf = System.currentTimeMillis();
			try {
				Thread.sleep(serpiente.getVelocidad() - (tf - ti));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
