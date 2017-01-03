package es.uniovi.sdm.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.sdm.business.CervezaService;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.persistence.CervezaRepository;
import es.uniovi.sdm.infrastructure.MyLogger;

@Service
public class CervezaServiceImpl implements CervezaService {

	private final CervezaRepository tablaCervezas;

	@Autowired
	CervezaServiceImpl(CervezaRepository tablaCervezas) {
		this.tablaCervezas = tablaCervezas;
		
		MyLogger.debug("El repositorio es null: " + String.valueOf(tablaCervezas == null));
	}

	@Override
	public Cerveza findByCodigo(String codigo) {
		return tablaCervezas.findByCodigo(codigo);
	}

}