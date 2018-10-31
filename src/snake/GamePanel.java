package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {

	public static final int AnchoPantalla = 600;
	public static final int AltoPantalla = 600;

	/// Loop para el juego
	private Thread thread;
	private boolean running;
	private long targettime;
	/// Render game
	private BufferedImage image;
	private Graphics2D g2d;
	// Objetos del juego
	EntitySnakeYFruta head, apple;/// La serpiente y la fruta van a ser	/// rectangulares por eso conparte en size
	ArrayList<EntitySnakeYFruta> snake;
	private static final int SIZEDeLosCUERPOS = 10;
	private int score;
	private int level;
	private boolean gameover;;
	/// Movement
	private int dx, dy;
	/// Key input
	private boolean arriba, abajo, derecha, izquierda, start;
	
	/** Creacion de los paneles */
	public GamePanel() {
		
		setPreferredSize(new Dimension(AnchoPantalla, AltoPantalla));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	}

	@Override
	public void addNotify() {
		// TODO Auto-generated method stub
		super.addNotify();
		thread = new Thread(this);
		thread.start();
	}
/**
 * logica del loop*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (running)
			return;
		init();
		long startime;
		long elapsed;
		long wait;
		while (running) {
			startime = System.nanoTime();
			upPosicionYMovimiento();// actualiza movimiento.
			requestRender();
			elapsed = System.nanoTime() - startime;
			wait = targettime - elapsed / 1000000;/// mayor, mayor retardo,pongan 100 se vuelve loco
			if (wait > 0) {
				try {
					Thread.sleep(wait);/// mayor retardo;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void init() {/// Inicializa pantalla y cuerpo
		// TODO Auto-generated method stub
		image = new BufferedImage(AnchoPantalla, AltoPantalla, BufferedImage.TYPE_INT_ARGB);
		g2d = image.createGraphics();
		running = true;
		setIniciaryReiniciarEstados();///inicializa snake y fruta
	}
/**Fin de logica del loop y regrabar el grafico*/
	
/**Operaciones para el grafico
	 * */
	/**
	 * FPS. Los cuadros por segundo es la medida de fotogramas, cuadros o
	 * im�genes distintas que un videojuego muestra en un segundo. ... Los
	 * videojuegos suelen estar en torno a 30-60 frames por segundo, siendo esta
	 * ultima una medida considerada ideal, aunque hay juegos que con el
	 * hardware adecuado pueden superar los 100 FPS.
	 */
	private void setFPS(int fps) {///Puedo modificar el retardo
		targettime = 1000 / fps;
	}
	
	private void requestRender() {
		render(g2d);
		Graphics g = getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
	}

	public void render(Graphics2D g2d2) {
		// TODO Auto-generated method stub
		g2d2.clearRect(0, 0, AnchoPantalla, AltoPantalla);// Limpio la patalla//
															// para cada//
															// movimiento
		g2d2.setColor(Color.GREEN);
		for (EntitySnakeYFruta e : snake) {
			e.render(g2d2);/// habilita la creacion del la serpientr
		}
		g2d2.setColor(Color.RED);
		apple.render(g2d2);/// habilita la creacion del la fruta

		if (gameover)/// esta muerto
			{g2d2.drawString("GAMEOVER", AnchoPantalla/2-50, AltoPantalla/2-50);
			setFPS(2);///LE doy un  seudoretardo retardo para que me muestre el mensaje 
			}
		if (dx == 0 && dy == 0)
			g2d2.drawString("Read", AnchoPantalla/2, AltoPantalla/2);
		g2d2.setColor(Color.WHITE);
		g2d2.drawString("Score " + score + "Level: " + level, 10, 10);

	}
	/*******Movimiento y estados de la serpiente********/
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_UP)
			arriba = true;
		if (k == KeyEvent.VK_DOWN)
			abajo = true;
		if (k == KeyEvent.VK_LEFT)
			izquierda = true;
		if (k == KeyEvent.VK_RIGHT)
			derecha = true;
		// if (k == KeyEvent.VK_ENTER) no lo usamos
		start = true;/// ante cualquier movimento
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_UP)
			arriba = false;
		if (k == KeyEvent.VK_DOWN)
			abajo = false;
		if (k == KeyEvent.VK_LEFT)
			izquierda = false;
		if (k == KeyEvent.VK_RIGHT)
			derecha = false;
		if (k == KeyEvent.VK_ENTER) /// lo usasmos pausa no funciona
			start = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	private void setIniciaryReiniciarEstados() {/// Nivel Del Cuerpo mientras este vivo, Si muero lo vuelvo a iniciar
		snake = new ArrayList<EntitySnakeYFruta>();
		head = new EntitySnakeYFruta(SIZEDeLosCUERPOS);
		head.SetPosition(AnchoPantalla / 2, AltoPantalla / 2);//// Se posiciona al centro de las pantalla
		snake.add(head);
		/*Crecimiento del cuerpo por defecto 3
		 * for (int i = 1; i < 10; i++) { EntitySnakeYFruta e = new
		 * EntitySnakeYFruta(SIZEDELosCUERPOS); 
		 * e.SetPosition(head.getX() + (i * SIZEDELosCUERPOS), head.getY()); snake.add(e); }
		 */
		apple = new EntitySnakeYFruta(SIZEDeLosCUERPOS);
		setFrutaAleatoria();
		score = 0;
		gameover = false;
		level = 1;
		setFPS(level * 10);
		dx=dy=0;///Sin esto no se detiene en el reinicio.
		
	}

	public void setFrutaAleatoria() {
		int x = (int) (Math.random() * (AnchoPantalla - SIZEDeLosCUERPOS));
		int y = (int) (Math.random() * (AltoPantalla - SIZEDeLosCUERPOS));
		y = y - (y % SIZEDeLosCUERPOS);
		x = x - (x % SIZEDeLosCUERPOS);
		apple.SetPosition(x, y);
	}

	public void upPosicionYMovimiento() {
		if (gameover) {/// murio
			
			if (start) {// estabajugando
//				down=up=left=right=false;///deberia esperar a otro movimiento para volver a empesar y mostrar el mensaje de muerto 
				setIniciaryReiniciarEstados();// System.out.println("Esta muerto");
				return;
			}
		}
		//// Posiciones iniciales x=0 y=0
		if (arriba && dy == 0) {
			dy = -SIZEDeLosCUERPOS;
			dx = 0;
		}
		if (abajo && dy == 0) {
			dy = SIZEDeLosCUERPOS;
			dx = 0;
		}
//		if (izquierda && dx == 0 &&!derecha) {tiene mucho retardo
		if (izquierda && dx == 0) {
			dy = 0;
			dx = -SIZEDeLosCUERPOS;
		}

		//if (derecha && dx == 0 && dy != 0) {/// Si voy a derecha no debe volver a izquierda
//		if (derecha && dx == 0&&!izquierda) { tiene mucho retardo									
		if (derecha && dx == 0) {						
			dy = 0;
			dx = SIZEDeLosCUERPOS;
		}
		
		/// movimiento en todo el cuadro 
		if (dx != 0 || dy != 0) {// movimento en cadena
			for (int i = snake.size() - 1; i > 0; i--) {/// movimiento del
														/// cuerpo
				snake.get(i).SetPosition(snake.get(i - 1).getX(), snake.get(i - 1).getY());
			}
			head.move(dx, dy);
		}
		
		// en caso de salir Vuelva a pantalla,ORIGINALMENTE ESTABA COMO ULTIMA OPERARCION
				if (head.getX() < 0)
					head.setX(AnchoPantalla);
				if (head.getY() < 0)
					head.setY(AltoPantalla);
				if (head.getX() > AnchoPantalla)
					head.setX(0);
				if (head.getY() > AltoPantalla)
					head.setY(0);
		//// Colisiona;cuerpo o fruta;
		Colisionador();
	}
	/****Fin***Movimiento y estados de la serpiente********/

	/**colisiones**/
	private void Colisionador() {
		for (EntitySnakeYFruta e : snake) {//// contra su cuerpo
											
			if (e.isCollsion(head)) {
				gameover = true;
				break;
			}
		}

		if (apple.isCollsion(head)) { /// g2d.clearRect(0, 0, Ancho, Alto);///Limpio la patalla
			score++;
			setFrutaAleatoria();
			EntitySnakeYFruta e = new EntitySnakeYFruta(SIZEDeLosCUERPOS);
			e.SetPosition(-100, -100);
			snake.add(e);/// Incrementa loa posiciones Cuerpo
			/// puntajes y niveles
			if (score % 10 == 0) {
				level++;
				if (level > 10)
					level = 10;
				setFPS(level * 10);/// velocidad del movimiento (la velocidad conla que graba la imagen)
			}

		}
	}

}
