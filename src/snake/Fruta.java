package snake;

public class Fruta {
	Punto2D pos;
	String tipo = "F";
	
	public Fruta(int x, int y){
		this.pos = new Punto2D(x,y);
		
	}
	
	@Override
	public String toString() {
		return tipo;
	}
	

}
