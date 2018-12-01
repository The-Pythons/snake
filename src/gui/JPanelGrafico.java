package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	ObjectInputStream entrada;
	ObjectOutputStream salida;
	Image background;
	ArrayList<Dibujable> elementos;

//	public JPanelGrafico(ObjectInputStream cliente, Image background) {
	public JPanelGrafico(ArrayList<Dibujable> elementos, Image background) {
		//PlayerThread elReproductor = new PlayerThread("./Audios/perdiste.mp3");
		//elReproductor.start();
		//this.elementos = escenario.getElementos();
		this.elementos=elementos;
//		this.entrada=cliente;
		this.background = background;
	}

	public JPanelGrafico(ObjectInputStream entrada2, ObjectOutputStream salida, Image image) {
		this.entrada=entrada2;
		this.salida =salida;
		this.background = image;
	}

//	public JPanelGrafico(ObjectInputStream entrada2, ObjectOutputStream salida2, Image image) {
//		// TODO Auto-generated constructor stub
//	}

	public void paintComponent(Graphics g) {

		ArrayList<Dibujable> aux = null;
		try {
			 aux=(ArrayList<Dibujable>) entrada.readObject();
//			 salida.writeObject("ok");
			 
			 System.out.println(aux.size());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try{
		g.drawImage(this.background, 0, 0, 900, 680, null);
		Iterator<Dibujable> iterador = aux.iterator();
//		Iterator<Dibujable> iterador = elementos.iterator();
		while (iterador.hasNext()) {
			Dibujable d = iterador.next();
			if (d != null && !d.getEstado(g))
				d.dibujar(g);
			g.setColor(Color.GREEN);
			}
		}
		catch(Exception e){}; 
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
