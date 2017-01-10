package com.proyectosdm.beerScanner.business.impl;

import com.proyectosdm.beerScanner.business.EscanerService;
import com.proyectosdm.beerScanner.business.impl.params.EscanerParams;
import com.proyectosdm.beerScanner.business.impl.params.LoginParams;
import com.proyectosdm.beerScanner.business.impl.util.ManejadorRespuesta;
import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class EscanerServiceImpl implements EscanerService {

    @Override
    public Cerveza obtenerDatosCerveza(String codigoQR, User usuario) throws ErrorPeticionException{
        try {
            Cerveza cerveza = null;

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.setErrorHandler(new ManejadorRespuesta());
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            // Parametros de la peticion

            LoginParams params = new LoginParams(usuario.getLogin(), usuario.getPassword());
            EscanerParams paramsFinal = new EscanerParams(codigoQR, params);

            final String URL = ServiceFactory.BASE_URL + "/cerveza_info";
            cerveza = restTemplate.postForObject(URL, paramsFinal, Cerveza.class);

            return cerveza;
        }

        catch (RestClientException rce) {
            throw new ErrorPeticionException("Ha ocurrido un error al procesar su petición");
        }
    }
}