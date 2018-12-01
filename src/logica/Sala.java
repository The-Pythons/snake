package logica;

import java.util.ArrayList;

public class Sala extends Thread{
	
	private ArrayList<Session>sessiones;
	private String nombre;
	private String pass;
	private Escenario escenario;
	boolean eliminar;
	int cant_frutasmaxima;
	//private int cant_frutasmaxima;
	
	public Sala(String nombre,int cant_fruta) {
		super();
		this.cant_frutasmaxima=cant_fruta;
		
		this.sessiones = new ArrayList<Session>();
		this.escenario = new Escenario(50, 38);
		//escenario.setFrutamaxima(cant_fruta);
		this.escenario.crearParedes();
		this.escenario.crearFrutaAzar(cant_fruta);
	//	this.escenario.crearPowerUpAzar(4, "achicar");
		SessionBot s= new SessionBot(this.escenario,null);
		s.start();
	}
	
	public void run() {
		while(!eliminar){
			escenario.crearFrutaAzar(escenario.frutaactual);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void nuevaSession(ConexionUsuario usuario) {
			Session s = new Session(escenario,usuario);
			sessiones.add(s);
//			s.start();
	}
	public Escenario getEscenario() {
		return escenario;
	}
	public Sala(String nombre,String contraseņa) {
		super();
		this.sessiones = new ArrayList<Session>();
		this.escenario = new Escenario(30, 24);
		this.escenario.crearParedes();
		SessionBot s= new SessionBot(this.escenario,null);
		this.nombre = nombre;
		this.pass = contraseņa;
		s.start();
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getPass() {
		return nombre;
	}
	
	
	
	
	
	

}
