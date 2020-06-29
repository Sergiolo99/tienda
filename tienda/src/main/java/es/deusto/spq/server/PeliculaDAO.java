package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.Pelicula;
import es.deusto.spq.data.Usuario;

public class PeliculaDAO {
	
	private PersistenceManagerFactory pmf;
	private PersistenceManager pm;
	
	protected PeliculaDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        pm = pmf.getPersistenceManager();
	}
	
	public PeliculaDAO(String p) {
		
	}
	
	public boolean guardar(Object o) {
		boolean b = true;
    	Transaction tx = pm.currentTransaction();
    	try {
			tx.begin();
			System.out.println("  * Guardando un objeto: " + o);
			pm.makePersistent(o);
			tx.commit();
		} catch (Exception e) {
			System.out.println("  $ Error guardando un objeto: " + e.getMessage());
			b = false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return b;
    }
	
	
	public List<Pelicula> getPeliculas() {
    	List<Pelicula> peliculas = new ArrayList<Pelicula>();
    	Transaction tx = pm.currentTransaction();
    	try {
			System.out.println(" * Retrieving an extent for Piso.");
			tx.begin();
			Extent<Pelicula> extent = pm.getExtent(Pelicula.class, true);
			for (Pelicula pelicula : extent) {
				peliculas.add(pelicula);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(" $ Error retrieving Piso: " + e.getMessage());
		} finally {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
    	return peliculas;
    }
	
	
	 public Pelicula getPelicula(String nombre) {
		 	Pelicula pelicula = null;
	    	Transaction tx = pm.currentTransaction();
	    	try {
				tx.begin();
				Extent<Pelicula> extent = pm.getExtent(Pelicula.class, true);
				for (Pelicula p : extent) {
					if (p.getNombre().equals(nombre)){
						pelicula = p;
						break;
					}
				}
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (tx != null && tx.isActive()) {
		    		tx.rollback();
		    	}
			}
			return pelicula;
		}
	
	
	
	
	
	
	
	
	

}
