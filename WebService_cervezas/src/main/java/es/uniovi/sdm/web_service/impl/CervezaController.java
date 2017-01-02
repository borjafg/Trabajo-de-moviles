package es.uniovi.sdm.web_service.impl;

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
import es.uniovi.sdm.web_service.requests.CervezaFindRequest;
import es.uniovi.sdm.web_service.responses.correcto.CervezaResponse;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

/**
 * Ejemplo de como "parametrizar" un método rest</br>
 * </br>
 * ====================</br>
 * == RequestMapping ==</br>
 * ====================</br>
 * </br>
 * Desde la direccion base a qué dirección se hace la petición.</br>
 * </br>
 * Dirección base: localhost</br>
 * </br>
 * Dirección para hacer la petición: localhost/cerveza_info</br>
 * </br>
 * ============</br>
 * == method ==</br>
 * ============</br>
 * </br>
 * GET o POST </br>
 * </br>
 * =============</br>
 * == headers ==</br>
 * =============</br>
 * </br>
 * En que formato espera recibir los datos de una petición.</br>
 * </br>
 * ==============</br>
 * == produces ==</br>
 * ==============</br>
 * </br>
 * En que formato envia los datos de la respuesta.
 * 
 */
@RestController
public class CervezaController {

	/**
	 * Busca la información de una cerveza.
	 * 
	 * @param nombre
	 *            nombre de la cerveza
	 * 
	 * @return información de la cerveza
	 * 
	 * @throws ErrorDePeticionException
	 *             ha ocurrido un error al buscar la información
	 * 
	 */
	@RequestMapping(value = "/cerveza_info", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	public ResponseEntity<CervezaResponse> findCerverzaByNombre(@RequestBody(required = true) CervezaFindRequest busqueda)
			throws ErrorDePeticionException {

		MyLogger.debug("Peticion de los datos una cerveza --> codigo = '" + busqueda.getCodigo_cerveza() + "'");

		Cerveza cerveza = DTOfactory.getCervezaDTO().findByCodigo(busqueda.getCodigo_cerveza());

		if (cerveza == null) {
			throw ErrorFactory.getErrorResponse(ErrorFactory.Errors.CERVEZA_NO_ENCONTRADA);
		}

		else {
			Usuario usuario = DTOfactory.getUsuarioDTO().findUsuario(busqueda.getUsuario().getLogin(),
					busqueda.getUsuario().getLogin());

			if (usuario == null) {
				throw ErrorFactory.getErrorResponse(Errors.USUARIO_NO_EXISTE);
			}

			DTOfactory.getBusquedaDTO().createOrUpdateBusqueda(usuario, cerveza);
		}

		return new ResponseEntity<CervezaResponse>(new CervezaResponse(cerveza), HttpStatus.OK);
	}

}