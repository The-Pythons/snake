package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class JPanelGrafico extends JPanel {

	/**
	 * Create the panel.
	 */
	ArrayList<Dibujable> elementos;
	public JPanelGrafico(ArrayList<Dibujable> elementos) {
			this.elementos = elementos;
			elementos.add(new Fruta(400,400));
	}
	
	public void paintComponent(Graphics g) {
		Iterator<Dibujable> iterador = elementos.iterator();
		while(iterador.hasNext()){
			iterador.next().getDibujable(g);
			}
	}
	
	/*public void paint(Graphics g) {
		/*Iterator<Dibujable> iterador = elementos.iterator();
		while(iterador.hasNext()){
			iterador.next().getDibujable(g);;
	
		}*/
		
	
}
