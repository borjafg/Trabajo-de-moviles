package es.uniovi.sdm.database.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.sdm.database.BusquedaDTO;
import es.uniovi.sdm.database.model.Busqueda;
import es.uniovi.sdm.database.model.BusquedaKey;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.database.persistence.BusquedaRepository;

public class BusquedaDTOimpl implements BusquedaDTO {

	@Autowired
	private BusquedaRepository tablaBusquedas;

	@Override
	public List<Busqueda> findHistorial(Usuario usuario) {
		return tablaBusquedas.findByUsuario(usuario);
	}

	@Override
	public Busqueda findBusqueda(Usuario usuario, Cerveza cerveza) {
		return tablaBusquedas.findOne(getBusquedaKey(usuario, cerveza));
	}

	@Override
	public void createOrUpdateBusqueda(Usuario usuario, Cerveza cerveza) {
		tablaBusquedas.save(new Busqueda(usuario, cerveza, new Date()));
	}

	private BusquedaKey getBusquedaKey(Usuario usuario, Cerveza cerveza) {
		return new BusquedaKey(usuario.getId(), cerveza.getId());
	}

}