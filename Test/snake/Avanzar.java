package snake;

import logica.Escenario;

//import org.junit.Test;

public class Avanzar {

	public static void main(String arg[]) {
		Escenario e = new Escenario(6, 6);
		e.crearSerpiente(1, 2, Orientacion.N);
		e.crearSerpiente(4, 4, Orientacion.N);
		e.mostrar();
		System.out.println("-------------------");
		e.limpiarSerpiente(e.getSerpiente(0));
		e.getSerpiente(0).avanzar();
		e.getSerpiente(0).avanzar();
		e.colocarSerpiente(e.getSerpiente(0));
		System.out.println("-------------------");
		e.mostrar();
	}

}
