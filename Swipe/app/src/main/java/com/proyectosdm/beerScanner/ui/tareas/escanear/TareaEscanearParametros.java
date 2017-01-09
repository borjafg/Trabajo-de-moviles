package com.proyectosdm.beerScanner.ui.tareas.escanear;

import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.LoginActivity;
import com.proyectosdm.beerScanner.ui.Tab_1;

public class TareaEscanearParametros {

    private User user;
    private String codigo;
    private Tab_1 tab_1;

    public TareaEscanearParametros(String codigo, User user, Tab_1 tab_1) {
        this.codigo = codigo;
        this.user = user;
        this.tab_1 = tab_1;
    }

    public String getCodigo() {
        return codigo;
    }

    public User getUser() {
        return user;
    }

    public Tab_1 getTab_1() {
        return tab_1;
    }
}