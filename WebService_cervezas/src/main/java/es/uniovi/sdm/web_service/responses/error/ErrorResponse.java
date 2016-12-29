package es.uniovi.sdm.web_service.responses.error;

/**
 * Sólo sirve para poder recoger las excpeciones que se puedan recoger las
 * excepciones que se producen en la respuesta.</br>
 * </br>
 * El error tendrá esta estructura:</br>
 * </br>
 * <i>{"reason": "Causa por la que ocurrió el error"}</i>
 * 
 */
public abstract class ErrorResponse extends RuntimeException {

	private static final long serialVersionUID = -1310142541863329731L;

	/**
	 * Devuelve en formato JSON la causa del error
	 * 
	 * @return causa del error
	 * 
	 */
	public abstract String getMessageJSONFormat();

	/**
	 * Devuelve en una cadena de texto la causa del error.
	 * 
	 * @return causa del error
	 * 
	 */
	public abstract String getMessageStringFormat();

}