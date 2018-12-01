package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import mensajes.MsjEstoylisto;
import mensajes.MsjLogin;
import mensajes.MsjSala;
import mensajes.MsjSalida;
import io.HibernateApp;
import io.Usuario;
import logica.ConexionUsuario;
import logica.Sala;

public class ThreadUsuario extends Thread {

	private Servidor servidorPrincipal;
	private Socket socket;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private HibernateApp baseDeDatos;
	private Usuario user;
	private ConexionUsuario usuarioEnJuego;
	private Sala sala;

	public ThreadUsuario(Socket socket, Servidor servidorPrincipal) {
		this.servidorPrincipal = servidorPrincipal;
		this.baseDeDatos = servidorPrincipal.getBaseDeDatos();
		this.socket = socket;
		this.usuarioEnJuego = new ConexionUsuario();
		try {
			this.entrada = new ObjectInputStream(socket.getInputStream());
			this.salida = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run() {
	
		ingresarUsuario();
		conectarConSala();
		estoyListo();
		jugar();

	}
	
	private void ingresarUsuario() {
		MsjLogin mensaje;
		boolean logeado = false;
		try {
			do {
				mensaje = (MsjLogin) entrada.readObject();
				if (mensaje.isRegistrar()) {
					try {
						int resp = this.baseDeDatos
								.agregarUsuario(new Usuario(mensaje.getLogin(), mensaje.getPassword(), false));
						if (resp == 1)
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
						user = null;
					}

					else {
						// *if (user.getLogState())
						// salida.writeObject((new MsjSalida(false, "El usuario ya se encuentra
						// logueado")));
						// else {

						salida.writeObject((new MsjSalida(true, "Bienvenido")));
						// user.setLogState(true);
						logeado = true;
					}
				}
			}

			while (user == null || !logeado && !mensaje.isRegistrar());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void estoyListo() {
		MsjEstoylisto mensaje=null;
		try {
			mensaje = (MsjEstoylisto) entrada.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mensaje.getEstoyListo()) {
			this.usuarioEnJuego.estoyListo();
		}

	}

	private void jugar() {

		while (!this.sala.estanTodosListos()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		try {
			salida.writeObject(new MsjSalida(true,"estan todos listos"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sala.jugar();

		RecibirMovimientos recv = new RecibirMovimientos(usuarioEnJuego, entrada);
		recv.start();
		EnviarObjetos obj = new EnviarObjetos(salida, sala.getEscenario().getElementos());
		obj.start();

	}

	private void conectarConSala() {
		MsjSala mensaje;
		boolean usuarioConectado = false;
		try {
			do {
				mensaje = (MsjSala) entrada.readObject();
				if (mensaje.isCrear()) {
					this.servidorPrincipal.crearSala(mensaje.getNombreSala(), mensaje.getPasswordSala());
					salida.writeObject(new MsjSalida(true, "Sala creada"));
				}

				if (mensaje.isLoguerase()) {
					sala = this.servidorPrincipal.getSala(mensaje.getNombreSala(), mensaje.getPasswordSala());
					if (sala == null)
						salida.writeObject(new MsjSalida(false, "Sala o clave incorrecta"));
					else {
						salida.writeObject(new MsjSalida(true, "Te conectaste a una sala, felicitaciones"));
						usuarioConectado = true;
						sala.nuevaSession(usuarioEnJuego);
						return;
					}
				}

				if (mensaje.isEliminar()) {
					this.servidorPrincipal.eliminarSala(mensaje.getNombreSala());

				}

			} while (!usuarioConectado);
		} catch (

		ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
