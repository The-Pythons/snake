package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import frutas.Fruta;
import frutas.frutaDibujable;
import obstaculo.*;
import powerups.PowerUp;
import powerups.PowerUpDibujable;
import snake.Cuerpo;
import snake.Orientacion;
import snake.Serpiente;
import snake.Skin;
import snake.serpienteDibujable;

public class Escenario extends Thread {
	ArrayList<Serpiente> serpientes;
	ArrayList<Dibujable> elementos;
	
	Choques[][] area;
	int dim_x, dim_y;
	ConexionUsuario usuario;
	int frutas;
	public int frutaactual;

	public Escenario(int dim_x, int dim_y) {
		this.dim_x = dim_x;
		this.dim_y = dim_y;
		this.frutaactual=0;
		area = new Choques[dim_x][dim_y];
		vaciarArea();
		serpientes = new ArrayList<Serpiente>();
		elementos = new ArrayList<Dibujable>();
		elementos.add(null);
		this.frutas = 0;
		// mover de aqui a una sala de testeo
		//this.crearSerpiente(20, 10, Orientacion.N, Skin.ROSA);
		// El 4to parametro indica el color de la serpiente
		//usuario = new ConexionUsuario();
		//Session s1 = new Session(this, usuario);// Cada jugador va tener una session
		// que sera un thread las intancia de la serpiente

		//this.crearSerpiente(10, 10, Orientacion.S, Skin.VERDE); // El 4to parametro indica el color de la serpiente
		//this.getSerpiente(1).crecer();
		//this.getSerpiente(1).crecer();
		//this.getSerpiente(1).crecer(); ///BOOT
		// this.colocarSerpiente(this.getSerpiente(1));
		
		/////Agregando/////////
		/*	this.crearFruta(new Punto2D(10, 2));
			this.crearObtaculo((int)(Math.random()*29)+1,(int)(Math.random()*23)+1);
			this.crearObtaculo((int)(Math.random()*29)+1,(int)(Math.random()*23)+1);
			this.crearObtaculo((int)(Math.random()*29)+1,(int)(Math.random()*23)+1);
			this.crearObtaculo((int)(Math.random()*29)+1,(int)(Math.random()*23)+1);
			this.crearObtaculo((int)(Math.random()*29)+1,(int)(Math.random()*23)+1);
			this.crearObtaculo((int)(Math.random()*29)+1,(int)(Math.random()*23)+1);
		*//////
		//this.crearFruta(new Punto2D(20, 5));
		//this.crearObtaculo(10, 20);
		//this.crearParedes();
		//s1.start();

		//SessionBot sbot = new SessionBot(this, null);
		//sbot.start();

	}

	public void girarSerpiente(int id, Orientacion dir) {
		getSerpiente(0).girar(dir);
	}
	// devueve el elemento de la determinada posicion de la matriz haciendo
	// facilmente
	// compatible codigos anteriores

	private synchronized Choques getElemofarea(Punto2D pos) {
		return area[pos.x][pos.y];
	}

	/*
	 * Devuelve el elemento dibujable proximamente esto no deberia estar y trbajaria
	 * con esto solo el cliente mientras que servidor la logica.
	 */
	public synchronized ArrayList<Dibujable> getElementos() {
		return this.elementos;
	}

	/*
	 * Metodos que trabajan con la matriz
	 */

	/*
	 * Vacia la posicion en la matriz
	 * 
	 */
	private synchronized boolean posicionVacia(Punto2D pos) {
		return area[pos.x][pos.y] == null;
	}

	/*
	 * Indica si la posicion de la matriz esta vacia
	 * 
	 */
	public synchronized void vaciarPosicion(Punto2D pos) {
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
	 * Son los metodos para crear correctamente los objetos dentro del Escenario .
	 * Sin causar problemas . Donde se crea el objeto colicionable en la matriz y su
	 * elemento dibujable en la lista PD: si quieren reducirlos mejor
	 * 
	 */
	void crearObtaculo(Punto2D pos) {
		crearObtaculo(pos.x, pos.y);
	}


	void crearObtaculo(int x, int y) {
		Obstaculo o = new Obstaculo(x, y);
		Dibujable os = new obstaculoDibujable(o);
		//area[x][y] = o;
		agregarArea(new Punto2D(x,y),o);
		agregarALaLista(os);
	}
	

	public void crearFruta(Punto2D pos) {
		if (!pos.puntoCorrecto(dim_x, dim_y))
			return;
		Fruta f = new Fruta(pos);
		Dibujable fs = new frutaDibujable(f);
		//area[pos.x][pos.y] = f;
		agregarArea(pos,f);
		agregarALaLista(fs);
		this.frutas++;
	}
	public void crearPowerUp(Punto2D pos,String tipo) {
		if (!pos.puntoCorrecto(dim_x, dim_y))
			return;
		PowerUp f = new PowerUp(pos,tipo);
		Dibujable fs = new PowerUpDibujable(f);
		//area[pos.x][pos.y] = f;
		agregarArea(pos,f);
		agregarALaLista(fs);
		//this.frutas++;
	}
	public  void  agregarALaLista(Dibujable o){
		elementos.add(o);
	}

	public synchronized void agregarArea(Punto2D punto, Choques obj){
		area[punto.x][punto.y] = obj;
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

	synchronized public void crearFrutaAzar(int cantidad) {
		int x, y, i;
		String powerups[]= {"achicar"};
		for (i = 0; i < cantidad; i++) {
			do {
				// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html
				x = ThreadLocalRandom.current().nextInt(1, dim_x - 1);
				y = ThreadLocalRandom.current().nextInt(1, dim_y - 1);
			} while (!posicionVacia(new Punto2D(x,y)));// genero enteros al azar para x e y hasta que encuentro una ubicacion vacia
			// area[x][y] = new Fruta(x, y);// creo una fruta en ese lugar
			if(ThreadLocalRandom.current().nextInt(0, 100)<15)
				crearPowerUp(new Punto2D(x,y),powerups[0]);
			else
			{crearFruta(new Punto2D(x, y));
			this.frutas++;}
		}
		this.frutaactual=0;
	}
	
	synchronized public void crearPowerUpAzar(int cantidad,String tipo) {
		int x, y, i;
		for (i = 0; i < cantidad; i++) {
			do {
				x = ThreadLocalRandom.current().nextInt(1, dim_x - 1);
				y = ThreadLocalRandom.current().nextInt(1, dim_y - 1);
			} while (!posicionVacia(new Punto2D(x,y)));
			crearPowerUp(new Punto2D(x, y),tipo);
			this.frutas++;
		}
		this.frutaactual=0;
	}

	public Serpiente crearSerpiente(int x, int y, Orientacion orientacion, Skin color) {
		Serpiente s = new Serpiente(x, y, orientacion);
		Dibujable ss = new serpienteDibujable(s, color); // ingresar en el 2do parametro valores
		// de 1-4 para cambiar el color del snake
		// area[x][y] = s;
		colocarSerpiente(s);
		agregarALaLista(ss);
		serpientes.add(s);
		return s;
	}

	public Serpiente getSerpiente(int id) {
		return serpientes.get(id);
	}

	/*
	 * Funciona gracias a la interfas choques. Todos los elementos "fisicos" con los
	 * que choca la serpiente incluyendose a si misma . Deberan tener implementada
	 * la interfaz y de esta manera el objeto sabe como reaccionar y como modificar a
	 * la serpiente dependiendo su efecto. Por ejemplo frutas dan punto y la hace
	 * crecer mientras que los obtaculos la matan.
	 */
	synchronized void colicionador(Serpiente s1) {
		Punto2D pos = s1.getPosicionSig();
		pos = s1.getPosicionSig();
		Choques e = getElemofarea(pos);
		if (e == null)
			return;
		e.chocar(s1);
		if (e.getEstado()) {
			e.eliminar(this);
			//ConexionUsuario.puntaje++;
			//System.out.println(ConexionUsuario.puntaje);
			//if (ConexionUsuario.puntaje % 10 == 0)
				//ConexionUsuario.nivel++;
		}
	}
	/*
	 * if(!pos.puntoCorrecto(dim_x, dim_y)){ limpiarSerpiente(s1);
	 * colocarSerpiente(s1); if(pos.y>=dim_y) s1.getCabeza().setPosicion(pos.x,1);
	 * if(pos.x>=dim_x) s1.getCabeza().setPosicion(1,pos.y); if(pos.y<=0)
	 * s1.getCabeza().setPosicion(pos.x,dim_y-1); if(pos.x<=0)
	 * s1.getCabeza().setPosicion(dim_x-1,pos.y); }
	 */

	/*
	 * 
	 * Son los metodos por los cuales se actualiza el estado de la serpiente en la
	 * matriz de coliciones : Colocar en la matriz ya sea de forma individual o
	 * todas las serpientes en la matriz y de la misma manera eliminarlos de la
	 * misma
	 * 
	 */

	synchronized void colocarSerpientes() {
		Iterator<Serpiente> iterador = serpientes.iterator();
		while (iterador.hasNext())
			colocarSerpiente(iterador.next());
	}

	synchronized public void colocarSerpiente(Serpiente s) {

		Punto2D posicion = s.cabeza.getPosicion();
		area[posicion.x][posicion.y] = s; // Head
		Iterator<Cuerpo> itcuerpo = s.getCuerpo().iterator();
		Cuerpo cuerpo;
		while (itcuerpo.hasNext()) {
			cuerpo = itcuerpo.next();
			posicion = cuerpo.getPosicion();
			//area[posicion.x][posicion.y] = s; // Body
			agregarArea(posicion,s);
		}
	}

	synchronized public void limpiarSerpiente(Serpiente s) {

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

	synchronized void limpiarSerpientes() {
		Iterator<Serpiente> iterador = serpientes.iterator();
		while (iterador.hasNext()) {
			Serpiente s = iterador.next();
			limpiarSerpiente(s);
			s = null;

		}
	}

	public ConexionUsuario getUsuario() {
		return usuario;
	}

}

