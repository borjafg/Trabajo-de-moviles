package com.proyectosdm.swipe.business.util;

/**
 * Created by Alberto Cortina on 05/01/2017.
 */

public class ErrorPeticionException extends RuntimeException {

    private String causa;

    public ErrorPeticionException(String causa) {
        this.causa = causa;
    }

    public String getCausa() {
        return causa;
    }

}