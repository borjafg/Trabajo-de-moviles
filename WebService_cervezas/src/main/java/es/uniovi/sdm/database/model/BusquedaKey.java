package es.uniovi.sdm.database.model;

import java.io.Serializable;

public class BusquedaKey implements Serializable {

	private static final long serialVersionUID = -4526618703517515395L;

	private Long usuario;
	private Long cerveza;

	BusquedaKey() {

	}

	// ============================
	// Getters y Setters
	// ============================

	public Long getUsuario() {
		return usuario;
	}

	public Long getCerveza() {
		return cerveza;
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

		BusquedaKey other = (BusquedaKey) obj;

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
		return "BusquedaKey [usuario=" + usuario + ", cerveza=" + cerveza + "]";
	}

}