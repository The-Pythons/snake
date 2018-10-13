package snake;


public class Snake extends ObjetoEnElPlano {
	
	boolean muerta;
	Cabeza cabeza;
	int dirx ,diry;
	public Snake(int x, int y) {
		super(x, y,"Serpiente");
		this.cabeza=new Cabeza(x,y,0,1);
		cabeza.cuerpo.add(new Cuerpo(x,y-1,0,1));
		cabeza.cuerpo.add(new Cuerpo(x,y-2,0,1));
		// TODO Auto-generated constructor stub
	}
	public void  avanzar() {
		
		getTipo();
	}
	
	

}
