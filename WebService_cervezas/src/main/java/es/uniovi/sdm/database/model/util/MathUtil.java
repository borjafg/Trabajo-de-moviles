package es.uniovi.sdm.database.model.util;

public class MathUtil {

	private MathUtil() {

	}

	public static double roundDouble(double valor) {
		double valorFinal = valor * 100;
		int valorRedondeado = (int) valorFinal;
		valorFinal = valorRedondeado / 100;

		return valorFinal;
	}

}