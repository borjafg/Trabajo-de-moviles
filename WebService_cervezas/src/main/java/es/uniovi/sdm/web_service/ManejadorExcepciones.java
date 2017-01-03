package es.uniovi.sdm.web_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.uniovi.sdm.infrastructure.ErrorFactory;
import es.uniovi.sdm.infrastructure.ErrorFactory.Errors;
import es.uniovi.sdm.infrastructure.MyLogger;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;
import es.uniovi.sdm.web_service.responses.error.ErrorResponse;

@RestControllerAdvice
public class ManejadorExcepciones {

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
	@ExceptionHandler(value = { ErrorDePeticionException.class })
	public ResponseEntity<ErrorResponse> handleConflict(ErrorDePeticionException ex) {

		MyLogger.error("Ha ocurrido un error conocido al gestionar una petición");
		MyLogger.error("Causa del error:  " + ex.getCausaError());

		return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getCausaError()), ex.getEstado());
	}

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<ErrorResponse> handleConflict(RuntimeException e) {

		MyLogger.error("Ha ocurrido un error inesperado al gestionar una petición", e);

		ErrorDePeticionException error = ErrorFactory.getErrorResponse(Errors.ERROR_DESCONOCIDO);

		return new ResponseEntity<ErrorResponse>(new ErrorResponse(error.getCausaError()), error.getEstado());
	}

}