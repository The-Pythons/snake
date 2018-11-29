package io;

public class HistorialP {

	private HistorialP_ID historialP_ID;
	private double puntaje;
	
	public HistorialP() {
		this.historialP_ID = new HistorialP_ID();
		this.puntaje = (double) 0;
	}
	
	public HistorialP(HistorialP_ID id, double puntaje) {
		this.historialP_ID = id;
		this.puntaje = puntaje;
	}

	public HistorialP_ID gethistorialP_ID() {
		return historialP_ID;
	}

	public void sethistorialP_ID(HistorialP_ID id) {
		this.historialP_ID = id;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Double puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		return historialP_ID.getUserID()+ "|" + historialP_ID.getPartidaID() + "|"  + puntaje;
	}
	
	
}
