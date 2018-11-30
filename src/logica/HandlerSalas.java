package logica;

import java.util.ArrayList;

public class HandlerSalas {
	
	ArrayList<Sala> salas;
	
	public void  crearSala(Sala sala){
		salas.add(sala);
		sala.start();
		
	}
	/*public void  crearSala(String  nombre,String password){
		Sala s = new Sala(nombre,password);
		salas.add(s);
		s.start();
		
	}*/
	public void  eliminarSala(){
		//Sala s = new Sala(nombre);
		//salas.add(s);
		//s.start();
		
	}

}
