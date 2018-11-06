package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
	Image background;
	public JPanelGrafico(Escenario escenario, Image background) {
			this.elementos = escenario.getElementos() ;
			this.background = background;
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
		//for (int i = 0; i < 60; i+=10) {
			//for (int j = 0; j < 50; j+=10) {
		g.drawImage(this.background, 0, 0, 600, 500, null);
			//}
		//}
		Iterator<Dibujable> iterador = elementos.iterator();
		while(iterador.hasNext()){
			Dibujable d = iterador.next();
			if(d!=null && !d.getEstado(g))
				d.dibujar(g);
		}
		
		
	}
}
