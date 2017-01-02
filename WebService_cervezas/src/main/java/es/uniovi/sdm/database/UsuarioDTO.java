package es.uniovi.sdm.database;

import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

public interface UsuarioDTO {

	public Usuario findUsuario(String login, String password);

	public Usuario registrarse(String login, String password, String nombre) throws ErrorDePeticionException;

}