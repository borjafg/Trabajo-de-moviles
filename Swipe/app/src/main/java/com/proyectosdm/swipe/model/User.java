package com.proyectosdm.swipe.model;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class User {

    private String login;
    private String password;
    private String nombre;

    public User() {

    }

    public User(String login, String password, String nombre) {
        setLogin(login);
        setNombre(nombre);
        setPassword(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}