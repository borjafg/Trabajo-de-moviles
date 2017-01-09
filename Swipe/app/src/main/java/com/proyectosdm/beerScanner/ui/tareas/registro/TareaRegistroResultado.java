package com.proyectosdm.beerScanner.ui.tareas.registro;

import com.proyectosdm.beerScanner.model.User;
import com.proyectosdm.beerScanner.ui.RegistroActivity;

public class TareaRegistroResultado {

    private RegistroActivity registroActivity;
    private User user;
    private String causaError; // Solo si user es null

    public TareaRegistroResultado(RegistroActivity registroActivity, User user, String causaError) {
        this.registroActivity = registroActivity;
        this.user = user;
        this.causaError = causaError;
    }

    public RegistroActivity getRegistroActivity() {
        return registroActivity;
    }

    public User getUser() {
        return user;
    }

    public java.lang.String getCausaError() {
        return causaError;
    }
}
