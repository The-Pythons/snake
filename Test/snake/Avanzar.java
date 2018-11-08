package snake;

import logica.Escenario;

//import org.junit.Test;

public class Avanzar {

	public static void main(String arg[]) {
		Escenario e = new Escenario(4, 4);
		e.crearSerpiente(2,2, Orientacion.N);
		//e.crearSerpiente(10, 15, Orientacion.N);
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
