package es.uniovi.sdm.database.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.uniovi.sdm.database.model.util.MathUtil;

@Entity
@Table(name = "Z_Cervezas", schema="public")
public class Cerveza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo;
	private String nombre;
	private String descripcion;
	private String estilo;
	private double graduacion;
	private String malta;
	private String lupulo;

	@OneToMany(mappedBy = "cerveza")
	private Set<Busqueda> busquedas = new HashSet<Busqueda>();

	Cerveza() {

	}

	public Cerveza(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	// ============================
	// Getters y Setters
	// ============================

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public double getGraduacion() {
		return graduacion;
	}

	/**
	 * Asigna una graduacion a una cerveza.
	 * 
	 * @param graduacion
	 *            procentaje de alcohol de la cerveza.
	 * 
	 * @throws IllegalArgumentException
	 *             El valor del porcentaje no está entre 0 y 100
	 * 
	 */
	public void setGraduacion(double graduacion) throws IllegalArgumentException {
		double grad = MathUtil.roundDouble(graduacion);

		if (grad < 0 || grad > 100) {
			throw new IllegalArgumentException();
		}
	}

	public String getMalta() {
		return malta;
	}

	public void setMalta(String malta) {
		this.malta = malta;
	}

	public String getLupulo() {
		return lupulo;
	}

	public void setLupulo(String lupulo) {
		this.lupulo = lupulo;
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

		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());

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

		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Cerveza [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", estilo=" + estilo + ", graduacion=" + graduacion + ", malta=" + malta + ", lupulo=" + lupulo + "]";
	}

}