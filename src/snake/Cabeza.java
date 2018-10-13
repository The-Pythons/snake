package snake;

import java.util.LinkedList;

public class Cabeza extends Cuerpo {
	
	LinkedList <Cuerpo> cuerpo;
	Cuerpo cola;
	public Cabeza(int x, int y,int dirx,int diry) {
		super(x,y,dirx,diry);
		super.tipo="cabeza";
		cuerpo=new LinkedList<Cuerpo>();
		// TODO Auto-generated constructor stub
	}
	
	
	public void comer(){
		Cuerpo un=cuerpo.getLast();
		cuerpo.addLast(new Cuerpo(un.x-un.dirx,un.y-un.diry,un.dirx,super.diry));
	}
	
	
	

}
