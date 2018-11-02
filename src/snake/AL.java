package snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


	public class AL extends KeyAdapter  implements Direcciones{
		int dir ;
		@Override
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			if (keyCode == event.VK_LEFT) {
				dir = O;
			}
			if (keyCode == event.VK_RIGHT) {
				dir = E;
			}
			if (keyCode == event.VK_UP) {
				dir = N;
			}
			if (keyCode == event.VK_DOWN) {
				dir = S;
			}
		}
		public int getDir() {
			return dir;
		}


		@Override
		public void keyReleased(KeyEvent event) {
		}
	}

