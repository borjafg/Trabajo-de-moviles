package com.proyectosdm.beerScanner.business.impl.params;

public class RegistroParams {

    private String nombre;
    private String login;
    private String password;

    public RegistroParams() {
    }

    public RegistroParams(String nombre, String login, String password) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
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
}
