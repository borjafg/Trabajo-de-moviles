package es.uniovi.sdm.web_service.responses.correcto;

import es.uniovi.sdm.database.model.Usuario;

public class UsuarioResponse {

	private String login;
	private String password;
	private String nombre;

	UsuarioResponse() {

	}

	public UsuarioResponse(Usuario usuario) {
		setLogin(usuario.getLogin());
		setPassword(usuario.getPassword());
		setNombre(usuario.getNombre());
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}