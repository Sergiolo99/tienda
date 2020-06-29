package es.deusto.spq.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * Clase que contiene metodos que se usan en las interfaces.
 * @author eneko
 */
public class MetodosGUI {

	enum Resp {
        MISSMATCH,
        LENGTH,
        VALID
    }

	/**
	 * Función que valida el nombre del usuario si no está vacio
	 * @param nombre String en forma de nombre para validarlo.
	 * @return true si el nombre no está vacio.
	 */
	public boolean validarNombre(String nombre) {
		if(nombre.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Función que valida el nickname del usuario
	 * @param usuario String en forma de usuario para validarlo.
	 * @return true si el nickname no está vacio o tiene 5 letras o menos.
	 */
	public boolean validarUsuario(String usuario){
		
		 if (usuario.equals("") || usuario.length() <= 5 ){
			  return false;
		  }else {
			  return true;
		  }  
	}
	
	/**
	 * Función que valida la contraseña de la usuario
	 * @param pass1 Contraseña que se pasa como parametro para validarla.
	 * @return true si la contraseña no está vacia o tiene al menos 8 letras.
	 */
	public boolean validarContrasenya(String pass1){
		  if (pass1.equals("") || pass1.length() < 8) {
			  return false;
		  }else {
			  return true;
		  }  
	}
	
	/**
	 * Función que valida la confirmación de la contraseña.
	 * @param pass1 Contraseña 
	 * @param pass2 Confirmación de contraseña, se comprueban y se validan las dos.
	 * @return true si la contraseña es igual a la confirmación de contraseña.
	 */
	public boolean validarConfContrasenya(String pass1, String pass2) {
		if(pass1.equals(pass2)) {
			return true;
		}else{
			return false;
		}
		
	}

	/**
	 * Función que valida el email del usuario.
	 * @param email String como Email que se valida.
	 * @return true si el email concuerda con el patrón.
	 */
	public boolean validarEmail(String email) {
		String regex = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
		if (Pattern.matches(regex, email)) {
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Función que muestra un Popup al usuario si hay algún error.
	 * @param tF TextField del error. 
	 * @param mensaje String como mensaje que sale en el Popup.
	 * @return un Popup al usuario si hay algún error.
	 */
	public boolean mensajeError(JTextField tF, String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje); 
		tF.requestFocus();
		return false;
	}
	
	public boolean mensajeError1(JComboBox cb, String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje); 
		cb.requestFocus();
		return false;
	}
	
	public boolean comprobarVacio(JTextField tf) { 
		if(tf.getText().equals("")) {
			return mensajeError(tf, "Debes rellenar todos los campos");
		} else {
			return true;
		}
	}
	
	public boolean comprobarVacioItem(JComboBox cb) { 
		if(cb.getSelectedItem().equals("")) {
			return mensajeError1(cb, "Debes rellenar todos los campos");
		} else {
			return true;
		}
	}
	

	public static Resp validate(String p1, String p2){

        Resp r = Resp.VALID;
        if (p1.equals(p2)) {
            if(p1.length() < 4){
                r = Resp.LENGTH;
                return r;
            }else{
                return r;
            }           
        } else {
            r = Resp.MISSMATCH;
            return r;
		}
	}
	
	
	
	
}
