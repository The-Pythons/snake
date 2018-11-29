package logica;

import gui.PlayerThread;
import snake.Orientacion;
import snake.Serpiente;

public class Session extends Thread {

	Escenario escenario;
	Usuario usuario;
	Serpiente serpiente;
	private PlayerThread elReproductor = null;
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
		
		Usuario.puntaje = 0;
		System.out.println(Usuario.puntaje);
		serpiente.getCabeza().setPosicion(15, 15);
		Usuario.gameOver = 1;
		if(serpiente.getEstado())
		{
			elReproductor = new PlayerThread("./Audios/perdiste.mp3");
			elReproductor.start();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Usuario.gameOver = 0;
			
		serpiente.revivir();
	
		Usuario.puntaje = 0;
		Usuario.nivel = 1;
		
	}
}

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
