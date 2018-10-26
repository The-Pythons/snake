package snake;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Colisionador implements Direcciones {

	@Test
	void testSerpientesDeFrente() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1, E);
		e1.crearSerpiente(1, 1, O);
		Assert.assertEquals(true, e1.colisionadorSerpientes());
	}

	void testSerpientesContraElCuerpo() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1, E);
		e1.crearSerpiente(1, 0, N);
		Assert.assertEquals(true, e1.colisionadorSerpientes());
	}

	void testSerpientesSinColisionar() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1, E);
		e1.crearSerpiente(1, 0, O);
		Assert.assertEquals(false, e1.colisionadorSerpientes());
	}

	void testSerpientesMismaPosicion() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1, E);
		e1.crearSerpiente(1, 1, E);
		Assert.assertEquals(true, e1.colisionadorSerpientes());
	}

	void testFruta() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1, E);
		e1.crearFruta(1);
		Assert.assertEquals(true, e1.colisionadorConComida());
	}

	void testFrutaSinColisionar() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 0, E);
		e1.crearFruta(1);
		Assert.assertEquals(true, e1.colisionadorConComida());
	}

	void testObjeto() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(2, 1, E);
		e1.crearParedes();
		Assert.assertEquals(true, e1.colisionadorConObstaculos());
	}

	void testObjetoSinColisionar() {
		Escenario e1 = new Escenario(3, 3);
		e1.crearSerpiente(1, 1, E);
		e1.crearParedes();
		Assert.assertEquals(false, e1.colisionadorConObstaculos());
	}

}
