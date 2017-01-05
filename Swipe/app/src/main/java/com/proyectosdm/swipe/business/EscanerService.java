package com.proyectosdm.swipe.business;

import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.model.Cerveza;
import com.proyectosdm.swipe.model.User;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public interface EscanerService {

    public Cerveza obtenerDatosCerveza(String codigoQR, User usuario) throws ErrorPeticionException;
}
