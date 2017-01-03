package es.uniovi.sdm.database.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.uniovi.sdm.database.model.Busqueda;
import es.uniovi.sdm.database.model.BusquedaKey;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.model.Usuario;

public interface BusquedaRepository extends CrudRepository<Busqueda, BusquedaKey> {

	public List<Busqueda> findByUsuario(Usuario usuario);

	@Query("select b.cerveza.tipo from Busqueda b group by b.cerveza.tipo order by sum(b.cerveza.tipo) DESC")
	public List<String> findTiposCervezaBuscados(@Param(value = "usuario") Usuario usuario);

	@Query("select c from Cerveza c where c.tipo = :tipo and c not in (select b.cerveza from Busqueda b where b.usuario = :usuario) limit 1")
	public Cerveza findCervezaNoBuscada(@Param(value = "tipo") String tipo, @Param(value = "usuario") Usuario usuario);

}