package es.uniovi.sdm.database;

import java.util.List;

import es.uniovi.sdm.database.model.Busqueda;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

public interface BusquedaDTO {

	public List<Cerveza> findHistorial(Usuario usuario) throws ErrorDePeticionException;

	public Busqueda findBusqueda(Usuario usuario, Cerveza cerveza);

	public void createOrUpdateBusqueda(Usuario usuario, Cerveza cerveza);

	public Cerveza findCervezaSugerir(Usuario usuario) throws ErrorDePeticionException;

}