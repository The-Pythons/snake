package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import frutas.Fruta;
import frutas.frutaDibujable;
import obstaculo.*;
import snake.Cuerpo;
import snake.Orientacion;
import snake.Serpiente;
import snake.serpienteDibujable;

public class Escenario extends Thread {
	ArrayList<Serpiente> serpientes;
	ArrayList<Dibujable> elementos;
	Choques[][] area;
	int dim_x, dim_y;

	public Escenario(int dim_x, int dim_y) {
		this.dim_x = dim_x;
		this.dim_y = dim_y;
		area = new Choques[dim_x][dim_y];
		vaciarArea();
		serpientes = new ArrayList<Serpiente>();
		elementos = new ArrayList<Dibujable>();
		elementos.add(null);
		this.crearSerpiente(20, 10, Orientacion.N);
		Session s1 = new Session(this,this.getSerpiente(0),null);// Cada jugador va tener una session 
																// que sera un thread las intancia de la serpiente
		
		this.crearSerpiente(10, 10, Orientacion.S);
		colocarSerpiente(this.getSerpiente(1));
		this.crearFruta(new Punto2D(20, 5));
		this.crearObtaculo(10, 20);
		this.crearParedes();
		s1.start();
	}



	public void girarSerpiente(int id, Orientacion dir) {
		getSerpiente(0).girar(dir);
	}
	// devueve el elemento de la determinada posicion de la matriz haciendo
	// facilmente
	// compatible codigos anteriores

	private Choques getElemofarea(Punto2D pos) {
		return area[pos.x][pos.y];
	}

	
	/*
	 * Devuelve  el elemento dibujable proximamente esto no deberia estar y trbajaria con esto 
	 * solo el cliente mientras que servidor la logica.
	 */
	public ArrayList<Dibujable> getElementos() {
		return this.elementos;
	}

	
	/*
	 * Metodos que trabajan con la matriz 
	 */
	
	/*
	 * Vacia la posicion en la matriz
	 *  
	 */
	private boolean posicionVacia(Punto2D pos) {
		return area[pos.x][pos.y] == null;
	}
	
	/*
	 * Indica si la posicion de la matriz esta vacia
	 *  
	 */
	public void vaciarPosicion(Punto2D pos) {
		area[pos.x][pos.y] = null;
	}
	
	public void mostrar() {
		int i, j;
		for (i = 0; i < dim_y; i++) {
			for (j = 0; j < dim_x; j++) {
				if (!posicionVacia(new Punto2D(j, i)))
					System.out.print(1);
				else
					System.out.print("0");
			}
			System.out.println("\n");
		}
	}

	public void vaciarArea() {

		for (int i = 0; i < dim_x; i++) {
			for (int j = 0; j < dim_y; j++) {
				vaciarPosicion(new Punto2D(i, j));
			}
		}

	}

	/*
	 * 
	 * Son los metodos para crear correctamente los objetos 
	 * dentro del Escenario . Sin causar problemas . Donde se crea el objeto 
	 * colicionable en la matriz y su elemento dibujable en la 
	 * lista 
	 * PD: si quieren reducirlos mejor
	 *  
	 * */
	void crearObtaculo(Punto2D pos) {
		crearObtaculo(pos.x, pos.y);
	}
	
	void crearObtaculo(int x, int y) {
		Obstaculo o = new Obstaculo(x, y);
		Dibujable os = new obstaculoDibujable(o);
		area[x][y] = o;
		elementos.add(os);
	}

	public void crearFruta(Punto2D pos) {
		if (!pos.puntoCorrecto(dim_x, dim_y))
			return;
		Fruta f = new Fruta(pos);
		Dibujable fs = new frutaDibujable(f);
		area[pos.x][pos.y] = f;
		elementos.add(fs);
	}

	public void crearParedes() {// rodea todos los bordes del escenario con obstaculos
		for (int i = 0; i < dim_x; i++)// piso
			crearObtaculo(i, 0);
		for (int i = 1; i < dim_y; i++)// pared izq
			crearObtaculo(0, i);
		for (int i = 1; i < dim_y; i++)// pared der
			crearObtaculo(dim_x - 1, i);
		for (int i = 1; i < dim_x; i++)// techo
			crearObtaculo(i, dim_y - 1);
	}

	public void crearFrutaAzar(int cantidad) {
		int x, y, i;
		for (i = 0; i < cantidad; i++) {
			do {
				// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html
				x = ThreadLocalRandom.current().nextInt(1, dim_x - 1);
				y = ThreadLocalRandom.current().nextInt(1, dim_y - 1);
			} while (area[x][y] != null);// genero enteros al azar para x e y hasta que encuentro una ubicacion vacia
			// area[x][y] = new Fruta(x, y);// creo una fruta en ese lugar
			crearFruta(new Punto2D(x, y));
		}
	}
	

	public void crearSerpiente(int x, int y, Orientacion orientacion) {
		Serpiente s = new Serpiente(x, y, orientacion);
		Dibujable ss = new serpienteDibujable(s);
		//area[x][y] = s;
		colocarSerpiente(s);
		elementos.add(ss);
		serpientes.add(s);
	}

	public Serpiente getSerpiente(int id) {
		return serpientes.get(id);
	}

	/* Funciona gracias a la interfas choques. Todos los elementos "fisicos" con los que choca
	 * la serpiente incluyendose a si misma . Deberan tener implementada la interfas y de esta manera 
	 * el objeto sabe como reacionar y como  modificar a la serpiente dependiendo su efecto.
	 * Por ejemplo frutas dan punto y la hace crecer mientras que los obtaculos la matan.	
	*/
	void colicionador(Serpiente s1) {
		Punto2D pos = s1.getPosicionSig();
		pos = s1.getPosicionSig();
		Choques e = getElemofarea(pos);
		if (e == null)
			return;
		e.chocar(s1);
		if (e.getEstado()) {
			e.eliminar(this);
		}
		/*
		 * if(!pos.puntoCorrecto(dim_x, dim_y)){ limpiarSerpiente(s1);
		 * colocarSerpiente(s1); if(pos.y>=dim_y) s1.getCabeza().setPosicion(pos.x,1);
		 * if(pos.x>=dim_x) s1.getCabeza().setPosicion(1,pos.y); if(pos.y<=0)
		 * s1.getCabeza().setPosicion(pos.x,dim_y-1); if(pos.x<=0)
		 * s1.getCabeza().setPosicion(dim_x-1,pos.y); }
		 */
	}

	
	
	/*
	 * 
	 * Son los metodos por los cuales se actualiza el estado de la serpiente 
	 * en la matriz de coliciones :
	 * Colocar en la matriz ya sea de forma individual o todas las serpientes 
	 * en la matriz y de la misma manera eliminarlos de la misma  
	 *  
	 * */
	
	
	
	void colocarSerpientes() {
		Iterator<Serpiente> iterador = serpientes.iterator();
		while (iterador.hasNext()) {
			colocarSerpiente(iterador.next());

		}
	}

	public void colocarSerpiente(Serpiente s) {
		Punto2D posicion = s.cabeza.getPosicion();
		area[posicion.x][posicion.y] = s; // Head
		Iterator<Cuerpo> itcuerpo = s.getCuerpo().iterator();
		Cuerpo cuerpo;
		while (itcuerpo.hasNext()) {
			cuerpo = itcuerpo.next();
			posicion = cuerpo.getPosicion();
			area[posicion.x][posicion.y/10] = s; // Body
		}
	}

	public void limpiarSerpiente(Serpiente s) {

		Punto2D posicion = s.cabeza.getPosicion();
		vaciarPosicion(posicion); // Head
		Cuerpo cuerpo;
		Iterator<Cuerpo> itcuerpo = s.getCuerpo().iterator();
		while (itcuerpo.hasNext()) {
			cuerpo = itcuerpo.next();
			posicion = cuerpo.getPosicion();
			vaciarPosicion(posicion); // Body
		}

	}

	void limpiarSerpientes() {
		Iterator<Serpiente> iterador = serpientes.iterator();
		while (iterador.hasNext()) {
			Serpiente s = iterador.next();
			limpiarSerpiente(s);
			s = null;

		}
	}


}

