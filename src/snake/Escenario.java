package snake;

import java.util.ArrayList;

public class Escenario  {
	
	int id;
	int h,l;
	ArrayList<ObjetoEnElPlano> elementos;
	int [][] plano;
	
	public void  agregarElemento(ObjetoEnElPlano obj){
		elementos.add(obj);
		plano[obj.x][obj.y]=elementos.size();
	}

	public void  moverElemento(int x, int y , int x2,int y2){
		int aux = plano[x][y];
		plano[x][y]=0;
		plano[x][y]=aux;
	}
	public ObjetoEnElPlano getPorPosicion(int x, int y){
		return elementos.get(plano[x][y]-1);
	}
	public void  quitar(int x, int y){
		elementos.remove(plano[x][y]);
		plano[x][y]=0;
	}
	public void  mostrar(){
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < l; j++) {
				System.out.println(""+plano[i][j]);
			}
			System.out.println("\n");
		}
		
	}
	
	
	
	
	
	

}
