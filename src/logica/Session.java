package logica;

import snake.Serpiente;

public class Session extends Thread {

	Escenario escenario;
	Usuario usuario;
	Serpiente serpiente;

	public Session(Escenario escenario,Serpiente serpiente, Usuario usuario) {
		super();
		this.escenario = escenario;
		this.usuario = usuario;
		this.serpiente=serpiente;
	}

	public void run() {

		long ti, tf;

		while (!this.serpiente.getEstado()) {
			ti = System.currentTimeMillis();
			escenario.colicionador(this.serpiente);
			escenario.limpiarSerpiente(this.serpiente);
			if (!serpiente.getEstado()) {
				serpiente.avanzar();
				escenario.colocarSerpiente(serpiente);
			}
			tf = System.currentTimeMillis();
			try {
				Thread.sleep(serpiente.getVelocidad() - (tf - ti));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		escenario.limpiarSerpiente(serpiente);
		System.out.println("has muerto");
	}

}
