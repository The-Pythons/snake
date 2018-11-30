package logica;

import snake.Orientacion;

public class Bot implements Controlable {

	int puntaje;
	int nivel;
	int c, d;
	Orientacion dir;

	@Override
	public Orientacion getDir() {
		if (c == 3) {
			c=0;
			switch (d) {
			case 0:
				dir=Orientacion.O;
				break;
			case 1:
				dir=Orientacion.N;
				break;
			case 2:
				dir=Orientacion.E;
				break;
			case 3:
				dir=Orientacion.S;
				break;
			}
			}
			d++;
			if (d == 4)
				d = 0;
			c++;
			
		return dir;
	}

	@Override
	public void muere() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPuntaje(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNivel(int i) {
		// TODO Auto-generated method stub

	}

}
