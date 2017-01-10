package com.proyectosdm.beerScanner.business.impl.params;

public class EscanerParams {

    private String codigo_cerveza;

    private LoginParams usuario;

    public EscanerParams() {

    }

    public EscanerParams(String codigo_cerveza, LoginParams usuario) {
        this.codigo_cerveza = codigo_cerveza;
        this.usuario = usuario;
    }

    public String getCodigo_cerveza() {
        return codigo_cerveza;
    }

    public LoginParams getUsuario() {
        return usuario;
    }
}