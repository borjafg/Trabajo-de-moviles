package es.uniovi.sdm.web_service.responses.correcto;

/**
 * Las clases respuesta deben ser clases con atributos de tipos básicos.<br/>
 * <br/>
 * Cada atributo aparecerá en la respuesta.
 * 
 */
public class CervezaResponse {

	private String atributo1;
	private double atributo2;

	public CervezaResponse() {
		super();
	}

	public CervezaResponse(String atributo1, double atributo2) {
		setAtributo1(atributo1);
		setAtributo2(atributo2);
	}

	public String getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	public double getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(double atributo2) {
		this.atributo2 = atributo2;
	}

}