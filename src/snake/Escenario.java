package snake;

import java.util.ArrayList;

public class Escenario  {
	
	int id;
	int h,l;
	//ArrayList<ObjetoEnElPlano> elementos;
	ObjetoEnElPlano [][] plano;
	
	
	public Escenario(int id, int h, int l) {
		super();
		this.id = id;
		this.h = h;
		this.l = l;
		plano =new ObjetoEnElPlano[h][l];
		//elementos=new ArrayList<ObjetoEnElPlano>();
		iniciarPlano();
	}

	public void  agregarElemento(ObjetoEnElPlano obj){
		//elementos.add(obj);
		//plano[obj.x][obj.y]=elementos.size();
		plano[obj.x][obj.y]=obj;
		
	}

	public void  moverElemento(ObjetoEnElPlano obj, int x,int y){
		//int aux = plano[obj.x][obj.y];
		plano[obj.x][obj.y]=null;
		plano[x][y]=obj;
	}
	public ObjetoEnElPlano getPorPosicion(int x, int y){
		//if(plano[x][y]==0)
			//return null;
		//return elementos.get(plano[x][y]-1);
		return plano[x][y];
	}
	public void  quitar(ObjetoEnElPlano obj){
		//elementos.remove(plano[obj.x][obj.y]-1);
		plano[obj.x][obj.y]=null;
	}
	private  void iniciarPlano(){
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < l; j++) {
				plano[i][j]=null;
			}
		}
		
	}
	
	public void  mostrar(){
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < l; j++) {
				if(plano[i][j]!=null)
					System.out.print(plano[i][j].tipo);
				else 
					System.out.print("0");
			}
			System.out.println("\n");
		}
	}
	
	/*public void  mostrar(){
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < l; j++) {
				if(plano[i][j]!=0)
					System.out.print(elementos.get(plano[i][j]-1).tipo.charAt(1));
				else 
					System.out.print("0");
			}
			System.out.println("\n");
		}
		
	}*/
	
	

	
	
	
	
	
	

}
