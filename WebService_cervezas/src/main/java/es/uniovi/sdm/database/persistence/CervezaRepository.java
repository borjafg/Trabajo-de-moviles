package es.uniovi.sdm.database.persistence;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.sdm.database.model.Cerveza;

public interface CervezaRepository extends CrudRepository<Cerveza, Long> {

	public Cerveza findByNombre(String nombre);

}
