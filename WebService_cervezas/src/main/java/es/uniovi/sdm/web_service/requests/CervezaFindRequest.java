package es.uniovi.sdm.web_service.requests;

public class CervezaFindRequest {

	private UsuarioFindRequest usuario;

	private String codigo_cerveza;

	CervezaFindRequest() {

	}

	public UsuarioFindRequest getUsuario() {
		return usuario;
	}

	public String getCodigo_cerveza() {
		return codigo_cerveza;
	}

}