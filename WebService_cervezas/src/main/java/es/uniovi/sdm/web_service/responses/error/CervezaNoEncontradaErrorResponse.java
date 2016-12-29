package es.uniovi.sdm.web_service.responses.error;

public class CervezaNoEncontradaErrorResponse extends ErrorResponse {

	private static final long serialVersionUID = -7232195570957570621L;

	@Override
	public String getMessageJSONFormat() {
		return "{\"reason\": \"Cerveza no encontrada\"}";
	}

	@Override
	public String getMessageStringFormat() {
		return "No se ha encontrado la cerveza";
	}

}