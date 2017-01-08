package com.proyectosdm.swipe.business;

import android.content.Context;

import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.model.User;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public interface UserService {

    User login(String login, String password) throws ErrorPeticionException;

    void registrarse(User usuario) throws ErrorPeticionException;

}
