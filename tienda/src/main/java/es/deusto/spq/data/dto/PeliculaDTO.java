package es.deusto.spq.data.dto;

import java.io.Serializable;

public class PeliculaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	
	


	
	
	
	
	

}
