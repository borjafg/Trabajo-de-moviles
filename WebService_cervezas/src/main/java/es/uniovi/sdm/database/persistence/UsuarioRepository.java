package es.uniovi.sdm.database.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.sdm.database.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByLoginAndPassword(String login, String password);

	public Usuario findByLogin(String login);

}