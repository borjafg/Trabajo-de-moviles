package com.proyectosdm.beerScanner.business.impl.params;

public class LoginParams {

    private String login;
    private String password;

    public LoginParams() {
    }

    public LoginParams(String login, String password) {
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