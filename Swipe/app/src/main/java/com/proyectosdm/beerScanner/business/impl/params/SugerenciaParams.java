package com.proyectosdm.beerScanner.business.impl.params;

public class SugerenciaParams {

    private String login;
    private String password;

    public SugerenciaParams() {
    }

    public SugerenciaParams(String login, String password) {
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
