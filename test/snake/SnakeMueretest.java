package snake;

public class SnakeMueretest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		Escenario e=new Escenario(1,4,9);
		ObjetoEnElPlano.setEscenario(e);
		Snake s=new Snake(0,2);
		e.mostrar();
		s.morir();
		System.out.println("-------------------");
		e.mostrar();
	}

}
