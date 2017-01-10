package com.proyectosdm.beerScanner.business.impl;

import com.proyectosdm.beerScanner.business.HistorialService;
import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

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
