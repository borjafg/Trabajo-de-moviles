package es.uniovi.sdm.web_service.responses.error;

public class ErrorDesconocidoResponse extends ErrorResponse {

	private static final long serialVersionUID = 6120245795226005099L;

	@Override
	public String getMessageJSONFormat() {
		return "{\"reason\": \"Ha ocurrido un error\"}";
	}

	@Override
	public String getMessageStringFormat() {
		return "Ha ocurrido un error desconocido";
	}

}