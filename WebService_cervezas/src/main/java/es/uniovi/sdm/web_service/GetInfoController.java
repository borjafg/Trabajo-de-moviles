package es.uniovi.sdm.web_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.persistence.CervezaRepository;
import es.uniovi.sdm.infrastructure.ErrorFactory;
import es.uniovi.sdm.web_service.responses.correcto.CervezaResponse;
import es.uniovi.sdm.web_service.responses.error.ErrorResponse;

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
public class GetInfoController {

	private Logger log = LoggerFactory.getLogger(GetInfoController.class);

	private final CervezaRepository cervezaRepository;

	/**
	 * Constructor sin parámetros
	 * 
	 * @param cervezaRepository
	 *            permite acceder a la base de datos (lo crea el framework)
	 * 
	 */
	@Autowired
	GetInfoController(CervezaRepository cervezaRepository) {
		this.cervezaRepository = cervezaRepository;
	}

	/**
	 * Busca la información de una cerveza.
	 * 
	 * @param nombre
	 *            nombre de la cerveza
	 * 
	 * @return información de la cerveza en formato JSON
	 * 
	 */
	@RequestMapping(value = "/cerveza_info", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json", "application/xml" })
	public CervezaResponse findCerverzaByNombre(@RequestParam(value = "name", defaultValue = "Ninguno") String nombre) {

		log.debug("Peticion de los datos una cerveza --> nombre = '" + nombre + "'");

		Cerveza cerveza = cervezaRepository.findByNombre(nombre);

		if (cerveza == null) {
			throw ErrorFactory.getErrorResponse(ErrorFactory.Errors.CERVEZA_NO_ENCONTRADA);
		}

		return new CervezaResponse(nombre, Math.random());
	}

	/**
	 * Captura cualquier error que se produzca y envia como respuesta la causa
	 * del error.
	 * 
	 * @param excep
	 *            excepcion capturada
	 * 
	 * @return causa del error
	 * 
	 */
	@ExceptionHandler(ErrorResponse.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponses(ErrorResponse excep) {
		log.debug("Ha ocurrido un error al gestionar una petición");
		log.debug("Causa del error  --> " + excep.getMessageStringFormat());

		return excep.getMessageJSONFormat();
	}

}