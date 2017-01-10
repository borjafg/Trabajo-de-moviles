package com.proyectosdm.beerScanner.business;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public interface SugerenciaService {

    public Cerveza obtenerSugerencia(User usuario) throws ErrorPeticionException;
}
