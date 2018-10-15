package snake;

public class Frutatest {
	public static void main(String[] args) {
		
		Escenario e=new Escenario(1,4,9);
		ObjetoEnElPlano.setEscenario(e);
		Fruta f=new Fruta(0,4);
		e.mostrar();
	}
}
