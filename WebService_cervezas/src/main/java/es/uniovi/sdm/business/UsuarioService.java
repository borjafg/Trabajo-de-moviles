package es.uniovi.sdm.business;

import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

public interface UsuarioService {

	public Usuario findUsuario(String login, String password);

	public Usuario registrarse(String login, String password, String nombre) throws ErrorDePeticionException;

}