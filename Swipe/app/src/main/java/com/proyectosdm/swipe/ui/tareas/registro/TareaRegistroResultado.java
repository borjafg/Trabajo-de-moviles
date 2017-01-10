package com.proyectosdm.swipe.ui.tareas.registro;

import com.proyectosdm.swipe.model.User;
import com.proyectosdm.swipe.ui.MainActivity;

/**
 * Created by Alberto Cortina on 10/01/2017.
 */

public class TareaRegistroResultado {

    private MainActivity mainActivity;

    private User user;

    private String causaError; // Solo si user es null

    public TareaRegistroResultado(MainActivity mainActivity, User user, String causaError) {
        this.mainActivity = mainActivity;
        this.user = user;
        this.causaError = causaError;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public User getUser() {
        return user;
    }

    public java.lang.String getCausaError() {
        return causaError;
    }
}
