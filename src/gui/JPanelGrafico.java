package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import Audio.PlayerThread;
import logica.Dibujable;
import logica.Escenario;
import logica.ConexionUsuario;
import snake.Serpiente;

public class JPanelGrafico extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4172327830360312248L;

	/**
	 * Create the panel.
	 */
	ArrayList<Dibujable> elementos;
	Image background;

	public JPanelGrafico(Escenario escenario, Image background) {
		//PlayerThread elReproductor = new PlayerThread("./Audios/perdiste.mp3");
		//elReproductor.start();
		this.elementos = escenario.getElementos();
		this.background = background;
	}

	public void paintComponent(Graphics g) {
		try{
		g.drawImage(this.background, 0, 0, 600, 500, null);
		Iterator<Dibujable> iterador = elementos.iterator();
		while (iterador.hasNext()) {
			Dibujable d = iterador.next();
			if (d != null && !d.getEstado(g))
				d.dibujar(g);
			g.setColor(Color.GREEN);
			}
		}
		catch(Exception e){}; //SOLUCIONA TODO XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD.
			//g.drawString("Puntaje:" +ConexionUsuario.puntaje+" "+"Nivel: "+ ConexionUsuario.nivel , 10, 10);
			
//			if(Usuario.gameOver == 0) {
//				g.setColor(Color.BLACK.brighter());
//				g.drawString("GAME OVER",600/2-50, 500/2-50);
//				}
		}
		/*if(ConexionUsuario.gameOver == 1) {
			g.setColor(Color.BLACK.brighter());
			g.drawString("GAME OVER",600/2-50, 500/2-50);
			}*/
		///El mensaje por fuera una vez
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
