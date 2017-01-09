package com.proyectosdm.beerScanner.business.impl;

import android.util.Log;

import com.proyectosdm.beerScanner.business.SugerenciaService;
import com.proyectosdm.beerScanner.business.impl.params.SugerenciaParams;
import com.proyectosdm.beerScanner.business.impl.util.ManejadorRespuesta;
import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.Cerveza;
import com.proyectosdm.beerScanner.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class SugerenciaServiceImpl implements SugerenciaService{

    @Override
    public Cerveza obtenerSugerencia(User usuario) throws ErrorPeticionException {
        try {
            Cerveza cerveza = null;

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.setErrorHandler(new ManejadorRespuesta());
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            // Parametros de la peticion
            SugerenciaParams params = new SugerenciaParams(usuario.getLogin(), usuario.getPassword());

            final String URL = ServiceFactory.BASE_URL + "/cerveza_sugerida";
            cerveza = restTemplate.postForObject(URL, params, Cerveza.class);

            return cerveza;
        }

        catch (RestClientException rce) {
            throw new ErrorPeticionException("Ha ocurrido un error al procesar su petición");
        }
    }
}
