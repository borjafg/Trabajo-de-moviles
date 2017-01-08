package com.proyectosdm.swipe.business.impl;

import android.util.Log;

import com.proyectosdm.swipe.business.UserService;
import com.proyectosdm.swipe.business.impl.params.LoginParams;
import com.proyectosdm.swipe.business.impl.util.ManejadorRespuesta;
import com.proyectosdm.swipe.business.util.ErrorPeticionException;
import com.proyectosdm.swipe.infrastructure.ServiceFactory;
import com.proyectosdm.swipe.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
        // Conexion y enviar datos del web service
    }

    @Override
    public User cambiarContraseña(User usuario, String nuevaContraseña) {
        return null;
    }
}