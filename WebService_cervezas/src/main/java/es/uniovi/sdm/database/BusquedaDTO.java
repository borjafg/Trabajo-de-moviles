package es.uniovi.sdm.database;

import java.util.List;

import es.uniovi.sdm.database.model.Busqueda;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.model.Usuario;

public interface BusquedaDTO {

	public List<Busqueda> findHistorial(Usuario usuario);

	public Busqueda findBusqueda(Usuario usuario, Cerveza cerveza);

	public void createOrUpdateBusqueda(Usuario usuario, Cerveza cerveza);

}