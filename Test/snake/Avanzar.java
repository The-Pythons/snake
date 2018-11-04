package snake;

//import org.junit.Test;

public class Avanzar {

	public static void main(String arg[]) {
		Escenario e = new Escenario(5, 5);
		e.crearSerpiente(2, 2, Orientacion.E);
		e.crearSerpiente(4, 4, Orientacion.E);
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
