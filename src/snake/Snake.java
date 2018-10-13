package snake;


public class Snake extends ObjetoEnElPlano {
	
	boolean muerta;
	Cabeza cabeza;
	int dirx ,diry;
	public Snake(int x, int y) {
		super(x, y,"Serpiente");
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
		Cuerpo aux=cabeza.cuerpo.removeLast();
		aux.quitar();
		cabeza.mover(x+dirx, y+diry);
		cabeza.cuerpo.addFirst(new Cuerpo(cabeza.x-dirx,cabeza.y-diry,cabeza.dirx,cabeza.dirx) );
	}
	
	public void morir(){
		while(!cabeza.cuerpo.isEmpty()){
			cabeza.cuerpo.remove().quitar();
		}
		cabeza.quitar();
		muerta=true;
	}
	
	

}
