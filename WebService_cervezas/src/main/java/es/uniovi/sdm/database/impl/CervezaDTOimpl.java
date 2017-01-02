package es.uniovi.sdm.database.impl;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.sdm.database.CervezaDTO;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.persistence.CervezaRepository;

public class CervezaDTOimpl implements CervezaDTO {
	
	@Autowired
	private CervezaRepository tablaCervezas;

	@Override
	public Cerveza findByCodigo(String codigo) {
		return tablaCervezas.findByCodigo(codigo);
	}

}