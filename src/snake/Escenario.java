package snake;

import java.util.ArrayList;

public class Escenario {
	
	int id;
	int h,l;
	ArrayList<ObjetoEnElPlano> elementos;
	int [][] plano;
	
	public void  agregarElemento(ObjetoEnElPlano obj){
		elementos.add(obj);
		plano[obj.x][obj.y]=elementos.size()-1;
	}
	

	public void  moverElemento(int x, int y , int x2,int y2){
		
	}
	public void  quitar(int x, int y){
		
		
	}
	
	
	
	
	
	

}
