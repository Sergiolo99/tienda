package es.deusto.spq.server;


import es.deusto.spq.data.Usuario;

public class MeterDatosBaseDeDatos {
	
	public static void main(String[] args) {
		
		
		Usuario u = new Usuario("sergiolopez", "sergiolopez");
		DAOFactory.getInstance().createUsuarioDAO().guardar(u);
		

	}



	
}
