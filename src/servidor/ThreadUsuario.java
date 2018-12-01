package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import mensajes.MsjLogin;
import mensajes.MsjSalida;
import io.HibernateApp;
import io.Usuario;
import com.google.gson.*;

public class ThreadUsuario  extends Thread{

	private Servidor servidorPrincipal;
	private Socket socket;
//	private ObjectInputStream entrada;
//	private ObjectOutputStream salida;
	private BufferedReader entrada;
	private PrintWriter salida;
	private HibernateApp baseDeDatos;

	public ThreadUsuario(Socket socket, Servidor servidorPrincipal) {
		this.servidorPrincipal = servidorPrincipal;
		this.baseDeDatos = servidorPrincipal.getBaseDeDatos();
		this.socket = socket;
		try {
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new PrintWriter(socket.getOutputStream());
//			this.entrada = new ObjectInputStream(socket.getInputStream());
//			this.salida = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void run() {
		Usuario user = null;
		System.out.println("Llegaste al server");
		try {
			do {
				System.out.println("Antes de leer");
				Gson gson = new Gson();
				String json  = entrada.readLine();		
				System.out.println(json);
				MsjLogin mensaje = gson.fromJson(json,MsjLogin.class);
				try {
					user = baseDeDatos.existeUsuario(mensaje.getLogin());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (user == null) {
					MsjSalida respuesta = new MsjSalida(false, "El usuario y/o contraseña es/son incorrecta/s");
					String jsonRespuesta = gson.toJson(respuesta);
					salida.println(jsonRespuesta);
//					salida.writeObject((new MsjSalida(false, "El usuario y/o contraseña es/son incorrecta/s")));
				} else {
					if (!user.getPassword().equals(mensaje.getPassword())){
						MsjSalida respuesta = new MsjSalida(false, "El usuario y/o contraseña es/son incorrecta/s");
						String jsonRespuesta = gson.toJson(respuesta);
						salida.println(jsonRespuesta);
//						salida.writeObject((new MsjSalida(false, "El usuario y/o contraseña es/son incorrecta/s")));
					}
					else {
						if (user.getLogState()){
							MsjSalida respuesta = new MsjSalida(false, "El usuario ya se encuentra logueado");
							String jsonRespuesta = gson.toJson(respuesta);
							salida.println(jsonRespuesta);
//							salida.writeObject((new MsjSalida(false, "El usuario ya se encuentra logueado")));
						}
							
						else {
							user.setLogState(true);
							baseDeDatos.updateUsuario(user);
							MsjSalida respuesta = new MsjSalida(true, "Bienvenido");
							String jsonRespuesta = gson.toJson(respuesta);
							salida.println(jsonRespuesta);
//							salida.writeObject((new MsjSalida(true, "Bienvenido")));
						}
					}
				}
			} while (user == null || !user.getLogState());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
