package snake;

public class SnakeAvanzatest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escenario e=new Escenario(1,4,9);
		ObjetoEnElPlano.setEscenario(e);
		Snake s=new Snake(0,2);
		e.mostrar();
		System.out.println("-------------------");
		s.avanzar();
		s.avanzar();
		System.out.println("--------Deberia estar en el branch Probando algo-----------");
		e.mostrar();
	}
/***https://www.youtube.com/watch?v=pGTjdeX_Y48*
	*****https://www.youtube.com/watch?v=rQNixJQQ25g
	******///
}
