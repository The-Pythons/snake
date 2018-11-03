package snake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class Escenario extends Thread {
	ArrayList<Serpiente> serpientes;
	// ArrayList<Fruta> frutas;
	// ArrayList<Obstaculo> obstaculos;
	ArrayList<Object> elementos;
	Object[][] area;
	int dim_x, dim_y;

	public Escenario(int dim_x, int dim_y) {
		this.dim_x = dim_x;
		this.dim_y = dim_y;
		area = new Object[dim_x][dim_y];
		vaciarArea();
		serpientes = new ArrayList<Serpiente>();
		elementos = new ArrayList<Object>();
		elementos.add(0);
	}

	public  void run(){
		Timer tiempo;
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				limpiarSerpiente(getSerpiente(0));
				getSerpiente(0).avanzar();
				colocarSerpiente(getSerpiente(0));
			}
		};
		tiempo = new Timer();
		//tiempo.scheduleAtFixedRate(tarea, 0, 2000);
		tiempo.schedule(tarea, 1000);
	}
	
	
	public void girarSerpiente(int id, int dir){
		getSerpiente(0).girar(dir);
	}
	// devueve el elemento de la determinada posicion de la matriz haciendo
	// facilmente
	// compatible codigos anteriores

	private Object getElemofarea(Punto2D pos) {
		return area[pos.x][pos.y];
	}
	

	private boolean posicionVacia(Punto2D pos) {
		return area[pos.x][pos.y] == null;
	}

	private void vaciarPosicion(Punto2D pos) {
		area[pos.x][pos.y] = null;
	}

	void crearObtaculo(Punto2D pos) {
		Obstaculo o = new Obstaculo(pos.x, pos.y);
		area[pos.x][pos.y] = o;
		elementos.add(o);
	}

	void crearObtaculo(int x, int y) {
		Obstaculo o = new Obstaculo(x, y);
		area[x][y] = o;
		elementos.add(o);
	}

	void crearFruta(Punto2D pos) {
		if (!pos.puntoCorrecto(dim_x, dim_y))
			return;
		area[pos.x][pos.y] = elementos.size();
		elementos.add(new Fruta(pos));
	}

	void crearParedes() {// rodea todos los bordes del escenario con obstaculos
		for (int i = 0; i < dim_x; i++)// piso
			crearObtaculo(i, 0);
		for (int i = 1; i < dim_y; i++)// pared izq
			crearObtaculo(0, i);
		for (int i = 1; i < dim_y; i++)// pared der
			crearObtaculo(dim_x - 1, i);
		for (int i = 1; i < dim_x; i++)// techo
			crearObtaculo(i, dim_y - 1);
	}

	void crearFrutaAzar(int cantidad) {
		int x, y, i;
		for (i = 0; i < cantidad; i++) {
			do {
				// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html
				x = ThreadLocalRandom.current().nextInt(0, dim_x);
				y = ThreadLocalRandom.current().nextInt(0, dim_y);
			} while (area[x][y] != null);// genero enteros al azar para x e y hasta que encuentro una ubicacion vacia
			// area[x][y] = new Fruta(x, y);// creo una fruta en ese lugar
			crearFruta(new Punto2D(x, y));
		}
	}

	void crearSerpiente(int x, int y, int orientacion) {

		Serpiente s = new Serpiente(x, y, orientacion);
		serpientes.add(s);
		elementos.add(s);
		colocarSerpiente(s);
	}

	public Serpiente getSerpiente(int id) {
		return serpientes.get(id);
	}

	boolean colisionadorSerpientes(Serpiente s1) { // Con el fin de probar el colisionador la funcion retorna un boolean
		Class<? extends Serpiente> c = new Serpiente(-1, -1, 1).getClass();
		Punto2D posicion = s1.cabeza.getPosicion();
		Serpiente s2;
		if (getElemofarea(posicion).getClass().equals(c)) {
			// Si en la posicion de la cabeza de s1 hay una // serpiente
			s2 = (Serpiente) getElemofarea(posicion);
			if (s1.cabeza.equals(s2.cabeza)) { // Choque de frente
				s1.muere();
				s2.muere();
				elementos.remove(s1);
				elementos.remove(s2);
				vaciarPosicion(posicion);
				return true;
			} else {
				Cuerpo cabezaS1 = new Cuerpo(s1.cabeza.getPosicion(), s1.cabeza.getOrientacion());
				if (s2.cuerpo.contains(cabezaS1)) { // S1 chocha con el cuerpo de s2
					s1.muere();
					elementos.remove(s1);
					vaciarPosicion(posicion);
					return true;
				}
			}
		}

		return false;

	}

	void Colicionador(Serpiente s1) {
		if (colisionadorConObstaculos(s1))
			return;
		if (colisionadorConComida(s1))
			return;
		if (colisionadorConComida(s1))
			return;
	}

	boolean colisionadorConObstaculos(Serpiente s1) { // Con el fin de probar el colisionador la funcion retorna un
														// boolean
		Class<? extends Obstaculo> c = new Obstaculo(-1, -1).getClass();
		Punto2D posicion = s1.cabeza.getPosicion();
		if (getElemofarea(posicion).getClass().equals(c)) {
			// Si en la posicion de la cabeza de s1 hay un // obstaculo
			s1.muere();
			s1 = null;
			return true;
		}
		return false;
	}

	boolean colisionadorConComida(Serpiente s1) { // Con el fin de probar el colisionador la funcion retorna un boolean
		Class<? extends Fruta> c = new Fruta(-1, -1).getClass();
		Punto2D posicion = s1.cabeza.getPosicion();
		if (getElemofarea(posicion).getClass().equals(c)) { // Si en la posicion de la cabeza de s1 hay fruta
			s1.comer((Fruta) getElemofarea(posicion));
			return true;
		}
		return false;
	}

	void colocarSerpientes() {
		Iterator<Serpiente> iterador = serpientes.iterator();
		while (iterador.hasNext()) {
			colocarSerpiente(iterador.next());

		}
	}

	void colocarSerpiente(Serpiente s) {
		Punto2D posicion = s.cabeza.getPosicion();
		area[posicion.x][posicion.y] = s; // Head
		Iterator<Cuerpo> itcuerpo = s.cuerpo.iterator();
		while (itcuerpo.hasNext()) {
			Cuerpo cuerpo = itcuerpo.next();
			posicion = cuerpo.getPosicion();
			area[posicion.x][posicion.y] = s; // Body
		}
	}

	void limpiarSerpiente(Serpiente s) {

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

	void avansanserpeintes() {

	}

	public void mostrar() {
		for (int i = 0; i < dim_y; i++) {
			for (int j = 0; j < dim_x; j++) {
				if (!posicionVacia(new Punto2D(i, j)))
					System.out.print(elementos.indexOf(getElemofarea(new Punto2D(i, j))));
				else
					System.out.print("0");
			}
			System.out.println("\n");
		}
	}

	public void vaciarArea() {

		for (int i = 0; i < dim_y; i++) {
			for (int j = 0; j < dim_x; j++) {
				vaciarPosicion(new Punto2D(i, j));
			}
			System.out.println("\n");
		}

	}

}
