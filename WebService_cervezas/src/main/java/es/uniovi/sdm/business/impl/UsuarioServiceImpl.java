package es.uniovi.sdm.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uniovi.sdm.business.UsuarioService;
import es.uniovi.sdm.database.model.Usuario;
import es.uniovi.sdm.database.persistence.UsuarioRepository;
import es.uniovi.sdm.infrastructure.ErrorFactory;
import es.uniovi.sdm.infrastructure.ErrorFactory.Errors;
import es.uniovi.sdm.infrastructure.MyLogger;
import es.uniovi.sdm.web_service.responses.error.ErrorDePeticionException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository tablaUsuarios;

	@Autowired
	UsuarioServiceImpl(UsuarioRepository tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
		
		MyLogger.debug("El repositorio es null: " + String.valueOf(tablaUsuarios == null));
	}

	@Override
	public Usuario findUsuario(String login, String password) {
		return tablaUsuarios.findByLoginAndPassword(login, password);
	}

	@Transactional
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