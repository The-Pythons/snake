package snake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Escenario {
	ArrayList<Serpiente> serpientes;
	ArrayList<Fruta> frutas;
	ArrayList<Obstaculo> obstaculos;
	Object[][] area;
	int dim_x, dim_y;

	public Escenario(int dim_x, int dim_y) {
		this.dim_x = dim_x;
		this.dim_y = dim_y;
		area = new Object[dim_x][dim_y];
		serpientes = new ArrayList<Serpiente>();
	}

	void crearParedes() {// rodea todos los bordes del escenario con obstaculos
		for (int i = 0; i < dim_x; i++)// piso
			area[i][0] = new Obstaculo(i, 0);
		for (int i = 1; i < dim_y; i++)// pared izq
			area[0][i] = new Obstaculo(0, i);
		for (int i = 1; i < dim_y; i++)// pared der
			area[dim_x - 1][i] = new Obstaculo(dim_x - 1, i);
		for (int i = 1; i < dim_x; i++)// techo
			area[i][dim_y - 1] = new Obstaculo(i, dim_y - 1);
	}

	void crearFruta(int cantidad) {
		int x, y, i;
		for (i = 0; i < cantidad; i++) {
			do {
				// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html
				x = ThreadLocalRandom.current().nextInt(0, dim_x);
				y = ThreadLocalRandom.current().nextInt(0, dim_y);
			} while (area[x][y] != null);// genero enteros al azar para x e y hasta que encuentro una ubicacion vacia
//			area[x][y] = new Fruta(x, y);// creo una fruta en ese lugar
			area[1][1] = new Fruta(1, 1); // Con el fin de probar el colisionador se crea una fruta en un lugar conocido
		}
	}

	void crearSerpiente(int x, int y, int orientacion) {
		serpientes.add(new Serpiente(x, y, orientacion));
	}

	public Serpiente getSerpiente(int id) {
		return serpientes.get(id);
	}

	boolean colisionadorSerpientes() { // Con el fin de probar el colisionador la funcion retorna un boolean
		for (Serpiente s1 : serpientes) {
			for (Serpiente s2 : serpientes) {
				if (!s1.equals(s2)) { // s1 y s2 serpientes diferentes
					if (s1.cabeza.equals(s2.cabeza)) { // Choque de frente
						s1.muere();
						s2.muere();
						s2 = s1 = null;
						return true;
					} else {
						Cuerpo cabezaS1 = new Cuerpo(s1.cabeza.getPosicion(), s1.cabeza.getOrientacion());
						if (s2.cuerpo.contains(cabezaS1)) { // S1 chocha con el cuerpo de s2
							s1.muere();
							s1 = null;
							return true;
						}
					}
				}

			}

		}
		return false;
	}

	boolean colisionadorConObstaculos() { // Con el fin de probar el colisionador la funcion retorna un boolean
		Class c = new Obstaculo(-1, -1).getClass();
		for (Serpiente s1 : serpientes) {
			Punto2D posicion = s1.cabeza.getPosicion();
			if (area[posicion.x][posicion.y].getClass().equals(c)) { // Si en la posicion de la cabeza de s1 hay un
																		// obstaculo
				s1.muere();
				s1 = null;
				return true;
			}
		}
		return false;
	}

	boolean colisionadorConComida() { // Con el fin de probar el colisionador la funcion retorna un boolean
		Class c = new Fruta(-1, -1).getClass();
		for (Serpiente s1 : serpientes) {
			Punto2D posicion = s1.cabeza.getPosicion();
			if (area[posicion.x][posicion.y].getClass().equals(c)) { // Si en la posicion de la cabeza de s1 hay fruta
				s1.comer((Fruta) (area[posicion.x][posicion.y]));
				return true;
			}

		}
		return false;
	}

	void colocarSerpiente() {
		Iterator<Serpiente> iterador = serpientes.iterator();
		while (iterador.hasNext()) {
			Serpiente s = iterador.next();
			Punto2D posicion = s.cabeza.getPosicion();
			area[posicion.x][posicion.y] = "H"; // Head
			Iterator<Cuerpo> itcuerpo = s.cuerpo.iterator();
			while (itcuerpo.hasNext()) {
				Cuerpo cuerpo = itcuerpo.next();
				posicion = cuerpo.getPosicion();
				area[posicion.x][posicion.y] = "B"; // Body
			}
		}
	}

	void limpiarSerpiente() {
		for (int i = 0; i < dim_y; i++) {
			for (int j = 0; j < dim_x; j++) {
				if (area[j][i] == "H" || area[j][i] == "B")
					area[j][i] = null;
			}
		}
	}

	public void mostrar() {
		limpiarSerpiente();
		colocarSerpiente();
		for (int i = 0; i < dim_y; i++) {
			for (int j = 0; j < dim_x; j++) {
				if (area[j][i] != null)
					System.out.print(area[j][i]);
				else
					System.out.print("0");
			}
			System.out.println("\n");
		}
	}

	

}
