package es.uniovi.sdm.database.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.sdm.database.BusquedaDTO;
import es.uniovi.sdm.database.model.Busqueda;
import es.uniovi.sdm.database.model.BusquedaKey;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.database.persistence.BusquedaRepository;
import es.uniovi.sdm.infrastructure.ErrorFactory;
import es.uniovi.sdm.infrastructure.ErrorFactory.Errors;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

public class BusquedaDTOimpl implements BusquedaDTO {

	@Autowired
	private BusquedaRepository tablaBusquedas;

	@Override
	public List<Cerveza> findHistorial(Usuario usuario) throws ErrorDePeticionException {
		List<Busqueda> busquedas = tablaBusquedas.findByUsuario(usuario);

		if (busquedas.isEmpty()) {
			throw ErrorFactory.getErrorResponse(ErrorFactory.Errors.SIN_BUSQUEDAS);
		}

		List<Cerveza> cervezas = new ArrayList<Cerveza>();

		for (Busqueda busqueda : busquedas) {
			cervezas.add(busqueda.getCerveza());
		}

		return cervezas;
	}

	@Override
	public Busqueda findBusqueda(Usuario usuario, Cerveza cerveza) {
		return tablaBusquedas.findOne(getBusquedaKey(usuario, cerveza));
	}

	@Override
	public void createOrUpdateBusqueda(Usuario usuario, Cerveza cerveza) {
		tablaBusquedas.save(new Busqueda(usuario, cerveza, new Date()));
	}

	@Override
	public Cerveza findCervezaSugerir(Usuario usuario) throws ErrorDePeticionException {
		List<String> tiposCervezaBuscados = tablaBusquedas.findTiposCervezaBuscados(usuario);

		if (tiposCervezaBuscados.isEmpty()) {
			throw ErrorFactory.getErrorResponse(Errors.NO_POSIBLE_SUGERIR_HISTORIAL_VACIO);
		}

		Cerveza cerveza;

		for (String tipo : tiposCervezaBuscados) {
			cerveza = tablaBusquedas.findCervezaNoBuscada(tipo, usuario);

			if (cerveza != null) {
				createOrUpdateBusqueda(usuario, cerveza);
				return cerveza;
			}
		}

		throw ErrorFactory.getErrorResponse(Errors.NO_POSIBLE_SUGERIR_DATOS_INSUFICIENTES);
	}

	private BusquedaKey getBusquedaKey(Usuario usuario, Cerveza cerveza) {
		return new BusquedaKey(usuario.getId(), cerveza.getId());
	}

}