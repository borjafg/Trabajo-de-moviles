package com.proyectosdm.swipe.ui.tareas.login;

import com.proyectosdm.swipe.ui.MainActivity;

public class TareaLoginParametros {

    private String login;
    private String password;

    private MainActivity mainActivity;

    public TareaLoginParametros(String login, String password, MainActivity mainActivity) {
        this.login = login;
        this.password = password;
        this.mainActivity = mainActivity;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public  MainActivity getMainActivity() {
        return mainActivity;
    }
}