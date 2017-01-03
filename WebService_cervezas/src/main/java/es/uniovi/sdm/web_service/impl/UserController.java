package es.uniovi.sdm.web_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.sdm.business.UsuarioService;
import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.infrastructure.ErrorFactory;
import es.uniovi.sdm.infrastructure.ErrorFactory.Errors;
import es.uniovi.sdm.infrastructure.MyLogger;
import es.uniovi.sdm.web_service.requests.UsuarioCreateRequest;
import es.uniovi.sdm.web_service.requests.UsuarioFindRequest;
import es.uniovi.sdm.web_service.responses.correcto.UsuarioResponse;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

@RestController
public class UserController {

	private final UsuarioService usuarioService;

	@Autowired
	UserController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * Busca la información de un usuario.
	 * 
	 * @param busqueda
	 *            datos para localizar al usuario
	 * 
	 * @return información del usuario
	 * 
	 * @throws ErrorDePeticionException
	 *             ha ocurrido un error al buscar la información
	 * 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public ResponseEntity<UsuarioResponse> login(@RequestBody(required = true) UsuarioFindRequest busqueda)
			throws ErrorDePeticionException {

		MyLogger.debug("Peticion de los datos un usuario --> login = '" + busqueda.getLogin() + "'");
		MyLogger.debug("Peticion de los datos un usuario --> password = '" + busqueda.getPassword() + "'");

		Usuario usuario = usuarioService.findUsuario(busqueda.getLogin(), busqueda.getPassword());

		if (usuario == null) {
			throw ErrorFactory.getErrorResponse(Errors.USUARIO_NO_EXISTE);
		}

		return new ResponseEntity<UsuarioResponse>(new UsuarioResponse(usuario), HttpStatus.OK);
	}

	/**
	 * Busca la información de un usuario.
	 * 
	 * @param busqueda
	 *            datos del usuario que se pretende crear
	 * 
	 * @throws ErrorDePeticionException
	 *             ha ocurrido un error al buscar la información
	 * 
	 */
	@RequestMapping(value = "/registrarse", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public ResponseEntity<UsuarioResponse> registrarse(@RequestBody(required = true) UsuarioCreateRequest busqueda)
			throws ErrorDePeticionException {

		MyLogger.debug("Peticion de registro de un usuario --> login = '" + busqueda.getLogin() + "'");

		Usuario usuario = usuarioService.registrarse(busqueda.getLogin(), busqueda.getPassword(), busqueda.getNombre());

		return new ResponseEntity<UsuarioResponse>(new UsuarioResponse(usuario), HttpStatus.OK);
	}

}