package logica;

import snake.Orientacion;

public interface Controlable {

	Orientacion getDir();



	void muere();



	void setPuntaje(int i);



	void setNivel(int i);

}
