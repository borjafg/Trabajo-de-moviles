package es.uniovi.sdm.database.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uniovi.sdm.database.model.Busqueda;
import es.uniovi.sdm.database.model.BusquedaKey;
import es.uniovi.sdm.database.model.Cerveza;
import es.uniovi.sdm.database.model.Usuario;

public interface BusquedaRepository extends JpaRepository<Busqueda, BusquedaKey> {

	public List<Busqueda> findByUsuario(Usuario usuario);

	@Query("select b.cerveza.estilo from Busqueda b where b.usuario = :usuario group by b.cerveza.estilo order by sum(b.cerveza.estilo) DESC")
	public List<String> findEstilosCervezaBuscados(@Param(value = "usuario") Usuario usuario);

	@Query("select c from Cerveza c where c.estilo = :estilo and c not in (select b.cerveza from Busqueda b where b.usuario = :usuario)")
	public List<Cerveza> findCervezaNoBuscada(@Param(value = "estilo") String estilo, @Param(value = "usuario") Usuario usuario, Pageable limite);

}