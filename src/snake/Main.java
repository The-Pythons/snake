package snake;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**Creacion y dimension de los paneles
 * */
JFrame frame=new JFrame("Snake");
frame.setContentPane(new GamePanel());

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);

frame.pack();///juegofalta agregar lidta de objetos la matriz

frame.setPreferredSize(new Dimension(GamePanel.AnchoPantalla,GamePanel.AltoPantalla));
frame.setLocationRelativeTo(null);
frame.setVisible(true);
/**debo agregar lista de objetos*/
}

}
