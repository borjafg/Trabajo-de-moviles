package com.proyectosdm.beerScanner.ui.tareas.login;

import com.proyectosdm.beerScanner.ui.LoginActivity;

public class TareaLoginParametros {

    private String login;
    private String password;
    private LoginActivity loginActivity;

    public TareaLoginParametros(String login, String password, LoginActivity loginActivity) {
        this.login = login;
        this.password = password;
        this.loginActivity = loginActivity;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public LoginActivity getLoginActivity() {
        return loginActivity;
    }
}
