package logica;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Audio.PlayerThread;
import snake.Orientacion;
import snake.Serpiente;
import snake.Skin;

public class Session extends Thread {

	Escenario escenario;
	ConexionUsuario usuario;
	Serpiente serpiente;
	ObjectOutputStream salida;
	ObjectInputStream entrada;
	private PlayerThread elReproductor = null;
	public Session(Escenario escenario, ConexionUsuario usuario, ObjectOutputStream salida) {
		super();
		this.escenario = escenario;
		this.usuario = usuario;
		this.serpiente= escenario.crearSerpiente(10, 10, Orientacion.N, Skin.DORADA);
		this.usuario = usuario;
		this.salida = salida;
	}
	
	public Session(Escenario escenario, ConexionUsuario usuario, ObjectOutputStream salida, ObjectInputStream entrada) {
		super();
		this.escenario = escenario;
		this.usuario = usuario;
		this.serpiente= escenario.crearSerpiente(10, 10, Orientacion.N, Skin.DORADA);
		this.usuario = usuario;
		this.salida = salida;
		this.entrada = entrada;
	}

	public void run() {
		
		//usuario.setDir(Orientacion.N);
		while(true) {
		serpiente();
		escenario.limpiarSerpiente(serpiente);
//		System.out.println("has muerto");
		
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
				try {
					salida.writeObject(escenario.getElementos());
//					try {
////						entrada.readObject();
//					} catch (ClassNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
