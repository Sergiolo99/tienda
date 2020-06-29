package es.deusto.spq.data;

import java.util.ArrayList;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {

	@PrimaryKey
	private String nickname;  		
	
	private String nombre;	
	private String apellidos;		
	
	@PrimaryKey
	private String email;
	
	private String pw1;				
	
	
	public Usuario(String nickname, String nombre, String apellidos, String email, String pw1) {
		this.setNickname(nickname);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setEmail(email);
		this.setPw1(pw1);
	}

	public Usuario(String nickname,String pw1) {
		this.setNickname(nickname);
		this.setPw1(pw1);
		this.nombre = "";
		this.apellidos = "";
		this.email = "";
	}
	
	public Usuario(String nombre) {
		this.setNombre(nombre);
	}

	public Usuario(Usuario u){
		

	}

	public Usuario() {
		nickname = "";
		nombre = "";
		apellidos = "";
		email = "";
		pw1 = "";
	}

	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPw1() {
		return pw1;
	}



	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}




	
}
