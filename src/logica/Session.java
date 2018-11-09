package logica;

import snake.Orientacion;
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
		this.usuario = usuario;
	}

	public void run() {

		
		//usuario.setDir(Orientacion.N);
		
		while(true) {
		serpiente();
		escenario.limpiarSerpiente(serpiente);
		System.out.println("has muerto");
		
		serpiente.getCabeza().setPosicion(15, 15);
		serpiente.revivir();
	}}

	private void serpiente() {
		long ti, tf;

		while (!this.serpiente.getEstado()) {
			
			ti = System.currentTimeMillis();
			escenario.colicionador(this.serpiente);
			escenario.limpiarSerpiente(this.serpiente);
			if (!serpiente.getEstado()) {
				serpiente.girar(usuario.getDir());
				serpiente.avanzar();
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