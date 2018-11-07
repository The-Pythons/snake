package snake;

public class ComerFrutatest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escenario e=new Escenario(1,4,9);
		ObjetoEnElPlano.setEscenario(e);
		Snake s=new Snake(0,2);
		Fruta f=new Fruta(0,4);
		e.mostrar();
		System.out.println("-------------------");
		s.avanzar();
		e.mostrar();
		System.out.println("-------------------");
		s.avanzar();
		e.mostrar();

	}

}
