package com.proyectosdm.swipe.ui.tareas.registro;

import com.proyectosdm.swipe.ui.MainActivity;

/**
 * Created by Alberto Cortina on 10/01/2017.
 */

public class TareaRegistroParametros {

    private String nombre;
    private String login;
    private String password;

    private MainActivity mainActivity;

    public TareaRegistroParametros(String nombre, String login, String password, MainActivity mainActivity) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.mainActivity = mainActivity;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword(){
        return password;
    }

    public  MainActivity getMainActivity() {
        return mainActivity;
    }
}
