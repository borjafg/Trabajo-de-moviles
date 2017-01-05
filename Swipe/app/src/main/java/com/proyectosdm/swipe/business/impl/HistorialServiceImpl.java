package com.proyectosdm.swipe.business.impl;

import com.proyectosdm.swipe.business.HistorialService;
import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.model.Cerveza;
import com.proyectosdm.swipe.model.User;

import java.util.List;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class HistorialServiceImpl implements HistorialService{

    @Override
    public List<Cerveza> obtenerHistorial(User usuario) throws ErrorPeticionException {
        //Conexión con el web service, convertir a una lista en formato java y devovlerla
        return null;
    }
}
