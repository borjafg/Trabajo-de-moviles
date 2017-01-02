package es.uniovi.sdm.infrastructure;

import es.uniovi.sdm.database.BusquedaDTO;
import es.uniovi.sdm.database.CervezaDTO;
import es.uniovi.sdm.database.UsuarioDTO;
import es.uniovi.sdm.database.impl.BusquedaDTOimpl;
import es.uniovi.sdm.database.impl.CervezaDTOimpl;
import es.uniovi.sdm.database.impl.UsuarioDTOimpl;

public class DTOfactory {

	public static CervezaDTO getCervezaDTO() {
		return new CervezaDTOimpl();
	}

	public static UsuarioDTO getUsuarioDTO() {
		return new UsuarioDTOimpl();
	}

	public static BusquedaDTO getBusquedaDTO() {
		return new BusquedaDTOimpl();
	}

}