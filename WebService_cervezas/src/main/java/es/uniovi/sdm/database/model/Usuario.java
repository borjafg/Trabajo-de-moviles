package es.uniovi.sdm.database.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Z_Usuarios", schema="public")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String login;
	private String password;
	private String nombre;

	@OneToMany(mappedBy = "usuario")
	private Set<Busqueda> busquedas = new HashSet<Busqueda>();

	Usuario() {

	}

	public Usuario(String login, String password, String nombre) {
		this.login = login;
		this.password = password;

		this.nombre = nombre;
	}

	// ============================
	// Getters y Setters
	// ============================

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Busqueda> getBusquedas() {
		return new HashSet<Busqueda>(busquedas);
	}

	Set<Busqueda> _getBusquedas() {
		return busquedas;
	}

	// ============================
	// hashCode, equals, toString
	// ============================

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((login == null) ? 0 : login.hashCode());

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

		Usuario other = (Usuario) obj;

		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", nombre=" + nombre + "]";
	}

}