package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import frutas.Fruta;
import frutas.frutaDibujable;
import logica.Dibujable;
import logica.Escenario;
import snake.Orientacion;
import snake.Serpiente;
import snake.serpienteDibujable;

public class JPanelGrafico extends JPanel {

	/**
	 * Create the panel.
	 */
	ArrayList<Dibujable> elementos;
	public JPanelGrafico(Escenario escenario) {
			this.elementos = escenario.getElementos() ;
			
	}
	

	/*public void paintComponent(Graphics g) {
		Fruta fru = new Fruta(30,30);
		Serpiente s = new Serpiente(15,20,Orientacion.E);
		frutaDibujable fruta = new frutaDibujable(fru);
		serpienteDibujable serp = new serpienteDibujable(s);
		s.crecer();
		s.crecer();
		s.crecer();
		s.crecer();
		s.crecer();
		s.crecer();
		s.avanzar();
		s.avanzar();
		s.avanzar();
		s.avanzar();
		s.avanzar();
		s.girar(Orientacion.S);
		s.avanzar();
		s.avanzar();
		s.avanzar();
		fruta.dibujar(g);
		serp.dibujar(g);
		
		
	}
	*/
	
/*public void paintComponent(Graphics g) {
		elementos.add(new Fruta(400,400));
		elementos.add(new Fruta(100,100));
		elementos.add(new Obstaculo(100,100));
		Iterator<Dibujable> iterador = elementos.iterator();
		while(iterador.hasNext()){
			iterador.next().getDibujable(g);
			}
	}
	*/
	public void paintComponent(Graphics g) {
		//elementos.add(new frutaDibujable(new Fruta(10,10)));
		g.setColor(Color.black);
		g.fillRect(0, 0, 10, 390);
		g.fillRect(10, 0, 390, 10);
		g.fillRect(390, 10, 10, 400);
		g.fillRect(10, 370, 390, 10);
		Iterator<Dibujable> iterador = elementos.iterator();
		while(iterador.hasNext()){
			Dibujable d = iterador.next();
			if(d!=null && !d.getEstado(g))
				d.dibujar(g);
		}
		
		
	}
}
