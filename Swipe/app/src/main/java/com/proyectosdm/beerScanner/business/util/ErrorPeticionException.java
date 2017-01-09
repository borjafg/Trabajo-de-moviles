package com.proyectosdm.beerScanner.business.util;

public class ErrorPeticionException extends RuntimeException {

    private String causa;

    public ErrorPeticionException(String causa) {
        this.causa = causa;
    }

    public String getCausa() {
        return causa;
    }
}