package com.proyectosdm.swipe.infrastructure;

import com.proyectosdm.swipe.business.EscanerService;
import com.proyectosdm.swipe.business.HistorialService;
import com.proyectosdm.swipe.business.SugerenciaService;
import com.proyectosdm.swipe.business.UserService;
import com.proyectosdm.swipe.business.impl.EscanerServiceImpl;
import com.proyectosdm.swipe.business.impl.HistorialServiceImpl;
import com.proyectosdm.swipe.business.impl.SugerenciaServiceImpl;
import com.proyectosdm.swipe.business.impl.UserServiceImpl;
import com.proyectosdm.swipe.model.Cerveza;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class ServiceFactory {

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
