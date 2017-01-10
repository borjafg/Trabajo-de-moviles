package com.proyectosdm.beerScanner.business.impl;

import com.proyectosdm.beerScanner.business.EscanerService;
import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

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