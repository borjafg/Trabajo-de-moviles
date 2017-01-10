package com.proyectosdm.beerScanner.business.impl;

import com.proyectosdm.beerScanner.business.SugerenciaService;
import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class SugerenciaServiceImpl implements SugerenciaService{

    @Override
    public Cerveza obtenerSugerencia(User usuario) throws ErrorPeticionException {
        Cerveza cerveza = null;
        //Conexion con web service y pedir sugenreica, convertir la respuesta en un objeto cerveza y devolver
        return cerveza;
    }
}
