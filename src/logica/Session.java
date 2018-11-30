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
		
		usuario.puntaje = 0;
		
		System.out.println(usuario.puntaje);
		serpiente.getCabeza().setPosicion(15, 15);
		usuario.gameover = true;
		if(serpiente.getEstado()){
			try {
				Thread.sleep(2005);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		usuario.gameover = false;
			
		serpiente.revivir();
	
		usuario.puntaje = 0;
		usuario.nivel = 1;
	
	}}

	private void serpiente() {
		long ti, tf;

		while (!this.serpiente.getEstado()) {
			
			ti = System.currentTimeMillis();
			serpiente.girar(usuario.getDir());
			escenario.colicionador(this.serpiente);
			escenario.limpiarSerpiente(this.serpiente);
			if (!serpiente.getEstado()) {
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
