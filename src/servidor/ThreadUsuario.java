package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import mensajes.MsjLogin;
import mensajes.MsjSalida;
import io.HibernateApp;
import io.Usuario;

public class ThreadUsuario  extends Thread{

	private Servidor servidorPrincipal;
	private Socket socket;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private HibernateApp baseDeDatos;

	public ThreadUsuario(Socket socket, Servidor servidorPrincipal) {
		this.servidorPrincipal = servidorPrincipal;
		this.baseDeDatos = servidorPrincipal.getBaseDeDatos();
		this.socket = socket;
		try {
			this.entrada = new ObjectInputStream(socket.getInputStream());
			this.salida = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void run() {
		Usuario user = null;
		MsjLogin mensaje;
		try {
			do {
				mensaje = (MsjLogin) entrada.readObject();
				if(mensaje.isRegistrar()){
					try {
						int resp=this.baseDeDatos.agregarUsuario(new Usuario(mensaje.getLogin(),mensaje.getPassword(),false));
						if(resp==1)
							salida.writeObject((new MsjSalida(true, "Estas registrado con existo!!")));
						else
							salida.writeObject((new MsjSalida(false, "Error, usuario ya existe")));
						socket.close();
						return;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					user = baseDeDatos.existeUsuario(mensaje.getLogin());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (user == null) {
					salida.writeObject((new MsjSalida(false, "El usuario y/o contraseña es/son incorrecta/s")));
				} else {
					if (!user.getPassword().equals(mensaje.getPassword())) {
						salida.writeObject((new MsjSalida(false, "El usuario y/o contraseña es/son incorrecta/s")));
						user=null;
						}
					
					else {
						if (user.getLogState()) 
							salida.writeObject((new MsjSalida(false, "El usuario ya se encuentra logueado")));
						else {
							salida.writeObject((new MsjSalida(true, "Bienvenido")));
						}
					}
				}
			} while (user ==null || !user.getLogState() && !mensaje.isRegistrar());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
