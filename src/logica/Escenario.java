package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
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
	// ArrayList<Fruta> frutas;
	// ArrayList<Obstaculo> obstaculos;
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
		this.crearFruta(new Punto2D(20,5));
		this.crearObtaculo(10, 20);
		//crearParedes();
	}

	public  void run(){
		
		Serpiente s1 = getSerpiente(0);
		long ti,tf;
		
		while(!s1.getEstado()) {
			ti = System.currentTimeMillis();
			colicionador(s1);
			limpiarSerpiente(s1);
			s1.avanzar();
			colocarSerpiente(s1);
			tf = System.currentTimeMillis();
			System.out.println(tf-ti);
			try {
				Thread.sleep(s1.getVelocidad()-(tf-ti));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		limpiarSerpiente(s1);
		System.out.println("has muerto");
	}
	
	

	public void girarSerpiente(int id, Orientacion dir){
		getSerpiente(0).girar(dir);
	}
	// devueve el elemento de la determinada posicion de la matriz haciendo
	// facilmente
	// compatible codigos anteriores

	private Choques getElemofarea(Punto2D pos) {
		return area[pos.x][pos.y];
	}
	public ArrayList<Dibujable> getElementos(){
		return this.elementos;
	}

	private boolean posicionVacia(Punto2D pos) {
		return area[pos.x][pos.y] == null;
	}

	public void vaciarPosicion(Punto2D pos) {
		area[pos.x][pos.y] = null;
	}

	void crearObtaculo(Punto2D pos) {
		crearObtaculo(pos.x,pos.y);
	}
	
	void crearObtaculo(int x, int y) {
		Obstaculo o = new Obstaculo(x, y);
		Dibujable os= new obstaculoDibujable(o);
		area[x][y] = o;
		elementos.add(os);
	}

	public void crearFruta(Punto2D pos) {
		if (!pos.puntoCorrecto(dim_x, dim_y))
			return;
		Fruta f = new Fruta(pos);
		Dibujable fs= new frutaDibujable(f);
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
				x = ThreadLocalRandom.current().nextInt(1, dim_x-1);
				y = ThreadLocalRandom.current().nextInt(1, dim_y-1);
			} while (area[x][y] != null);// genero enteros al azar para x e y hasta que encuentro una ubicacion vacia
			// area[x][y] = new Fruta(x, y);// creo una fruta en ese lugar
			crearFruta(new Punto2D(x, y));
		}
	}

	public void crearSerpiente(int x, int y, Orientacion orientacion) {

		Serpiente s = new Serpiente(x, y,orientacion);
		Dibujable ss= new serpienteDibujable(s);
		area[x][y] = s;
		elementos.add(ss);
		serpientes.add(s);
	}

	public Serpiente getSerpiente(int id) {
		return serpientes.get(id);
	}
/*
	public boolean colisionadorSerpientes(Serpiente s1) { // Con el fin de probar el colisionador la funcion retorna un boolean
		Class<? extends Serpiente> c = new Serpiente(-1, -1, Orientacion.N).getClass();
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
				if (s2.getCuerpo().contains(cabezaS1)) { // S1 chocha con el cuerpo de s2
					s1.muere();
					elementos.remove(s1);
					vaciarPosicion(posicion);
					return true;
				}
			}
		}

		return false;

	}
*/
	void colicionador(Serpiente s1) {
		Punto2D pos = s1.getPosicionSig();
		if(!pos.puntoCorrecto(dim_x, dim_y)){
			limpiarSerpiente(s1);
			colocarSerpiente(s1);
			if(pos.y>=dim_y)
				s1.getCabeza().setPosicion(pos.x,1);
			if(pos.x>=dim_x)
				s1.getCabeza().setPosicion(1,pos.y);
			if(pos.y<=0)
				s1.getCabeza().setPosicion(pos.x,dim_y-1);
			if(pos.x<=0)
				s1.getCabeza().setPosicion(dim_x-1,pos.y);
			}
		
		 pos = s1.getPosicionSig();
		Choques e = getElemofarea(pos);
		if(e==null)
			return;
		e.chocar(s1);
		if(e.getEstado())
			e.eliminar(this);
	}
/*
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
*/
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
		while (itcuerpo.hasNext()) {
			Cuerpo cuerpo = itcuerpo.next();
			posicion = cuerpo.getPosicion();
			area[posicion.x][posicion.y] = s; // Body
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

	void avansanserpeintes() {

	}

	public void mostrar() {
		int i,j;
		for (i = 0; i < dim_y; i++) {
			for (j = 0; j < dim_x; j++) {
				if (!posicionVacia(new Punto2D(j, i)))
					System.out.print(elementos.indexOf(getElemofarea(new Punto2D(j, i))));
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
			System.out.println("\n");
		}

	}

}
