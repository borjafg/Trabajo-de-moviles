package es.uniovi.sdm.web_service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.infrastructure.DTOfactory;
import es.uniovi.sdm.infrastructure.ErrorFactory;
import es.uniovi.sdm.infrastructure.ErrorFactory.Errors;
import es.uniovi.sdm.infrastructure.MyLogger;
import es.uniovi.sdm.web_service.requests.HistorialFindRequest;
import es.uniovi.sdm.web_service.responses.correcto.HistorialResponse;
import es.uniovi.sdm.web_service.responses.correcto.UsuarioResponse;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

@RestController
public class BusquedaController {

	/**
	 * Busca el historial de un usuario.
	 * 
	 * @param busqueda
	 *            datos para localizar el historial usuario
	 * 
	 * @throws ErrorDePeticionException
	 *             ha ocurrido un error al buscar la información
	 * 
	 */
	@RequestMapping(value = "/historial", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public ResponseEntity<UsuarioResponse> buscarHistorial(@RequestBody(required = true) HistorialFindRequest busqueda)
			throws ErrorDePeticionException {

		MyLogger.debug("Peticion de busqueda del historial de un usuario --> login = '" + busqueda.getLogin() + "'");

		// ========================================
		// (1) Búsqueda de los datos de un usuario
		// ========================================

		Usuario usuario = DTOfactory.getUsuarioDTO().findUsuario(busqueda.getLogin(), busqueda.getPassword());

		if (usuario == null) {
			throw ErrorFactory.getErrorResponse(Errors.USUARIO_NO_EXISTE);
		}

		// =======================================
		// (2) Búsqueda del historial del usuario
		// =======================================

		List<Cerveza> historial = DTOfactory.getBusquedaDTO().findHistorial(usuario);
		
		// ==========================
		// (3) Devolver el historial
		// ==========================

		return new ResponseEntity<UsuarioResponse>(new HistorialResponse(historial), HttpStatus.OK);
	}

}