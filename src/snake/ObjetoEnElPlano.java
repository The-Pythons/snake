package snake;

public abstract class ObjetoEnElPlano {

	protected int x,y;
	protected String tipo;
	protected  static Escenario escenario;
	public ObjetoEnElPlano(int x, int y, String tipo) {
		super();
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		this.agregar();
	}
	public static void setEscenario(Escenario e){
		escenario=e;
	}
	public  String getTipo(){// indica el tipo de objeto
		return tipo;
	}
	public ObjetoEnElPlano getElemento(int x1,int y1) {
		return escenario.getPorPosicion(x1, y1) ;
		
	}
	public  void agregar(){ //Agrega al escenario 
		escenario.agregarElemento(this);
	}
	public  void mover(int x1,int y1){ //mueve el elemento
		escenario.moverElemento(this, x1, y1);
		this.x=x1;
		this.y=y1;
	}
	public  void quitar(){ //lo quita del escenario 
		escenario.quitar(this);;
	}

	


	

}
