package com.proyectosdm.beerScanner.ui.tareas.sugerencia;

import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.Tab_1;

public class TareaSugerenciaParametros {

    private User user;
    private Tab_1 tab_1;

    public TareaSugerenciaParametros(User user, Tab_1 tab_1) {
        this.user = user;
        this.tab_1 = tab_1;
    }

    public User getUser() {
        return user;
    }

    public Tab_1 getTab_1() {
        return tab_1;
    }
}
