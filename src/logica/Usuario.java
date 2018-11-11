package logica;

import snake.Orientacion;

public class Usuario {

	public Orientacion dir=Orientacion.N;
	public static int puntaje = 0;
	public static int nivel = 1;
	public static int gameOver = 0;

	public Orientacion getDir() {
		return dir;
	}

	public void setDir(Orientacion dir) {
		this.dir = dir;
	}

	
	


}
