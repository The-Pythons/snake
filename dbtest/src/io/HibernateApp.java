package io;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import io.Usuario;

public class HibernateApp {
	
	public Configuration cfg;
	public SessionFactory factory;
	public Session session;
	
	public HibernateApp() {
		this.cfg = new Configuration();
		this.cfg.configure("hibernate.cfg.xml");
		this.factory = cfg.buildSessionFactory();
		this.session = factory.openSession();
	}

	/*
	 * @return: Lista que contiene todos los Usuarios de la tabla Usuario
	 * 			null en caso FALLA TRANSACCION
	 */
	public List<String> listarUsuarios(){
			Transaction tx = session.beginTransaction();
			try{
				Query q = session.createQuery("Select u.user from Usuario u");
				@SuppressWarnings("unchecked")
				List<String>listaDeCad = q.getResultList();
				tx.commit();
				return listaDeCad;
			}
			catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
				return null;
			} 
		}
	
	private List<Usuario> listarTablaUsuario(){//Metodo para listar toda la tabla Usuario, por ahora private.
		Transaction tx = session.beginTransaction();
		try{
			Query q = session.createQuery("Select u from Usuario u");
			@SuppressWarnings("unchecked")
			List<Usuario>listaDeCad = q.getResultList();
			tx.commit();
			return listaDeCad;
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} 
	}
	/* 
	 * @param: Usuario a INSERTAR a la tabla Usuario.
	 * @return: 1 en caso de EXITO
	 * 			0 en caso de FALLA TRANSACCION
	 * 		   -1 en caso USUARIO YA EXISTE
	 */
	public int agregarUsuario(Usuario user) throws Exception{
		/* Encriptamos pw por seguridad */
		//String cad = user.getPassword();
		user.setPassword(Seguridad.cifra(user.getPassword()));
		Transaction tx = session.beginTransaction();
		try{
			try{
				session.persist(user);
			}catch (HibernateException a){
				return -1;//Usuario ya existe
			}
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return 0;//Fallo Transaccion
		} 
			return 1;//Exito
	}
	
	/* 
	 * @param: Usuario a INSERTAR a la tabla Usuario.
	 * @return: 1 en caso de EXITO
	 * 			0 en caso de FALLA TRANSACCION
	 * 		   ¿-1 en caso USUARIO NO EXISTE? //ver si hace falta
	 */
	public int eliminarUsuario(Usuario user){
		Transaction tx = session.beginTransaction();
		try{
			session.delete(user);
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return 0;//Fallo Transaccion
		} 
			return 1;//Exito
	}
	
	/*
	 * @param: id del usuario.
	 * @return: Objeto usuario en caso de exito.
	 * 			Null en caso de fallo.
	 */
	public Usuario existeUsuario(String usuarioID) throws Exception{
		Transaction tx = session.beginTransaction();
		Usuario us;
		try{
			us = session.get(Usuario.class, usuarioID);
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;//Fallo Transaccion
		} 
			/* Desciframos password */
		if(us != null)
			us.setPassword(Seguridad.descifra(us.getPassword()));
		return us;//Si no existe en la BD, us es null.
	}
	
	public boolean updateUsuario(Usuario user){
		Transaction tx = session.beginTransaction();
		try{
			session.merge(user);
			tx.commit();
			return true;
		}catch(HibernateException e){
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;//Caso Fallo
		}
	}
	
	private void cierreSessFac(){
		this.session.close();
		this.factory.close();
	}
	
	/*//Test listar todos usuarios, funciona.
	public static void main(String[] args) {
		HibernateApp obj = new HibernateApp();
		for(String usuario : obj.listarUsuarios())
			System.out.println(usuario);
		obj.cierreSessFac();
	}*/
	
	/*//Test agregar usuario, funciona.
	public static void main(String[] args) throws Exception {
		HibernateApp obj = new HibernateApp();
		
		//Muestro usuarios
		for(String usuario : obj.listarUsuarios())
			System.out.println(usuario);
		
		//Nuevo usuario a agregar
		Usuario user = new Usuario("aaaa","12345",0);
		
		//Agrego
		obj.agregarUsuario(user);
		
		//Muestro nuevamente usuarios
		for(String usuario : obj.listarUsuarios())
			System.out.println(usuario);
		
		obj.cierreSessFac();
	}*/
	
	/*//Test eliminar usuario, funciona.
	public static void main(String[] args) {
			HibernateApp obj = new HibernateApp();
			
			//Muestro usuarios
			for(String usuario : obj.listarUsuarios())
				System.out.println(usuario);
			
			//Nuevo usuario a eliminar
			Usuario user = new Usuario("aaaa","12345",0);
			
			//Elimino
			obj.eliminarUsuario(user);
			
			//Muestro nuevamente usuarios
			for(String usuario : obj.listarUsuarios())
				System.out.println(usuario);
			
			obj.cierreSessFac();		
	}*/
	
	/*//Test existeUsuario, funciona.
	public static void main(String[] args) throws Exception {
		HibernateApp obj = new HibernateApp();
		//Muestro tabla usuario
		for(Usuario usuario : obj.listarTablaUsuario())
			System.out.println(usuario);
		Usuario user;
		if((user=obj.existeUsuario("adgsg")) != null)
			System.out.println("Datos del usuario: " + user);
		
		obj.cierreSessFac();
	}*/
	
	//Test update datos usuario.
	public static void main(String[] args) throws Exception {
		HibernateApp obj = new HibernateApp();
		
		//Muestro tabla usuario
		for(Usuario usuario : obj.listarTablaUsuario())
			System.out.println(usuario);
		System.out.println("DDDDDDDDDDDDDDDDDDDDD");
		//Recupero datos de 1 usuario a updatear
		Usuario user = obj.existeUsuario("fernando");
		
		//Modifico datos
		user.setEstado(1);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");
		user.setPassword(Seguridad.cifra("1252a"));
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWW");
		//Update
		obj.updateUsuario(user);
		
		//Muestro nuevamente usuarios
		for(Usuario usuario : obj.listarTablaUsuario())
			System.out.println(usuario);
		obj.cierreSessFac();		
	}
}
