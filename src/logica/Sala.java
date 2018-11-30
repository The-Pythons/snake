package logica;

import java.util.ArrayList;

import snake.Orientacion;
import snake.Serpiente;
import snake.Skin;

public class Sala {
	private Partida partida;
	private ArrayList<Controlador> usuariosenlasala;
	private Escenario escenario;
	
	public Sala() {
		this.escenario = new Escenario(30, 24);
	}
	
	public void nuevaPartida() {
		
		
	}
	public void nuevoUsuario(Usuario usuario) {
		Serpiente s= this.escenario.crearSerpiente(10, 10, Orientacion.N,Skin.ROSA);
		Controlador c=new Controlador(escenario, s, usuario);;
		usuariosenlasala.add(c);
		c.start();
	}

}
