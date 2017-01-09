package com.proyectosdm.beerScanner.business;

import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

import java.util.List;

public interface HistorialService {

    List<Cerveza> obtenerHistorial(User usuario) throws ErrorPeticionException;
}
