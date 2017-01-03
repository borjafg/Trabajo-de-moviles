package es.uniovi.sdm.business;

import es.uniovi.sdm.database.model.Cerveza;

public interface CervezaService {

	public Cerveza findByCodigo(String codigo);

}