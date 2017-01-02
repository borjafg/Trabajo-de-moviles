package es.uniovi.sdm.database.persistence;

import es.uniovi.sdm.database.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Usuario findByLoginAndPassword(String login, String password);

	public Usuario findByLogin(String login);

}