package hibernate;

import java.util.List;

import org.junit.Test;

import io.HibernateApp;
import io.HistorialP;
import io.Usuario;
import io.Seguridad;
import io.Partida;

public class TestHibernate {
	
	//Test listar todos usuarios, funciona.
	@Test
	public void testListarTodosUsuarios() {
		HibernateApp obj = new HibernateApp();
		for(String usuario : obj.listarUsuarios())
			System.out.println(usuario);
		obj.cierreSessFac();
	}
	
	//Test listar todas partidas, funciona.
	@Test
	public void testListarPartidas() {
		HibernateApp obj = new HibernateApp();
		for(Partida p : obj.listarTodasPartidas())
			System.out.println(p);
		obj.cierreSessFac();
	}
	
	//Test agregar usuario, funciona.
	@Test
	public void testAgregarUsuario() throws Exception {
		HibernateApp obj = new HibernateApp();
		
		//Muestro usuarios
		for(String usuario : obj.listarUsuarios())
			System.out.println(usuario);
		
		//Nuevo usuario a agregar
		Usuario user = new Usuario("qwerty","12345",false);
		
		//Agrego
		obj.agregarUsuario(user);
		
		//Muestro nuevamente usuarios
		for(String usuario : obj.listarUsuarios())
			System.out.println(usuario);
		
		obj.cierreSessFac();
	}
	
	//Test agregar partida, funciona.
	@Test
	public void testAgregarPartida() throws Exception {
		HibernateApp obj = new HibernateApp();
		
		//Muestro usuarios
		for(Partida p : obj.listarTodasPartidas())
			System.out.println(p);
		
		//Nuevo usuario a agregar
		Partida part = new Partida();
		
		//Agrego
		obj.agregarPartida(part);
		
		//Muestro nuevamente usuarios
		for(Partida p : obj.listarTodasPartidas())
			System.out.println(p);
		
		obj.cierreSessFac();
	}
	
	//Test eliminar usuario, funciona.
	@Test
	public void testEliminarUsuario() {
			HibernateApp obj = new HibernateApp();
			
			//Muestro usuarios
			for(String usuario : obj.listarUsuarios())
				System.out.println(usuario);
			
			//Nuevo usuario a eliminar
			Usuario user = new Usuario("qwerty","12345",false);
			
			//Elimino
			obj.eliminarUsuario(user);
			
			//Muestro nuevamente usuarios
			for(String usuario : obj.listarUsuarios())
				System.out.println(usuario);
			
			obj.cierreSessFac();		
	}
	
	
	//Test existeUsuario, funciona.
	@Test
	public void testExisteUsuario() throws Exception {
		HibernateApp obj = new HibernateApp();
		//Muestro tabla usuario
		for(Usuario usuario : obj.listarTablaUsuario())
			System.out.println(usuario);
		Usuario user;
		if((user=obj.existeUsuario("adgsg")) != null)
			System.out.println("Datos del usuario: " + user);
		obj.cierreSessFac();
	}
	
	@Test
	public void testNoExisteUsuario() throws Exception {
		HibernateApp obj = new HibernateApp();
		//Muestro tabla usuario
		for(Usuario usuario : obj.listarTablaUsuario())
			System.out.println(usuario);
		Usuario user;
		if((user=obj.existeUsuario("adgsg")) != null)
			System.out.println("Datos del usuario: " + user);
		else
			System.out.println("********* SOY NULL *************");
		obj.cierreSessFac();
	}
	
	//Test update datos usuario, funciona.
	@Test
	public void testUpdateDeUsuario() throws Exception {
		HibernateApp obj = new HibernateApp();
		
		//Muestro tabla usuario
		for(Usuario usuario : obj.listarTablaUsuario())
			System.out.println(usuario);

		//Recupero datos de 1 usuario a updatear
		Usuario user = obj.existeUsuario("fernando");
		
		//Modifico datos
		user.setLogState(true);
		user.setPassword(Seguridad.cifra("1252a"));

		//Update
		obj.updateUsuario(user);
		
		//Muestro nuevamente usuarios
		for(Usuario usuario : obj.listarTablaUsuario())
			System.out.println(usuario);
		obj.cierreSessFac();		
	}
	
	
	//Test listar HistorialP
	@Test
	public void testListarTablaHistorialP() {
		HibernateApp obj = new HibernateApp();
		for(HistorialP h : obj.listarTablaHistorial())
			System.out.println(h);
		obj.cierreSessFac();
	}
	
	//Test listar historial de usuario
	@Test
	public void testHistorialUsuario(){
		HibernateApp obj = new HibernateApp();
		List<HistorialP> l = obj.listarHistorialUsuario("rnsalva");
		if(l.isEmpty())
			System.out.println("ESTOY VACIA");
		for(HistorialP d : l)
			System.out.println(d);
		obj.cierreSessFac();
	}
}
