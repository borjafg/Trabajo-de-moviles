package es.uniovi.sdm.infrastructure;

import org.springframework.http.HttpStatus;

import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

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
		USUARIO_YA_EXISTE, USUARIO_NO_EXISTE, CERVEZA_NO_ENCONTRADA, SIN_BUSQUEDAS, NO_POSIBLE_SUGERIR_HISTORIAL_VACIO, NO_POSIBLE_SUGERIR_DATOS_INSUFICIENTES, ERROR_DESCONOCIDO
	};

	/**
	 * No tiene sentido que se creen instancias de la factoría. Su función sólo
	 * es devolver el error apropiado para la causa que se le indique.
	 * 
	 */
	private ErrorFactory() {

	}

	public static ErrorDePeticionException getErrorResponse(Errors causaError) {
		switch (causaError) {

		// ==========================
		// Usuario
		// ==========================

		case USUARIO_YA_EXISTE:
			return new ErrorDePeticionException("Ya existe un usuario con ese login", HttpStatus.IM_USED);

		case USUARIO_NO_EXISTE:
			return new ErrorDePeticionException("El usuario no existe o la contraseña es incorrecta",
					HttpStatus.NOT_FOUND);

		// ==========================
		// Cerveza
		// ==========================

		case CERVEZA_NO_ENCONTRADA:
			return new ErrorDePeticionException("No se ha encontrado la cerveza", HttpStatus.NOT_FOUND);

		// ==========================
		// Búsquedas
		// ==========================

		case SIN_BUSQUEDAS:
			return new ErrorDePeticionException("El historial de búsquedas está vacío", HttpStatus.NOT_FOUND);

		case NO_POSIBLE_SUGERIR_HISTORIAL_VACIO:
			return new ErrorDePeticionException("No se pueden hacer sugerencias porque el historial está vacío",
					HttpStatus.NOT_FOUND);

		case NO_POSIBLE_SUGERIR_DATOS_INSUFICIENTES:
			return new ErrorDePeticionException("No se pueden hacer sugerencias porque no hay datos suficientes",
					HttpStatus.NOT_FOUND);

		// ==========================
		// Error desconocido
		// ==========================

		case ERROR_DESCONOCIDO:
			return new ErrorDePeticionException("Ha ocurrido un error al procesar la petición",
					HttpStatus.INTERNAL_SERVER_ERROR);

		default:
			return new ErrorDePeticionException("Ha ocurrido un error al procesar la petición",
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
