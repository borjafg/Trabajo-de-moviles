package com.proyectosdm.beerScanner.business.impl.params;

/**
 * Created by Alberto Cortina on 10/01/2017.
 */
public class HistorialParams {

    private String login;
    private String password;

    public HistorialParams() {

    }

    public HistorialParams(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
