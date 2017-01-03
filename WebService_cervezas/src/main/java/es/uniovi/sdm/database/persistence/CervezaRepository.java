package es.uniovi.sdm.database.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.sdm.database.model.Cerveza;

public interface CervezaRepository extends JpaRepository<Cerveza, Long> {

	public Cerveza findByCodigo(String codigo);

}