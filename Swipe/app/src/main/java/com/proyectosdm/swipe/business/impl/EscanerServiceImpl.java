package com.proyectosdm.swipe.business.impl;

import com.proyectosdm.swipe.business.EscanerService;
import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.model.Cerveza;
import com.proyectosdm.swipe.model.User;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class EscanerServiceImpl implements EscanerService {

    @Override
    public Cerveza obtenerDatosCerveza(String codigoQR, User usuario) throws ErrorPeticionException{
        Cerveza cerveza = null;
        //Conexion con web service, pedir datos cerveza, crear objeto cerveza y devolver cerveza
        return cerveza;
    }
}