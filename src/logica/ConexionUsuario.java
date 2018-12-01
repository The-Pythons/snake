package logica;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Queue;

import snake.Orientacion;

public class ConexionUsuario {

	public Orientacion dir=Orientacion.N;
	public Queue<Orientacion> colaDire;
	public int puntaje;
	public  int nivel = 1;
	public boolean gameOver;
	public boolean listo;
	public Orientacion diractual;
	
	
	
	public void estoyListo() {
		listo=true;
	}
	public boolean getListo() {
		return listo;
	}
	
	public ConexionUsuario() {
		this.colaDire =  new LinkedList<Orientacion>();
	}

	public Orientacion getDir() {
		Orientacion dire=colaDire.poll();
		if(dire != null)
			this.dir=dire;
		return this.dir;
	}

	public void recibirDir(Orientacion newdir){
		if(colaDire.size()<5)
			colaDire.add(newdir);
	}
	
	public void setDir(Orientacion newdir) {
			if(newdir==Orientacion.E && dir!=Orientacion.O )
				dir = Orientacion.E;
			if(newdir==Orientacion.O && dir!=Orientacion.E )
				dir = Orientacion.O;
			if(newdir==Orientacion.N && dir!=Orientacion.S )
				dir = Orientacion.N;
			if(newdir==Orientacion.S && dir!=Orientacion.N )
				dir = Orientacion.S;
	}

	
	


}
