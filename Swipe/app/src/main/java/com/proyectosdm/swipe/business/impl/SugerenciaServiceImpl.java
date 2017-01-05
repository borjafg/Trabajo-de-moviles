package com.proyectosdm.swipe.business.impl;

import com.proyectosdm.swipe.business.SugerenciaService;
import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.model.Cerveza;
import com.proyectosdm.swipe.model.User;

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
