package com.proyectosdm.beerScanner.business;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

import java.util.List;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public interface HistorialService {

    public List<Cerveza> obtenerHistorial(User usuario) throws ErrorPeticionException;
}
