package logica;

import Audio.PlayerThread;
import snake.Orientacion;
import snake.Serpiente;
import snake.Skin;

public class Session extends Thread {

	Escenario escenario;
	ConexionUsuario usuario;
	Serpiente serpiente;
	private PlayerThread elReproductor = null;
	public Session(Escenario escenario, ConexionUsuario usuario) {
		super();
		this.escenario = escenario;
		this.usuario = usuario;
		this.serpiente= escenario.crearSerpiente(10, 10, Orientacion.N, Skin.DORADA);
		this.usuario = usuario;
	}

	public void run() {
		
		//usuario.setDir(Orientacion.N);
		while(true) {
		serpiente();
		escenario.limpiarSerpiente(serpiente);
		System.out.println("has muerto");
		
		//ConexionUsuario.puntaje = 0;
		//System.out.println(ConexionUsuario.puntaje);
		serpiente.getCabeza().setPosicion(15, 15);
		usuario.gameOver = true;
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
		usuario.gameOver=false;
			
		serpiente.revivir();
	
		//ConexionUsuario.puntaje = 0;
		//ConexionUsuario.nivel = 1;
		
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
	
	public boolean estoyListoUsuario() {
		return usuario.getListo();
	}

}
