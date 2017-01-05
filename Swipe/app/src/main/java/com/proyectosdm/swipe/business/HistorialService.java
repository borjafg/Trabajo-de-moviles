package com.proyectosdm.swipe.business;

import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.model.Cerveza;
import com.proyectosdm.swipe.model.User;

import java.util.List;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public interface HistorialService {

    public List<Cerveza> obtenerHistorial(User usuario) throws ErrorPeticionException;
}
