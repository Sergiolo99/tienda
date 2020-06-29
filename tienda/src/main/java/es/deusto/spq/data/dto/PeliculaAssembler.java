package es.deusto.spq.data.dto;

import es.deusto.spq.data.Pelicula;

public class PeliculaAssembler {
	
	public PeliculaDTO assemble(Pelicula pelicula) {
		
		if(pelicula == null) return null;
		
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		
		peliculaDTO.setNombre(pelicula.getNombre());
		peliculaDTO.setTipo(pelicula.getTipo());
		peliculaDTO.setDirector(pelicula.getDirector());
		peliculaDTO.setActor(pelicula.getActor());
				
		return peliculaDTO;
	}

}
