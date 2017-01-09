package com.proyectosdm.beerScanner.ui.tareas.login;

import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.LoginActivity;

public class TareaLoginResultado {

    private LoginActivity loginActivity;
    private User user;
    private String causaError; // Solo si user es null

    public TareaLoginResultado(LoginActivity loginActivity, User user, String causaError) {
        this.loginActivity = loginActivity;
        this.user = user;
        this.causaError = causaError;
    }

    public LoginActivity getLoginActivity() {
        return loginActivity;
    }

    public User getUser() {
        return user;
    }

    public String getCausaError() {
        return causaError;
    }
}