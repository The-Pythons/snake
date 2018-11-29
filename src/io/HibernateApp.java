package io;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Query;
//import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import io.Usuario;

/*
 * Link de descarga SQLiteStudio: https://sqlitestudio.pl/index.rvt
 * (Recomendado para una gestion mas comoda de la BD)
 */

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
	 * @param: Partida a agregar (Se genera con el constructor de la misma, con la fecha actual).
	 * @return: 1 en caso de EXITO
	 * 			0 en caso de FALLA TRANSACCION
	 * 		   -1 en caso PARTIDA YA EXISTE
	 */
	public int agregarPartida(Partida p) throws Exception{
		Transaction tx = session.beginTransaction();
		try{
			try{
				session.persist(p);
			}catch (HibernateException a){
				return -1;
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
	 * @param: Usuario a ELIMINAR de la tabla Usuario.
	 * @return: 1 en caso de EXITO
	 * 			0 en caso de FALLA TRANSACCION
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
	
	/*
	 * @param: Usuario a modificar.
	 * @return: True en caso de exito.
	 * 			False en caso de fallo.
	 */
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
	
	/*
	 * @return: Retorna una lista con todas las partidas en caso de exito.
	 * 			Retorna null en caso de fallo.
	 */
	public List<Partida> listarTodasPartidas(){
		Transaction tx = session.beginTransaction();
		try{
			Query q = session.createQuery("Select p from Partida p");
			@SuppressWarnings("unchecked")
			List<Partida>listaDePart = q.getResultList();
			tx.commit();
			return listaDePart;
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} 
	}
	
	/*
	 * @return: Retorna una lista con todos los datos de la tabla usuario en caso de exito.
	 * 			Retorna null en caso de fallo.
	 */
	public List<Usuario> listarTablaUsuario(){
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
	 * @return: Retorna una lista con el historial de las partidas en caso de exito.
	 * 			Retorna null en caso de fallo.
	 */
	public List<HistorialP> listarTablaHistorial(){
		Transaction tx = session.beginTransaction();
		try{
			Query q = session.createQuery("Select h from HistorialP h");
			@SuppressWarnings("unchecked")
			List<HistorialP>listaDeCad = q.getResultList();
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
	 * @param: userID - ID del usuario que participo en la partida.
	 * 		   partidaID - ID de la partida en cuestion.
	 * 		   puntos - Puntos obtenidos por el usuario correspondiente al userID.
	 * @return: -1 en caso de que ya exista la tupla.
	 * 			 0 en caso de fallo transaccion.
	 * 			 1 en caso de exito.
	 */
	public int agregarPartidaHistorial(String userID, int partidaID, double puntos){
		/* Creamos objeto para agregar */
		HistorialP_ID actualID = new HistorialP_ID(userID,partidaID);
		HistorialP actual = new HistorialP(actualID,puntos);
		Transaction tx = session.beginTransaction();
		try{
			try{
				session.persist(actual);
			}catch (HibernateException a){
				return -1;//Ya existe
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
	 * @param: id - ID correspondiente al usuario para el cual se realiza la consulta.
	 * @return: List fin - Lista de las partidas jugadas por el usuario en cuestion.
	 */
	public List<HistorialP> listarHistorialUsuario(String id){
		HibernateApp obj = new HibernateApp();
		List<HistorialP> mid = obj.listarTablaHistorial();
		LinkedList<HistorialP> fin = new LinkedList<HistorialP>();
		for(int i=0; i < mid.size(); i++){
			if(mid.get(i).gethistorialP_ID().getUserID().equals(id))
				fin.add(mid.get(i));
		}
		obj.cierreSessFac();
		return fin;
	}
	
	public void cierreSessFac(){
		this.session.close();
		this.factory.close();
	}
	
}
