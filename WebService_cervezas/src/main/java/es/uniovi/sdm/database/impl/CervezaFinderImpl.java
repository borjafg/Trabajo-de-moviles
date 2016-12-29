package es.uniovi.sdm.database.impl;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.sdm.database.CervezaFinder;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.persistence.CervezaRepository;

public class CervezaFinderImpl implements CervezaFinder {

	private CervezaRepository tablaCervezas;

	@Autowired
	CervezaFinderImpl(CervezaRepository tablaCervezas) {
		this.tablaCervezas = tablaCervezas;
	}

	@Override
	public Cerveza findByNombre(String nombre) {
		return tablaCervezas.findByNombre(nombre);
	}

}