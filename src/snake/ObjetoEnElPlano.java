package snake;

public abstract class ObjetoEnElPlano {

	protected int x,y;
	protected String tipo;
	protected   Escenario escenario;
	public ObjetoEnElPlano(int x, int y, String tipo, Escenario escenario) {
		super();
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		this.escenario=escenario;
	}
	public  String getTipo(){// indica el tipo de objeto
		return tipo;
	}
	public  void agregar(){ //Agrega al escenario 
		escenario.agregarElemento(this);
	}
	public  void mover(int x1,int y1){ //mueve el elemento 
		escenario.moverElemento(this, x1, y1);;
	}
	public  void quitar(){ //lo quita del escenario 
		escenario.quitar(this);;
	}

	


	

}
