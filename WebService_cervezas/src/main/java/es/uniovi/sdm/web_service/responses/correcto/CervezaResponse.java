package es.uniovi.sdm.web_service.responses.correcto;

import es.uniovi.sdm.database.model.Cerveza;

/**
 * Las clases respuesta deben ser clases con atributos de tipos básicos.<br/>
 * <br/>
 * Cada atributo aparecerá en la respuesta.
 * 
 */
public class CervezaResponse {

	private String codigo;
	private String nombre;
	private String descripcion;
	private String estilo;
	private double graduacion;
	private String malta;
	private String lupulo;

	CervezaResponse() {
		super();
	}

	public CervezaResponse(Cerveza cerveza) {
		super();

		setCodigo(cerveza.getCodigo());
		setNombre(cerveza.getNombre());
		setDescripcion(cerveza.getDescripcion());
		setEstilo(cerveza.getEstilo());
		setGraduacion(cerveza.getGraduacion());
		setMalta(cerveza.getMalta());
		setLupulo(cerveza.getLupulo());
	}

	// ================================
	// Getters y Setters
	// ================================

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public void setGraduacion(double graduacion) {
		this.graduacion = graduacion;
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

}