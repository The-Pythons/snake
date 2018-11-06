package logica;

import java.util.ArrayList;

import snake.Serpiente;

public interface Choques {
	public void chocar(Serpiente s1);
	public boolean getEstado(); //muerto 1 / vivo false
	public ArrayList<Punto2D> eliminar(); // devuelve las pociciones a limpiar 
										// otra forma seria que limpia dentro de la funcion
										// vaciarPosiciones(ArrayList<Punto2D> e)
										//pasando la matriz o escenario 
	public void eliminar(Escenario escenario);
	
}
