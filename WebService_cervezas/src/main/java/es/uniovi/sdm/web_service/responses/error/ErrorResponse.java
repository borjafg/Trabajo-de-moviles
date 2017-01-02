package es.uniovi.sdm.web_service.responses.error;

public class ErrorResponse {

	private String causa;

	ErrorResponse() {

	}

	public ErrorResponse(String causa) {
		setCausa(causa);
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

}