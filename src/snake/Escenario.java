package snake;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Escenario {
	ArrayList<Serpiente> serpientes;
	Object [][] area;
	int dim_x,dim_y;
	
	public Escenario(int dim_x, int dim_y) {
		this.dim_x = dim_x;
		this.dim_y = dim_y;
		area = new Object [dim_x][dim_y];
		serpientes = new ArrayList<Serpiente>();
	}
	
	void crear_serpiente(int x, int y, int orientacion) {
		
		serpientes.add(new Serpiente(x, y, orientacion));
		
	}
	void crear_paredes() {//rodea todos los bordes del escenario con obstaculos
		for(int i=0;i<dim_x;i++)//piso
			area[i][0]=new Obstaculo(i, 0);
		for(int i=1;i<dim_y;i++)//pared izq
			area[0][i]=new Obstaculo(0, i);
		for(int i=1;i<dim_y;i++)//pared der
			area[dim_x-1][i]=new Obstaculo(dim_x-1, i);
		for(int i=1;i<dim_x;i++)//techo
			area[i][dim_y-1]=new Obstaculo(i, dim_y-1);
	}
	
	void crear_fruta(int cantidad) {
		int x,y,i;
		for(i=0;i<cantidad;i++)
		{
				do{
				//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html
				x=ThreadLocalRandom.current().nextInt(0,dim_x);
				y=ThreadLocalRandom.current().nextInt(0,dim_y);
				}
				while(area[x][y]!=null);//genero enteros al azar para x e y hasta que encuentro una ubicacion vacia
					area[x][y]= new Fruta(x,y);//creo una fruta en ese lugar
			
		}
	}
	void desplazar_serpientes() {
		
	}
	
}
