package es.uniovi.sdm.database.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cerveza {

	@Id
	private Long id;

	private String nombre;

	public Cerveza(String nombre) {
		this.nombre = nombre;
	}

	// ============================
	// Getters y Setters
	// ============================

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// ============================
	// hashCode, equals, toString
	// ============================

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());

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

		Cerveza other = (Cerveza) obj;

		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;

		return true;
	}

}