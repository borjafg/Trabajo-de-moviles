package com.proyectosdm.swipe.business.impl.util;

import android.util.Log;

import com.proyectosdm.swipe.business.util.ErrorPeticionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by Alberto Cortina on 07/01/2017.
 */

public class ManejadorRespuesta implements ResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse clienthttpresponse)
            throws IOException {

        try {
            String error = parseToString(clienthttpresponse.getBody());

            JSONObject json = new JSONObject(error);

            String causa = json.getString("causa");

            throw new ErrorPeticionException(causa);
        }

        catch(JSONException js) {
            throw new ErrorPeticionException("Ha ocurrido un error al gestionar su peticion");
        }

    }

    @Override
    public boolean hasError(ClientHttpResponse clienthttpresponse)
            throws IOException {

        if (clienthttpresponse.getStatusCode() != HttpStatus.OK) {
            return true;
        }

        return false;
    }

    private String parseToString(InputStream stream) {
        try {
            BufferedInputStream bis = new BufferedInputStream(stream);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();

            int result = bis.read();

            while (result != -1) {
                buf.write((byte) result);
                result = bis.read();
            }

            return buf.toString();
        }

        catch(IOException ex) {
            return "Ha ocurrido un error al gestionar su peticion";
        }
    }

}