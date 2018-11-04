package snake;

import java.util.ArrayList;

public interface Choques {
	public void chocar(Serpiente s1);
	public boolean getEstado(); //muerto 1 / vivo false
	public ArrayList<Punto2D> eliminar(); // devuelve las pociciones a limpiar 
										// otra forma seria que limpia dentro de la funcion
										//pasando la matriz o escenario 
	
}
