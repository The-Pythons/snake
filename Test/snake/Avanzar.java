package snake;

//import org.junit.Test;

public class Avanzar implements Direcciones{

	public static void main(String arg[]) {
		Escenario e = new Escenario(5, 5);
		e.crearSerpiente(2, 2, E);
		e.crearSerpiente(4, 4, E);
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
