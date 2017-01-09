package com.proyectosdm.beerScanner.business;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

public interface EscanerService {

    Cerveza obtenerDatosCerveza(String codigoQR, User usuario) throws ErrorPeticionException;
}
