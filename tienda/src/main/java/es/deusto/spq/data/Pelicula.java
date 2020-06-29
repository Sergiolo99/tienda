package es.deusto.spq.data;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Pelicula {
	
	@PrimaryKey
	private String nombre;
	
	private String tipo;
	private String director;
	private String actor;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	public Pelicula() {
		
	}
	public Pelicula(String nombre, String tipo, String director, String actor) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.director = director;
		this.actor = actor;
	}
	
	
	
	
	
	
	

}
