package es.deusto.spq.server;


public class DAOFactory {

    private static DAOFactory instance;

    private UsuarioDAO usuarioDAO;
    private PeliculaDAO peliculaDAO;


    public DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    

    public UsuarioDAO createUsuarioDAO() {

        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }

    

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    public PeliculaDAO createPeliculaDAO() {
    	if (peliculaDAO == null) {
    		peliculaDAO = new PeliculaDAO();
        }  	
    	return peliculaDAO;
    }

    public void setPeliculaDAO(PeliculaDAO peliculaDAO) {
    	this.peliculaDAO = peliculaDAO;
    }
   

    
}