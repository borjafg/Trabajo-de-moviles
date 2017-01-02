package es.uniovi.sdm.web_service.requests;

public class UsuarioCreateRequest {

	private String login;
	private String password;
	private String nombre;

	UsuarioCreateRequest() {

	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getNombre() {
		return nombre;
	}

}