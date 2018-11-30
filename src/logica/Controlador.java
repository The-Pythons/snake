package logica;

import snake.Serpiente;

public class Controlador extends Thread {
	
		Escenario escenario;
		Controlable controlable;
		Serpiente serpiente;

		public Controlador(Escenario escenario,Serpiente serpiente, Controlable controlable) {
			super();
			this.escenario = escenario;
			this.controlable =  controlable;
			this.serpiente=serpiente;
		}

		public void run() {
			//usuario.setDir(Orientacion.N);
			while(true) {
			serpiente();
			escenario.limpiarSerpiente(serpiente);
			serpiente.getCabeza().setPosicion(15, 15);
			controlable.muere();
			if(serpiente.getEstado()){
				try {
					Thread.sleep(2005);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			controlable.muere();
			serpiente.revivir();
			controlable.setPuntaje(0);
			controlable.setNivel(1);
			
		}}

		private void serpiente() {
			long ti, tf;

			while (!this.serpiente.getEstado()) {
				ti = System.currentTimeMillis();
				serpiente.girar(controlable.getDir());
				escenario.colicionador(this.serpiente);
				escenario.limpiarSerpiente(this.serpiente);
				if (!serpiente.getEstado()) {
					serpiente.avanzar();
					escenario.colocarSerpiente(this.serpiente);		
				}
				
				tf = System.currentTimeMillis();
				try {
					Thread.sleep(serpiente.getVelocidad() - (tf - ti));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}


