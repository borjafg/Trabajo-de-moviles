package com.proyectosdm.beerScanner.ui.tareas.historial;


import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.Tab_2;

public class TareaHistorialParametros {

    private User user;
    private Tab_2 tab_2;

    public TareaHistorialParametros(User user, Tab_2 tab_2) {
        this.user = user;
        this.tab_2 = tab_2;
    }

    public User getUser() {
        return user;
    }

    public Tab_2 getTab_2() {
        return tab_2;
    }
}
