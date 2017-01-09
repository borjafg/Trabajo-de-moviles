package com.proyectosdm.beerScanner.ui.tareas.registro;

import com.proyectosdm.beerScanner.ui.RegistroActivity;

public class TareaRegistroParametros {

    private String nombre;
    private String login;
    private String password;

    private RegistroActivity registroActivity;

    public TareaRegistroParametros(String nombre, String login, String password, RegistroActivity registroActivity) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.registroActivity = registroActivity;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public RegistroActivity getRegistroActivity() {
        return registroActivity;
    }
}
