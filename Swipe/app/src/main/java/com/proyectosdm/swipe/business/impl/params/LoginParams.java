package com.proyectosdm.swipe.business.impl.params;

/**
 * Created by Alberto Cortina on 07/01/2017.
 */

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