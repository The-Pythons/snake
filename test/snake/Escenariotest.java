package snake;

public class Escenariotest {

	public static void main(String[] args) {
		Escenario e=new Escenario(1,4,9);
		ObjetoEnElPlano.setEscenario(e);
		Snake s=new Snake(0,2);
		Fruta f=new Fruta(1,3);
		
		e.mostrar();

	}

}
