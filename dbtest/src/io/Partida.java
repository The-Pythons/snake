package io;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Partida {

	private int id;
	private String fecha;
	
	public Partida() {
		Calendar c = new GregorianCalendar();
		this.fecha = new Fecha(c.get(Calendar.DATE), c.get(Calendar.MONTH) + 1,c.get(Calendar.YEAR)).toString();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return  id + "|" + fecha;
	}
	
}
