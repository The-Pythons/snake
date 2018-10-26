package snake;

//import org.junit.Test;

public class Avanzar implements Direcciones{

	public static void main(String arg[]) {
		Escenario e = new Escenario(5, 5);
		e.crearSerpiente(2, 2, 2);
		e.mostrar();
		System.out.println("-------------------");
		e.serpientes.get(0).avanzar();
		e.serpientes.get(0).avanzar();
		System.out.println("-------------------");
		e.mostrar();
	}

}
