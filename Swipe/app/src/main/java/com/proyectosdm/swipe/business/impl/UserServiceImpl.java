package com.proyectosdm.swipe.business.impl;

import com.proyectosdm.swipe.business.UserService;
import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.model.User;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class UserServiceImpl implements UserService {

    @Override
    public User login(String login, String password) throws ErrorPeticionException {
        User usuario = null;

        // Conexion y sacar datos del web service

        return usuario;
    }

    @Override
    public void registrarse(User usuario) throws ErrorPeticionException {
        // Conexion y enviar datos del web service
    }
}