package es.uniovi.sdm.web_service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.infrastructure.DTOfactory;
import es.uniovi.sdm.infrastructure.ErrorFactory;
import es.uniovi.sdm.infrastructure.ErrorFactory.Errors;
import es.uniovi.sdm.infrastructure.MyLogger;
import es.uniovi.sdm.web_service.requests.UsuarioCreateRequest;
import es.uniovi.sdm.web_service.requests.UsuarioFindRequest;
import es.uniovi.sdm.web_service.responses.correcto.UsuarioResponse;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

@RestController
public class UserController {

	/**
	 * Busca la información de un usuario.
	 * 
	 * @param UsuarioFindRequest
	 *            datos para localizar al usuario
	 * 
	 * @return información del usuario
	 * 
	 * @throws ErrorDePeticionException
	 *             ha ocurrido un error al buscar la información
	 * 
	 */
	@RequestMapping(value = "/cerveza_info", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	public ResponseEntity<UsuarioResponse> login(@RequestBody(required = true) UsuarioFindRequest busqueda)
			throws ErrorDePeticionException {

		MyLogger.debug("Peticion de los datos un usuario --> login = '" + busqueda.getLogin() + "'");
		MyLogger.debug("Peticion de los datos un usuario --> password = '" + busqueda.getPassword() + "'");

		Usuario usuario = DTOfactory.getUsuarioDTO().findUsuario(busqueda.getLogin(), busqueda.getPassword());

		if (usuario == null) {
			throw ErrorFactory.getErrorResponse(Errors.USUARIO_NO_EXISTE);
		}

		return new ResponseEntity<UsuarioResponse>(new UsuarioResponse(usuario), HttpStatus.OK);
	}

	/**
	 * Busca la información de un usuario.
	 * 
	 * @param UsuarioFindRequest
	 *            datos para localizar al usuario
	 * 
	 * @return información del usuario
	 * 
	 * @throws ErrorDePeticionException
	 *             ha ocurrido un error al buscar la información
	 * 
	 */
	@RequestMapping(value = "/cerveza_info", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public ResponseEntity<UsuarioResponse> registrarse(@RequestBody(required = true) UsuarioCreateRequest busqueda)
			throws ErrorDePeticionException {

		MyLogger.debug("Peticion de registro de un usuario --> login = '" + busqueda.getLogin() + "'");

		Usuario usuario = DTOfactory.getUsuarioDTO().registrarse(busqueda.getLogin(), busqueda.getPassword(),
				busqueda.getNombre());

		return new ResponseEntity<UsuarioResponse>(new UsuarioResponse(usuario), HttpStatus.OK);
	}

}