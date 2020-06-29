package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import es.deusto.spq.data.*;
import es.deusto.spq.data.dto.UsuarioLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//cambiar URL
@Path("/tienda")
@Produces(MediaType.APPLICATION_JSON)
public class AppServer {

	Logger logger = LoggerFactory.getLogger(AppServer.class);

	public AppServer() {
		
	}

	
	@Path("/registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(Usuario usuario){

		logger.info("Registrando usuario " + usuario.getNickname());
	 	DAOFactory.getInstance().createUsuarioDAO().guardar(usuario);
	 	return Response.status(Response.Status.OK).build();

	}

	
	@Path("/reset")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response actualizarPassword(UsuarioLogin ul){

		logger.info("Reseteando contraseña de "+ul.getNick());
		DAOFactory.getInstance().createUsuarioDAO().actualizarPassword(ul.getNick(), ul.getPassword());		
		return Response.status(Response.Status.OK).build();
	}

	
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(UsuarioLogin ul){
		Usuario u = DAOFactory.getInstance().createUsuarioDAO().getUsuario(ul.getNick());

	 	if(u == null) {
			logger.error("Usuario no encontrado");
			 return Response.status(Response.Status.NOT_FOUND).build();			 
	 	}else if(!u.getPw1().equals(ul.getPassword())) {
			logger.error("Contraseña inválida");
			return Response.status(Response.Status.BAD_REQUEST).build();
	 	}else{
			logger.info("Login de " + ul.getNick());
			return Response.status(Response.Status.OK).build();
		 	}
		
		
			 
	 }
	
	
	

}