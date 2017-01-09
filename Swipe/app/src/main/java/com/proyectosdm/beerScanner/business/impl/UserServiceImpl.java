package com.proyectosdm.beerScanner.business.impl;

import com.proyectosdm.beerScanner.business.UserService;
import com.proyectosdm.beerScanner.business.impl.params.LoginParams;
import com.proyectosdm.beerScanner.business.impl.params.RegistroParams;
import com.proyectosdm.beerScanner.business.impl.util.ManejadorRespuesta;
import com.proyectosdm.beerScanner.business.util.ErrorPeticionException;
import com.proyectosdm.beerScanner.infrastructure.ServiceFactory;
import com.proyectosdm.beerScanner.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class UserServiceImpl implements UserService {

    @Override
    public User login(String login, String password) throws ErrorPeticionException {
        try {
            User usuario = null;

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.setErrorHandler(new ManejadorRespuesta());
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            // Parametros de la peticion
            LoginParams params = new LoginParams(login, password);

            final String URL = ServiceFactory.BASE_URL + "/login";
            usuario = restTemplate.postForObject(URL, params, User.class);

            return usuario;
        }

        catch (RestClientException rce) {
            throw new ErrorPeticionException("Ha ocurrido un error al procesar su petición");
        }
    }

    @Override
    public void registrarse(User usuario) throws ErrorPeticionException {
        try {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.setErrorHandler(new ManejadorRespuesta());
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            // Parametros de la peticion
            RegistroParams params = new RegistroParams(usuario.getNombre(), usuario.getLogin(), usuario.getPassword());

            final String URL = ServiceFactory.BASE_URL + "/registrarse";
            restTemplate.postForObject(URL, params, User.class);
        }

        catch (RestClientException rce) {
            throw new ErrorPeticionException("Ha ocurrido un error al procesar su petición");
        }
    }
}