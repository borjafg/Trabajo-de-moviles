package com.proyectosdm.beerScanner.ui.tareas.sugerencia;

import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.LoginActivity;
import com.proyectosdm.beerScanner.ui.Tab_1;

public class TareaSugerenciaResultado {

    private Tab_1 tab_1;
    private Cerveza cerveza;
    private String causaError; // Solo si cerveza es null

    public TareaSugerenciaResultado(Tab_1 tab_1, Cerveza cerveza, String causaError) {
        this.tab_1 = tab_1;
        this.cerveza = cerveza;
        this.causaError = causaError;
    }

    public Tab_1 getTab_1() {
        return tab_1;
    }

    public Cerveza getCerveza() {
        return cerveza;
    }

    public String getCausaError() {
        return causaError;
    }
}
