package snake;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import logica.Escenario;
import logica.Punto2D;

class Colisionador{

	@Test
	void testSerpientesDeFrente() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1, Orientacion.E);
		e1.crearSerpiente(1, 1, Orientacion.O);
		Assert.assertEquals(true, e1.colisionadorSerpientes(e1.getSerpiente(0)));
	}
	@Test
	void testSerpientesContraElCuerpo() {
		Escenario e1 = new Escenario(4, 4);
		e1.crearSerpiente(1, 1, Orientacion.E);
		e1.crearSerpiente(1, 2, Orientacion.O);
		e1.limpiarSerpiente(e1.getSerpiente(0));
		e1.getSerpiente(0).avanzar(); 
		e1.colocarSerpiente(e1.getSerpiente(0));
		Assert.assertEquals(true, e1.colisionadorSerpientes(e1.getSerpiente(0)));
	}
	@Test
	void testSerpientesSinColisionar() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1,  Orientacion.E);
		e1.crearSerpiente(1, 0,  Orientacion.N);
		Assert.assertEquals(false, e1.colisionadorSerpientes(e1.getSerpiente(0)));
	}
	@Test
	void testSerpientesMismaPosicion() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1,  Orientacion.E);
		e1.crearSerpiente(1, 1,  Orientacion.E);
		e1.limpiarSerpiente(e1.getSerpiente(0));
		e1.getSerpiente(0).avanzar(); 
		e1.colocarSerpiente(e1.getSerpiente(0));
		Assert.assertEquals(true, e1.colisionadorSerpientes(e1.getSerpiente(0)));
	}
	@Test
	void testFruta() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1,  Orientacion.E);
		e1.crearFruta(new Punto2D(1,1));
		e1.limpiarSerpiente(e1.getSerpiente(0));
		e1.getSerpiente(0).avanzar(); 
		e1.colocarSerpiente(e1.getSerpiente(0));
		Assert.assertEquals(true, e1.colisionadorSerpientes(e1.getSerpiente(0)));
	}
	@Test
	void testFrutaSinColisionar() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 0,  Orientacion.E);
		e1.crearFrutaAzar(1);
	}
	@Test
	void testObjeto() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(2, 1, Orientacion.E);
		e1.crearParedes();
		//Assert.assertEquals(true, e1.colisionadorConObstaculos());
	}

	void testObjetoSinColisionar() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1,  Orientacion.E);
		e1.crearParedes();
		//Assert.assertEquals(false, e1.colisionadorConObstaculos());
	}

}
