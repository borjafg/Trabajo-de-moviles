package com.proyectosdm.beerScanner.business.impl.util;

import com.proyectosdm.beerScanner.model.Cerveza;

public class HistorialRespuesta {

    private Cerveza[] historial;

    public HistorialRespuesta() {
    }

    public HistorialRespuesta(Cerveza[] historial) {
        this.historial = historial;
    }

    public Cerveza[] getHistorial() {
        return historial;
    }
}
