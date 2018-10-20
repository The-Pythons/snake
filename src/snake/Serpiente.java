package snake;

import java.util.ArrayList;

public class Serpiente implements Direcciones{
	
	Punto2D cabeza;
	ArrayList<Punto2D> cuerpo;
	int orientacion;//direccion en la que avanza la serpiente, enviar inputs para mover a la izq o der la modificaria.
					// norte/sur/este/oeste estan definidas como constantes en la interfaz direcciones.
	public Serpiente(int x, int y,int orientacion) {
		this.cabeza= new Punto2D(x,y);
		this.orientacion = orientacion;
		this.cuerpo = new ArrayList<Punto2D>();
		switch(orientacion) {//agrego el primer segmento del cuerpo detras de la cabeza, dependiendo de donde "mira"
		case N:
			cuerpo.add(new Punto2D(x,y-1));
			break;
		case S:
			cuerpo.add(new Punto2D(x,y+1));
			break;
		case O:
			cuerpo.add(new Punto2D(x+1,y));
			break;
		default:
			cuerpo.add(new Punto2D(x-1,y));
		}
	}
	
	public void crecer() {
		Punto2D seg = this.cabeza;
		switch(orientacion) {
		case N:
			cabeza.y++;
			break;
		case S:
			cabeza.y--;
			break;
		case O:
			cabeza.x--;
			break;
		default:
			cabeza.x++;
		}
		this.cuerpo.add(seg);
	}	
	/*
	 * muevo la cabeza una unidad y "relleno" con un segmento donde esta estaba.
	 * (no se debe agregar un segmento antes de moverse)
	 * si manejo el crecimiento de esta forma, la lista con los N segmentos de la
	 * serpiente estaria ordenada de la sig manera:
	 * primer elemento: cola de la serpiente
	 * ultimo elemento: segmento antes de la cabeza
	 */
	public void avanzar() {
		Punto2D sig = this.cabeza;
		Punto2D actual;
		switch(orientacion) {//avanzo una unidad la cabeza
		case N:
			cabeza.y++;
			break;
		case S:
			cabeza.y--;
			break;
		case O:
			cabeza.x--;
			break;
		default:
			cabeza.x++;
		}
		//desde el ultimo elemento de la lista de segmentos del cuerpo hasta el primero, 
		//reemplazo a cada uno con el elemento que esta adelante.
		for(int i=cuerpo.size();i>0;i--)
		{
			actual=cuerpo.get(i-1);
			cuerpo.set(i-1, sig);
			sig=actual;
		}
	}

	public void muere() {
		// TODO Auto-generated method stub
		
	}

	public void comer(Fruta object) {
		this.crecer();
		
	}

	
}


