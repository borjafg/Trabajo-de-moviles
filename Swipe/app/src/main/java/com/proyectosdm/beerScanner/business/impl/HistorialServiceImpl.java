package com.proyectosdm.beerScanner.business.impl;

import com.proyectosdm.beerScanner.business.HistorialService;
import com.proyectosdm.beerScanner.business.impl.params.EscanerParams;
import com.proyectosdm.beerScanner.business.impl.params.HistorialParams;
import com.proyectosdm.beerScanner.business.impl.params.LoginParams;
import com.proyectosdm.beerScanner.business.impl.util.ManejadorRespuesta;
import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class HistorialServiceImpl implements HistorialService{

    @Override
    public List<Cerveza> obtenerHistorial(User usuario) throws ErrorPeticionException {
        try {
            List<Cerveza> cervezas = null;

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.setErrorHandler(new ManejadorRespuesta());
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            // Parametros de la peticion
            HistorialParams params = new HistorialParams(usuario.getLogin(), usuario.getPassword());

            final String URL = ServiceFactory.BASE_URL + "/historial";
            cervezas = restTemplate.postForObject(URL, params, Cerveza.class);

            return cervezas;
        }

        catch (RestClientException rce) {
            throw new ErrorPeticionException("Ha ocurrido un error al procesar su petición");
        }
    }
}