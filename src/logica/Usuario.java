package logica;

import snake.Orientacion;

public class Usuario  implements Controlable{

	public Orientacion dir=Orientacion.N;
	public  int puntaje;
	public  int nivel;
	public  boolean gameover ;
	
	public Usuario() {
	}

	public Orientacion getDir() {
		return dir;
	}

	public void setDir(Orientacion dir) {
		this.dir = dir;
	}

	@Override
	public void muere() {
		gameover=true;
		
	}

	@Override
	public void setPuntaje(int i) {	
	}

	@Override
	public void setNivel(int i) {
		// TODO Auto-generated method stub
		
	}

	
	


}
