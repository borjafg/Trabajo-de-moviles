package com.proyectosdm.beerScanner.business;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.model.User;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public interface UserService {

    User login(String login, String password) throws ErrorPeticionException;

    void registrarse(User usuario) throws ErrorPeticionException;

}