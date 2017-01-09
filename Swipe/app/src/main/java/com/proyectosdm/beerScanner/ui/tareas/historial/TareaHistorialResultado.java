package com.proyectosdm.beerScanner.ui.tareas.historial;

import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.ui.Tab_2;

import java.util.List;


public class TareaHistorialResultado {

    private Tab_2 tab_2;
    private List<Cerveza> listaCervezas;
    private String causaError; // Solo si cerveza es null

    public TareaHistorialResultado(Tab_2 tab_2, List<Cerveza> listaCerveza, String causaError) {
        this.tab_2 = tab_2;
        this.listaCervezas = listaCerveza;
        this.causaError = causaError;
    }

    public Tab_2 getTab_2() {
        return tab_2;
    }

    public List<Cerveza> getListaCervezas() {
        return listaCervezas;
    }

    public String getCausaError() {
        return causaError;
    }
}
