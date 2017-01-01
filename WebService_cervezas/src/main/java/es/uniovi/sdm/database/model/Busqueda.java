package es.uniovi.sdm.database.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(BusquedaKey.class)
@Table(name = "Z_Busquedas")
public class Busqueda {

	@Id
	@ManyToOne
	private Usuario usuario;

	@Id
	@ManyToOne
	private Cerveza cerveza;

	@Temporal(TemporalType.TIME)
	private Date fechaUltimaBusqueda;

	Busqueda() {

	}

	public Busqueda(Usuario usuario, Cerveza cerveza) {
		this.usuario = usuario;
		this.cerveza = cerveza;
	}

	// ============================
	// Getters y Setters
	// ============================

	public Usuario getUsuario() {
		return usuario;
	}

	public Cerveza getCerveza() {
		return cerveza;
	}

	public Date getFechaUltimaBusqueda() {
		return fechaUltimaBusqueda;
	}

	public void setFechaUltimaBusqueda(Date fechaUltimaBusqueda) {
		this.fechaUltimaBusqueda = fechaUltimaBusqueda;
	}

	// ============================
	// hashCode, equals, toString
	// ============================

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((cerveza == null) ? 0 : cerveza.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Busqueda other = (Busqueda) obj;

		if (cerveza == null) {
			if (other.cerveza != null)
				return false;
		} else if (!cerveza.equals(other.cerveza))
			return false;

		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Busqueda [usuario=" + usuario + ", cerveza=" + cerveza + ", fechaUltimaBusqueda=" + fechaUltimaBusqueda
				+ "]";
	}

}