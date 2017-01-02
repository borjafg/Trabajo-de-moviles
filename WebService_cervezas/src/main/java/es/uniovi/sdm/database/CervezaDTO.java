package es.uniovi.sdm.database;

import es.uniovi.sdm.database.model.Cerveza;

public interface CervezaDTO {

	public Cerveza findByCodigo(String codigo);

}