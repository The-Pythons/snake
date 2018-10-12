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
	public  String getTipo(){
		return tipo;
	}
	public  void agregar(){
		escenario.agregarElemento(this);
	}
	public  void mover(){
		escenario.moverElemento(this, x, y);;
	}
	public  void quitar(){
		escenario.quitar(this);;
	}

	


	

}
