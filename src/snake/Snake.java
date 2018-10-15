package snake;


public class Snake extends ObjetoEnElPlano {
	
	boolean muerta;
	Cabeza cabeza;
	int dirx ,diry;
	public Snake(int x, int y) {
		super(x, y,"Serpiente");
		this.dirx=0;
		this.diry=1;
		this.cabeza=new Cabeza(x,y,0,1);
		this.muerta=false;
		cabeza.cuerpo.add(new Cuerpo(x,y-1,0,1));
		cabeza.cuerpo.add(new Cuerpo(x,y-2,0,1));
		// TODO Auto-generated constructor stub
	}
	
	public boolean chocar(){
		ObjetoEnElPlano aux = Snake.escenario.getPorPosicion(cabeza.x,cabeza.y);
		if(aux==null)
			return false;
		if(aux.getTipo().equals("fruta")){
			cabeza.comer();
			return false;
		}
		if(aux.getTipo().equals("obstaculo")){
			this.morir();
			return true;
		};
		return false;
	}
	
	public void  avanzar() {
		int x1=cabeza.x,y1=cabeza.y;
		Cuerpo aux=cabeza.cuerpo.removeLast();
		cabeza.mover(x1+dirx, y1+diry);
		aux.mover(x1,y1);
		//cabeza.cuerpo.addFirst(new Cuerpo(cabeza.x-dirx,cabeza.y-diry,cabeza.dirx,cabeza.dirx) );
	}
	
	public void morir(){
		while(!cabeza.cuerpo.isEmpty()){
			cabeza.cuerpo.remove().quitar();
		}
		cabeza.quitar();
		muerta=true;
	}
}
