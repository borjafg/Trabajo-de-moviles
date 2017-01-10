package com.proyectosdm.beerScanner.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class User implements Parcelable {

    private String login;
    private String password;
    private String nombre;

    public User() {

    }

    protected User(Parcel in) {
        login = in.readString();
        password = in.readString();
        nombre = in.readString();
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(password);
        dest.writeString(nombre);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}