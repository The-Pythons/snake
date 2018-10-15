package snake;

public class ChocaObstaculotest {

	public static void main(String[] args) {
		
		Escenario e=new Escenario(1,4,9);
		ObjetoEnElPlano.setEscenario(e);
		Snake s=new Snake(0,2);
		Obstaculo f=new Obstaculo(0,4);
		e.mostrar();
		System.out.println("-------------------");
		s.avanzar();
		s.avanzar();
		e.mostrar();
	}

}
