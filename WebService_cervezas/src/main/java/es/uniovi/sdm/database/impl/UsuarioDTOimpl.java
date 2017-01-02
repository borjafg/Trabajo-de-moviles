package es.uniovi.sdm.database.impl;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.sdm.database.UsuarioDTO;
import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.database.persistence.UsuarioRepository;
import es.uniovi.sdm.infrastructure.ErrorFactory;
import es.uniovi.sdm.infrastructure.ErrorFactory.Errors;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

public class UsuarioDTOimpl implements UsuarioDTO {

	@Autowired
	private UsuarioRepository tablaUsuarios;

	@Override
	public Usuario findUsuario(String login, String password) {
		return tablaUsuarios.findByLoginAndPassword(login, password);
	}

	@Override
	public Usuario registrarse(String login, String password, String nombre) throws ErrorDePeticionException {
		Usuario user = tablaUsuarios.findByLogin(login);

		if (user != null) {
			throw ErrorFactory.getErrorResponse(Errors.USUARIO_YA_EXISTE);
		}

		user = new Usuario(login, password, nombre);

		tablaUsuarios.save(user);

		return user;
	}

}