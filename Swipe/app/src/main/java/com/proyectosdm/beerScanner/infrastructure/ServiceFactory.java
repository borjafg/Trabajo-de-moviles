package com.proyectosdm.beerScanner.infrastructure;

import com.proyectosdm.beerScanner.business.EscanerService;
import com.proyectosdm.beerScanner.business.HistorialService;
import com.proyectosdm.beerScanner.business.SugerenciaService;
import com.proyectosdm.beerScanner.business.UserService;
import com.proyectosdm.beerScanner.business.impl.EscanerServiceImpl;
import com.proyectosdm.beerScanner.business.impl.HistorialServiceImpl;
import com.proyectosdm.beerScanner.business.impl.SugerenciaServiceImpl;
import com.proyectosdm.beerScanner.business.impl.UserServiceImpl;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class ServiceFactory {

    public static String BASE_URL = "https://web-service-sdm-repositorio.herokuapp.com";

    public static UserService getUserService() {
        return new UserServiceImpl();
    }

    public static EscanerService getEscanerService() {
        return new EscanerServiceImpl();
    }

    public static HistorialService getHistorialService() {
        return  new HistorialServiceImpl();
    }

    public static SugerenciaService getSugerenciaService() {
        return new SugerenciaServiceImpl();
    }
}
