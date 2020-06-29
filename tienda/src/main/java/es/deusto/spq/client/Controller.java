package es.deusto.spq.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.deusto.spq.data.Pelicula;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.dto.UsuarioLogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


 

public class Controller {

    private static Controller instance;

    private Client client;
    private WebTarget webTarget;
    private WebTarget requestTarget;
    
    Usuario usuarioActual;

    Logger logger = LoggerFactory.getLogger(Controller.class);

    public void setUsuario(Usuario u) {
        instance.usuarioActual = u;
    }

    public Usuario getUsuario() {
        return instance.usuarioActual;
    }

    public void setWebTarget(WebTarget wt) {
        webTarget = wt;
    }

    public String m() {
        return requestTarget.toString();
    }

   
    public Controller() {

        String hostname;
        String port;
        Properties props = new Properties();

        try {
            props.load(Controller.class.getClassLoader().getResourceAsStream("server.properties"));
            hostname = props.getProperty("server.hostname");
            port = props.getProperty("server.port");

            logger.info("Servidor arrancado");
        } catch (IOException e) {
           logger.error("ERROR INICIANDO SERVER");
            e.printStackTrace();
            hostname = props.getProperty("127.0.0.1");
            port = props.getProperty("8080");
        }

        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
        //System.out.println(String.format("http://%s:%s/rest", hostname, port));

    }

    
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
            instance.setUsuario(null);
        }
        return instance;
    }
    
    
    public Response registrarUsuario(Usuario usuario) {
        WebTarget publicarTarget = webTarget.path("usuarios/registrar");
        Entity<Usuario> entity = Entity.entity(usuario, MediaType.APPLICATION_JSON);
        Response response = publicarTarget.request().post(entity);
        return response;
    }

    
    public Response login(String u, String p) {
        WebTarget loginTarget = webTarget.path("usuarios/login");
        UsuarioLogin ul = new UsuarioLogin(u, p);
        Entity<UsuarioLogin> entity = Entity.entity(ul, MediaType.APPLICATION_JSON);
        Response response = loginTarget.request().post(entity);

        return response;
    }
    
    public Response guardarNuevaPelicula(Pelicula pelicula) {
        WebTarget publicarTarget = webTarget.path("pelicula/nuevaPelicula");
        Entity<Pelicula> entity = Entity.entity(pelicula, MediaType.APPLICATION_JSON);
        Response response = publicarTarget.request().post(entity);
        return response;
    }

    public List<Pelicula> getPeliculas() {
        List<Pelicula> pelicula = new ArrayList<Pelicula>();
        WebTarget pisosWebTarget = webTarget.path("peliculas");
        GenericType<List<Pelicula>> genericType = new GenericType<List<Pelicula>>() {
        };
        pelicula = pisosWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        return pelicula;
    }
    
    
    
    
    
    
   

}