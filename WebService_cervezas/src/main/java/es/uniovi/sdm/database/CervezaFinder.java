package es.uniovi.sdm.database;

import es.uniovi.sdm.database.model.Cerveza;

public interface CervezaFinder {

	public Cerveza findByNombre(String nombre);

}