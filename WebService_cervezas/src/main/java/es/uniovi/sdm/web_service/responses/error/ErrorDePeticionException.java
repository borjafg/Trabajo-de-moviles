package es.uniovi.sdm.web_service.responses.error;

import org.springframework.http.HttpStatus;

public class ErrorDePeticionException extends Exception {

	private static final long serialVersionUID = -6705184593720481542L;

	private String causaError;
	private HttpStatus estado;

	public ErrorDePeticionException(String causaError, HttpStatus estado) {
		this.causaError = causaError;
		this.estado = estado;
	}

	public String getCausaError() {
		return causaError;
	}

	public HttpStatus getEstado() {
		return estado;
	}

}