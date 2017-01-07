package com.proyectosdm.swipe.business;

import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.model.User;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public interface UserService {

    public User login(String login, String password) throws ErrorPeticionException;

    public void registrarse(User usuario) throws ErrorPeticionException;

    public User cambiarContraseña(User usuario, String nuevaContraseña);

}
