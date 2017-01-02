package es.uniovi.sdm.database.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.sdm.database.model.Busqueda;
import es.uniovi.sdm.database.model.BusquedaKey;
import es.uniovi.sdm.database.model.Usuario;

public interface BusquedaRepository extends CrudRepository<Busqueda, BusquedaKey> {

	public List<Busqueda> findByUsuario(Usuario usuario);

}