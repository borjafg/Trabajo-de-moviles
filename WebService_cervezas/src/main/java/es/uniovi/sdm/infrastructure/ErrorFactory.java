package es.uniovi.sdm.infrastructure;

import es.uniovi.sdm.web_service.responses.error.CervezaNoEncontradaErrorResponse;
import es.uniovi.sdm.web_service.responses.error.ErrorDesconocidoResponse;
import es.uniovi.sdm.web_service.responses.error.ErrorResponse;

/**
 * Sólo sirve para poder recoger las excpeciones que se puedan recoger las
 * excepciones que se producen en la respuesta.</br>
 * </br>
 * El error tendrá esta estructura:</br>
 * </br>
 * <i>{"reason": "Causa por la que ocurrió el error"}</i>
 * 
 */
public class ErrorFactory {

	public static enum Errors {
		CERVEZA_NO_ENCONTRADA, ERROR_DESCONOCIDO
	};

	/**
	 * No tiene sentido que se creen instancias de la factoría. Su función sólo
	 * es devolver el error apropiado para la causa que se le indique.
	 * 
	 */
	private ErrorFactory() {

	}

	public static ErrorResponse getErrorResponse(Errors causaError) {
		switch (causaError) {

		case CERVEZA_NO_ENCONTRADA:
			return new CervezaNoEncontradaErrorResponse();

		case ERROR_DESCONOCIDO:
			return new ErrorDesconocidoResponse();

		default:
			return new ErrorDesconocidoResponse();

		}
	}
}
