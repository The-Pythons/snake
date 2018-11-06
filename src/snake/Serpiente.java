package snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import frutas.Fruta;
import logica.Choques;
import logica.Escenario;
import logica.Punto2D;



public class Serpiente  implements Choques{

	public Cabeza cabeza;
	ArrayList<Cuerpo> cuerpo;
//	private int orientacion;// direccion en la que avanza la serpiente, enviar inputs para mover a la izq o
	// der la modificaria.
	// norte/sur/este/oeste estan definidas como constantes en la interfaz
	// direcciones.

	public Serpiente(int x, int y, Orientacion orientacion) {
		this.cabeza = new Cabeza(x, y, orientacion);
		this.cuerpo = new ArrayList<Cuerpo>();
		Cuerpo c = new Cuerpo( new Punto2D(x,y), orientacion);
		c.moverI();
		this.cuerpo.add(c);
		
	}
	

	public void crecer() {
		/*
		 * Agrega un segmento de cuerpo al final de la lista en funcion del ultimo
		 * segmento
		 */
		Orientacion orientacion = this.cuerpo.get(this.cuerpo.size() - 1).getOrientacion();
		Punto2D posicion = this.cuerpo.get(this.cuerpo.size() - 1).getPosicion();
		Cuerpo c = new Cuerpo( new Punto2D(posicion.x,posicion.y), orientacion);
		c.moverI();
		this.cuerpo.add(c);
	
	
	}
	public Punto2D getPosicionSig(){
		Punto2D pos = this.cabeza.getPosicion();
		
		
		switch (this.cabeza.getOrientacion()) { // Muevo la cabeza
		case N:
			return new Punto2D(pos.x,pos.y-1);
		case S:
			return new Punto2D(pos.x,pos.y+1);
		case O:
			return new Punto2D(pos.x+1,pos.y);
		default:
			return new Punto2D(pos.x-1,pos.y);
		}
	
	}

	public void avanzar() {
		Orientacion orientacion = this.cabeza.getOrientacion();
		//Orientacion auxo;
		Punto2D posicion = this.cabeza.getPosicion();
		Cuerpo aux = new Cuerpo(new Punto2D(posicion.x,posicion.y), orientacion); // Guardo la posicion de la cabeza
		for (int i = this.cuerpo.size() - 1; i > 0; i--) { // Desde el ultimo segmento de cuerpo reemplazo con el anterior
			this.cuerpo.set(i, this.cuerpo.get(i - 1));
		}
		this.cuerpo.set(0, aux); // El primer segmento queda en la posicion que tenia la cebeza
		
		/*for (Iterator iterator = cuerpo.iterator(); iterator.hasNext();) {
			Cuerpo cu = (Cuerpo) iterator.next();
			auxo = cu.getOrientacion();
			cu.setOrientacion(orientacion);
			cu.mover();
			auxo=orientacion;
		}*/
		this.cabeza.setPosicion(getPosicionSig());

		
	}
	public void muere() {

	}

	public void comer(Fruta object) {
		this.crecer();
	}

	public Cabeza getCabeza() {
		return cabeza;
	}

	public ArrayList<Cuerpo> getCuerpo() {
		return cuerpo;
	}

	public void girar(Orientacion dir) {
		cabeza.setOrientacion(dir);
		
	}


	@Override
	public void chocar(Serpiente s1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean getEstado() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ArrayList<Punto2D> eliminar() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void eliminar(Escenario escenario) {
		escenario.limpiarSerpiente(this);
		
	}




}
