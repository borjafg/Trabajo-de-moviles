package es.uniovi.sdm.infrastructure;

import org.apache.log4j.Logger;

public class MyLogger {

	private static Logger log = Logger.getLogger(MyLogger.class);

	private MyLogger() {

	}

	public static void debug(String mensaje) {
		log.debug(mensaje);
	}

	public static void debug(String mensaje, Throwable th) {
		log.debug(mensaje, th);
	}

	public static void info(String mensaje) {
		log.info(mensaje);
	}

	public static void error(String mensaje) {
		log.error(mensaje);
	}

	public static void error(String mensaje, Throwable th) {
		log.error(mensaje, th);
	}

}