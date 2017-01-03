package es.uniovi.sdm.web_service.responses.correcto;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.sdm.database.model.Cerveza;

public class HistorialResponse extends UsuarioResponse {

	private List<CervezaResponse> historial;

	HistorialResponse() {

	}

	public HistorialResponse(List<Cerveza> cervezas) {
		List<CervezaResponse> historial = new ArrayList<CervezaResponse>();

		for (Cerveza cerveza : cervezas) {
			historial.add(new CervezaResponse(cerveza));
		}

		setHistorial(historial);
	}

	// ================================
	// Getters y Setters
	// ================================

	public List<CervezaResponse> getHistorial() {
		return historial;
	}

	public void setHistorial(List<CervezaResponse> historial) {
		this.historial = historial;
	}

}